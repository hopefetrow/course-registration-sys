
/**
 * This class is used to store objects for the priority Queue
 *
 */
public class Node<E> implements INode<E> {
	private Node<E> nextNode = null;
	// E headValue = null;
	E tailValue = null;
	E dataValue;

	/**
	 * Constructor I
	 * 
	 * @param dataValue contains info for request (studentName, studentMajor,
	 *                  studentLevel, courseDept, courseNumber)
	 * 
	 *                  -Hope
	 */
	public Node(E dataValue) {
		this.dataValue = dataValue;
	}

	/**
	 * Constructor II
	 * 
	 * @param dataValue contains info for request (studentName, studentMajor,
	 *                  studentLevel, courseDept, courseNumber)
	 * @param nextNode  The node that is higher in priority by 1
	 * 
	 *                  -Hope
	 */
	public Node(E dataValue, Node<E> nextNode) {
		this.dataValue = dataValue;
		setNext(nextNode);
	}

	/**
	 * Returns the data stored in this node.
	 * 
	 * @return the request data stored in this node.
	 * 
	 *         -Hope
	 */
	@Override
	public E getData() {
		return dataValue;
	}

	/**
	 * Returns the node next to this node.
	 * 
	 * @return the node higher in priority by 1
	 * 
	 *         -Hope
	 */
	@Override
	public Node<E> getNext() {
		return nextNode;
	}

	/**
	 * Sets node received as the next node to this node.
	 * 
	 * @param next the node higher in priority by 1
	 * 
	 *             -Hope
	 */
	@Override
	public void setNext(Node<E> next) {
		this.nextNode = next;
	}
}
