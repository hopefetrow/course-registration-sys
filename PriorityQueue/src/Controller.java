
import java.util.*;
import java.io.*;

/**
 * This class works with the other classes to process course registration for
 * students. It is responsible for the following: 1.) adding new requests from
 * the requests file. 2.) processing all of the requests (registering students
 * where this is possible, and 3.) printing out the class list for all courses.
 *
 */
public class Controller implements IController {
	public PriorityQueue<Request> requestQueue;
	ArrayList<Course> courses;
	BufferedReader fileIn;
	BufferedReader fileIn1;

	/**
	 * Constructor
	 * 
	 * @param requestQueue Priority Queue
	 * @param courses      ArrayList containing courses
	 * @param fileIn       File containing courses
	 * @param fileIn1      File containing requests
	 * 
	 *                     - Hope
	 */
	public Controller(PriorityQueue<Request> requestQueue, ArrayList<Course> courses, BufferedReader fileIn,
			BufferedReader fileIn1) {
		this.requestQueue = requestQueue;
		this.courses = courses;
		this.fileIn = fileIn;
		this.fileIn1 = fileIn1;
	}

	/**
	 * Reads courses from input file and adds each course to an arraylist of
	 * courses.
	 * 
	 * - Hope
	 */
	@Override
	public void readCourseFile() {
		try {
			String line = fileIn.readLine();
			while (line != null) {
				System.out.println(line);
				String[] courseData = line.split(",");
				String courseDept = courseData[0];
				int courseNumber = Integer.parseInt(courseData[1]);
				int capacity = Integer.parseInt(courseData[2]);
				courses.add(new Course(courseDept, courseNumber, capacity));
				line = fileIn.readLine();
			}
			fileIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read each request from the request input file and use it to create a Request
	 * object.
	 * 
	 * 
	 * -Hope
	 */
	@Override
	public void readRequestFile() {
		try {
			String line = fileIn1.readLine();
			while (line != null) {
				String[] requestData = line.split(",");
				String studentName = requestData[0];
				String studentLevel = requestData[1].trim();
				String studentMajor = requestData[2];
				String courseDept = requestData[3];
				int courseNumber = Integer.parseInt(requestData[4]);
				Request newRequest = new Request(studentName, studentMajor, studentLevel, courseDept, courseNumber);
				requestQueue.enqueue(newRequest);
				line = fileIn1.readLine();
			}
			fileIn1.close();
		} catch (IOException e) {
			System.out.println("An error occurred while trying to read from requestFile");
		}
	}

	/**
	 * Adds student to the list for course
	 * 
	 * @param req request to be added to course list
	 * 
	 *            -Hope
	 */
	@Override
	public void addRequest(Request req) {
		Course currentCourse = getCourse(req.courseDept, req.courseNumber);
		currentCourse.addStudent(req.studentName);

	}

	/**
	 * Processes request and if request is able to be added, then method updates
	 * classList, course capacity, and prints out that adding request was a success.
	 * If request is unable to be added then it prints out that adding request was
	 * unsuccessful. -Hope
	 */
	@Override
	public void processRequests() {
		Request temp = requestQueue.dequeue();
		Node tempNode = new Node(temp);
		while (temp != null) {
			System.out.println(tempNode + " processed.");
			Course currentCourse = getCourse(temp.courseDept, temp.courseNumber);
			if (!currentCourse.isFull()) {
				addRequest(temp);
				System.out.println(temp.studentName + " successfully registered for " + currentCourse.getCourseDept()
						+ " " + currentCourse.getCourseNum());
			} else {
				System.out.println(temp.studentName + " cannot register for " + currentCourse.getCourseDept() + " "
						+ currentCourse.getCourseNum());
			}
			temp = requestQueue.dequeue();
		}
	}

	/**
	 * Searches course arraylist for course object that has the same courseDept and
	 * courseNumber as those sent in as parameters
	 * 
	 * @param courseDept   department course is in
	 * @param courseNumber number/id for course
	 * 
	 * @return course object with data values that match the parameters received.
	 * 
	 *         -Hope
	 */
	@Override
	public Course getCourse(String courseDept, int courseNumber) {
		for (int i = 0; i < courses.size(); i++) {
			Course temp = courses.get(i);
			Course find = new Course(courseDept, courseNumber);
			if (temp.equals(find)) {
				return courses.get(i);
			}
		}
		return null;
	}

	/**
	 * Prints classlists for all courses.
	 */
	@Override
	public void printClassList() {
		for (int i = 0; i < courses.size(); i++) {
			courses.get(i).printClassList();
		}
	}

}
