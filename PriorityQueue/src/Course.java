
import java.util.ArrayList;

/**
 * 
 * Represents a course object which includes attributes for the data contained
 * in the courses.txt file, along with a list of enrolled students for that
 * course
 * 
 * - Hope
 */
public class Course implements ICourse {
	private String courseDept;
	private int courseNumber, capacity, numStudents = 0;
	private ArrayList<String> students;

	/**
	 * Constructor
	 * 
	 * @param courseDept   department of course
	 * @param courseNumber number for the course
	 * @param capacity     maximum number of students
	 */
	public Course(String courseDept, int courseNumber, int capacity) {
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		this.capacity = capacity;
		this.students = new ArrayList<>();
	}

	public Course(String courseDept, int courseNumber) {
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
	}

	/**
	 * Determines if the capacity for this course has been reached.
	 * 
	 * @return Return false if capacity hasn't been reached, Return true if it has
	 * 
	 *         - Hope
	 */
	@Override
	public boolean isFull() {
		if (numStudents >= capacity) {
			return true;
		}
		return false;
	}

	/**
	 * Add a student to the arraylist for enrolled students for this course.
	 * 
	 * @param name Name of the student to be added to arraylist
	 * 
	 *             - Hope
	 */
	@Override
	public void addStudent(String name) {
		students.add(name);
		numStudents++;
	}

	/**
	 * Prints the classlist for this course.
	 * 
	 * - Hope
	 */
	@Override
	public void printClassList() {
		System.out.println("\r\nClass List for " + this.courseDept + " " + this.courseNumber);
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i));
		}
	}

	/**
	 * Determines if this course object is the same as the object received as
	 * parameter.
	 * 
	 * @param arg0 Object being compared
	 * @return Return true if objects are equal, Return false if they are not
	 */
	@Override
	public boolean equals(Object arg0) {
		if (this.courseDept.equalsIgnoreCase(((Course) arg0).courseDept)) {
			if (this.courseNumber == ((Course) arg0).courseNumber) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method to retrieve course department
	 * 
	 * @return courseDept
	 */
	public String getCourseDept() {
		return courseDept;
	}

	/**
	 * Method to retrieve course number
	 * 
	 * @return courseNumber
	 */
	public int getCourseNum() {
		return courseNumber;
	}

	/**
	 * Format course info as String
	 * 
	 * @return string containing course department, number, and capacity
	 */
	@Override
	public String toString() {
		return this.courseDept + ", " + this.courseNumber + ", " + this.capacity;
	}
}
