
public interface INode<E> {
	/**
	 * Returns the data stored in this node.
	 * 
	 * @return request data stored in this node.
	 */
	E getData();

	/**
	 * Returns the node next to this node.
	 * 
	 * @return the node higher in priority by 1
	 */
	Node<E> getNext();

	/**
	 * Sets node received as the next node to this node.
	 * 
	 * @param next the node higher in priority by 1
	 */
	void setNext(Node<E> next);

}
