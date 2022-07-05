
/**
 * Represents a registration request, which includes attributes for the data
 * contained in the request.txt input file.
 *
 * 
 */
public class Request<E> implements Comparable<E> {
	public String studentName, studentDept, studentLevel, courseDept;
	public int courseNumber;

	/**
	 * Constructor
	 * 
	 * @param studentName  name of student for request
	 * @param studentDept  student's major
	 * @param studentLevel student's grade level
	 * @param courseDept   department of course
	 * @param courseNumber number for course
	 */
	public Request(String studentName, String studentDept, String studentLevel, String courseDept, int courseNumber) {
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.studentLevel = studentLevel;
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
	}

	/**
	 * @param data contains the info for request to be compared to
	 * @return -1 if data is higher priority than the request calling compareTo, 0
	 *         if they are equal, and 1 if data is lower priority.
	 */
	@Override
	public int compareTo(E data) {
		Request other = (Request) data;
		String level1 = other.studentLevel;
		String level2 = this.studentLevel;
		int otherLevel = other.yearsFromGraduation(level1);
		int currentLevel = this.yearsFromGraduation(level2);
		if ((other.courseDept.equals(other.studentDept)) && (!this.studentDept.equals(this.courseDept))) {
			return -1;
		}
		if ((!other.courseDept.equals(other.studentDept)) && (this.studentDept.equals(this.courseDept))) {
			return 1;
		}
		if ((other.courseDept.equals(other.studentDept)) && (this.studentDept.equals(this.courseDept))) {

			if (otherLevel < currentLevel) {
				return -1;
			}
			if (otherLevel > currentLevel) {
				return 1;
			}
			if (otherLevel == currentLevel) {
				return 0;
			}
		}
		return 0;
	}

	/**
	 * Returns number of years to graduation (0 for seniors, 1 for juniors etc.).
	 * This is determined from the student�s level � senior, junior, etc.
	 * 
	 * @param level grade level of student
	 * @return Number of years student is from graduation
	 * 
	 * 
	 *         - Hope
	 */
	public int yearsFromGraduation(String level) {
		if (level.compareTo("Senior") == 0) {
			return 0;
		}
		if (level.compareTo("Junior") == 0) {
			return 1;
		}
		if (level.compareTo("Sophomore") == 0) {
			return 2;
		}
		if (level.compareTo("Freshman") == 0) {
			return 3;
		} else {
			System.out.println("-1");
			return -1;
		}
	}

	/**
	 * Converts request data into string format
	 * 
	 * @return Request in String format - Hope
	 */
	@Override
	public String toString() {
		String formatString = String
				.format(studentName + "," + studentDept + "," + studentLevel + "," + courseDept + "," + courseNumber);
		return formatString;
	}
}
