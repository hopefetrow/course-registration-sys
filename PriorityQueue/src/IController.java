
public interface IController {
	/**
	 * Reads courses from input file and add each course to an arraylist of courses.
	 */
	void readCourseFile();

	/**
	 * Stores the request object in the requests priority queue.
	 */
	void readRequestFile();

	/**
	 * 
	 * @param req request to be added to course list
	 */
	void addRequest(Request req);

	/**
	 * Processes request and if request is able to be added, then method updates
	 * classList, course capacity, and prints out that adding request was a success.
	 * If request is unable to be added then it prints out that adding request was
	 * unsuccessful.
	 */
	void processRequests();

	/**
	 * 
	 * @param courseDept
	 * @param courseNumber
	 * @return Return the course object with data values that match the parameters
	 *         received.
	 */
	Course getCourse(String courseDept, int courseNumber);

	/**
	 * Prints classlists (list containing students) for all courses.
	 */
	void printClassList();

}
