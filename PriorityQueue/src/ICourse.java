
public interface ICourse {
	/**
	 * Determines if the capacity for this course has been reached.
	 * 
	 * @return Return false if capacity hasn't been reached, Return true if it has
	 * 
	 */
	boolean isFull();

	/**
	 * Adds student to the ArrayList for enrolled students for this course.
	 * 
	 * @param name
	 */
	void addStudent(String name);

	/**
	 * Prints the class list for this course.
	 */
	void printClassList();

	/**
	 * Determines if this course object is the same as the object received as
	 * parameter
	 * 
	 * @param arg0 object being compared to the object calling the method
	 * @return false if they are not equal, true if they are
	 */
	@Override
	boolean equals(Object arg0);
}
