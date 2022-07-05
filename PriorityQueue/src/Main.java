import java.io.*;
import java.util.*;

/**
 * 
 * This program implements a priority queue for registering for classes where
 * Students who are majors in the department that offers a class have priority
 * to register this class over students from other departments. After that, the
 * student who is closer to graduation has priority to register for the class.
 * For example, seniors have priority over juniors; sophomores have priority
 * over freshmen, etc.� If the priority cannot be decided by applying the above
 * rules, the �first come, first served� rule will be applied to decide who has
 * priority to register for the class.
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Request> requestQueue = new PriorityQueue<Request>();
		ArrayList<Course> courses = new ArrayList<Course>();
		BufferedReader fileIn = new BufferedReader(new FileReader("course.txt"));
		BufferedReader fileIn1 = new BufferedReader(new FileReader("request.txt"));
		IController control = new Controller(requestQueue, courses, fileIn, fileIn1);
		control.readCourseFile();
		control.readRequestFile();
		fileIn.close();
		fileIn1.close();
		control.processRequests();
		control.printClassList();
	}

}
