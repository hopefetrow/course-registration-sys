/**
 * Implements a queue data structure in which the allowable objects should
 * belong to a class that implements the Comparable interface.
 * 
 * Uses the Node class for storing objects.
 *
 */
public class PriorityQueue<E extends Comparable<?>> {
	Node<E> head = null;
	Node<E> tail = null;
	E headValue = null;

	/**
	 * Determines if the priority queue is empty.
	 * 
	 * @return True if queue is empty, False if it is not empty
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Adds object received to the priority queue taking into consideration the
	 * rules governing priority.
	 * 
	 * @param data contains Request info (studentName, sutdentDept, studentLEvel,
	 *             courseDept, courseNumber)
	 */
	public void enqueue(E data) {
		Node<E> newNode = new Node<E>(data);
		Node<E> temp = head;
		Node<E> temp2 = null;
		if (head != null) { // compare until nextNode = null or newNode has lower priority than nextNode
			while (temp != null) {
				if (((Request) temp.getData()).compareTo((Request) newNode.getData()) < 0) {
					// new node has higher priority than nextNode
					if (head.getNext() == null) { // only one Node (the head)
						head.setNext(newNode); // have head point to new node
						tail = newNode; // set new node to tail
						break;
					} else {
						temp2 = temp;
						temp = temp.getNext();
					}
					if (temp == null) { // means this node is the tail node
						temp2.setNext(newNode);
						tail = newNode;
					}
				} else if (((Request) temp.getData()).compareTo((Request) newNode.getData()) >= 0) {
					// new node has lower/equal priority
					if (temp2 == null) {
						temp2 = temp;
						head = newNode;
						head.setNext(temp2);
						break;
					}
					newNode.setNext(temp);
					temp2.setNext(newNode);
					break;
				}
			}
		} else { // head = null so this is the first one being added
			head = new Node<E>(data);
			headValue = data;
			tail = head;
		}
	}

	/**
	 * Removes the object with highest priority (at the front of the queue) from the
	 * priority queue.
	 * 
	 * @return Request from front of queue (the one with top priority)
	 */
	public E dequeue() {
		// delete the node that points to null
		// loop until nextNode == null
		Node<E> temp = head;
		if (isEmpty()) {
			return null;
		}
		if (temp.getNext() == null) {
			E data = temp.getData();
			head = null;
			tail = null;
			return data;
		}
		Node<E> temp2 = temp.getNext();
		while (temp2.getNext() != null) {
			temp2 = temp2.getNext();
			temp = temp.getNext();
		}
		Node<E> temp3 = temp2;
		temp.setNext(null);
		temp2 = null;
		tail = temp;
		return temp3.getData();
	}

}
