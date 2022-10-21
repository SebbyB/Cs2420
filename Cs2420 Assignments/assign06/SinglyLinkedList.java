//package assign06;
package com.assign05.assign06;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SinglyLinkedList Data Structure Implemented with List Interface
 * @author Sebastian Barney, Amelia Neilson.
 * @version October 20th, 2022
 *
 * @param <E> - the type of elements contained in the SinglyLinked List
 */
public class SinglyLinkedList<E> implements List<E> {


	/**
	 * Keeps track of the First Element in the list as a Node, called head.
	 * Initial size of the list is always 0, since the list is empty.
	 */
	Node head = null;
	int size = 0;

	/**
	 * Constructor for a Singly Linked List. Empty.
	 */
	public SinglyLinkedList() {
	}

	/**
	 * Node Class. Stores Data and the next Node in the List...
	 */
	private class Node {
		E data;
		Node next;

		/**
		 * Node Constructor that takes an Element of data and stores it within the node. Sets Next value to null by default.
		 * If node isn't connected to list, Data gets picked up by garbage collector.
		 * @param d - data contained in Node.
		 */
		Node(E d) {
			data = d;
			next = null;
		}
	}


	/**
	 * Iterator for LinkedList Data Structure. Creates three Nodes: Previous, Current, and Next.
	 * Allows for removal of data.
	 */
	private class LinkedListIterator implements Iterator<E> {
		Node previous;
		Node current;
		Node next;
		boolean canRemove;

		/**
		 * Constructor for Iterator.
		 * @param head - Head of the list iterator is applied to.
		 * Sets 0 index to head of the list.
		 */
		public LinkedListIterator(Node head) {
			previous = null;
			current = null;
			next = head;
			canRemove = false;
		}

		/**
		 * Checks to see if there is a next item in the iterator's sequence
		 */
		public boolean hasNext() {
			return next != null;
		}

		/**
		 * Retrieves the next item within the iterated/sequenced array
		 * 
		 * @return T The next item within the iterated/sequenced array
		 * @throws NoSuchElementException if next is used at the end of the iterated
		 *                                sequence
		 */
		public E next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				canRemove = true;
				previous = current;
				current = next;
				next = next.next;
			}
			return current.data;
		}

		/**
		 * Removes the last retrieved item within the iterated/sequenced array
		 *
		 * @throws IllegalStateException if remove is used without next() preceding it
		 *                               (either initially or consecutively)
		 */
		public void remove() throws IllegalStateException {
			/**
			 * Checks if Node is the head.
			 */
			if (previous == null && canRemove) {
				canRemove = false;
				deleteFirst();
				}
			/**
			 * General removal...
			 */
			else if (hasNext() && canRemove) {
				canRemove = false;
				previous.next = current.next;
				size--;
				/**
				 * Checks if Node is the last node.
				 */
			} else if (!hasNext() && canRemove) {
				canRemove = false;
				previous.next = null;
				size--;
			} else {

				throw new IllegalStateException();
			}
		}

	}

	/**
	 * Inserts element to beginning of the list.
	 * @param element - the element to add
	 */
	@Override
	public void insertFirst(E element) {
		/**
		 * Checks if the head is null, If it is, creates a new head node.
		 */
		if (head == null) {
			head = new Node(element);
		}
		/**
		 *If it has a head node, creates a new Node with the Element and pointer data of the previous head.
		 * Reassigns the Element Data of the head to the new Element Data to be added.
		 * Adds pointer to old head.
		 */
		else {
			Node temp = new Node(head.data);
			temp.next = head.next;
			head.next = temp;
			head.data = element;
		}
		size++;

	}


	/**
	 * Inserts an Element at an Index within the SinglyLinkedList.
	 * @param index - the specified position
	 * @param element - the element to add
	 * @throws IndexOutOfBoundsException - If the Index is outside the SinglyLinkedList throws exception.
	 */
	@Override
	public void insert(int index, E element) throws IndexOutOfBoundsException {

		/**
		 * Checks if the Index is within the bounds. If not, Throws Exception.
		 */
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		/**
		 * Checks if the index is 0, it should insert it at the beginning.
		 */
		if (index == 0) {
			insertFirst(element);
			return;
		}
		/**
		 * <p>
		 * Checks if the Index is equal to the size, and if it is the index is the last element.
		 * It should add it to the end of the list.
		 * </p>
		 */
		if (index == size) {
			Node endAddition = head;
			while (endAddition.next != null) {
				endAddition = endAddition.next;
			}
			endAddition.next = new Node(element);
			size++;
			return;
		}

		/**
		 * <p>
		 * Creates a Current and Insert Node. Current Node will be the Head of the List. Insert Node will be a New node with the Element Data to be Inserted.
		 * Goes forward in the list until the index is where we want it.
		 * Inserts the node In between the two Nodes next to it.
		 * </p>
		 */
		Node currentNode = head;
		int indexOfElement = 0;
		while (indexOfElement < index-1) {
			currentNode = currentNode.next;
			indexOfElement++;
		}
		Node insertedNode = new Node(element);
		insertedNode.next = currentNode.next;
		currentNode.next = insertedNode;
		size++;

	}


	/**
	 * Gets the First Element of the List.
	 * @return - First Element of the List.
	 * @throws NoSuchElementException - If the List is Empty Throws Exception.
	 */
	@Override
	public E getFirst() throws NoSuchElementException {
		/**
		 * Checks if the List is Empty. If it is, Throws Exception.
		 */
		if(this.isEmpty()) {
			throw new NoSuchElementException();
		}
		/**
		 * Returns data contained in head of list. (First Item)
		 */
		return head.data;
	}

	/**
	 * Gets the Element Data at a Specific Index.
	 * @param index - the specified position
	 * @return - Element Data of Node.
	 * @throws IndexOutOfBoundsException If the Index isn't within the bounds of the list, throws Exception.
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {

		/**
		 *
		 */
		if (index > size-1 || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Node retNode = head;
		if(index == 0) {
			return head.data;
		}
		else {
		for (int i = 0; i < index; i++) {
			if(retNode.next != null) {
				retNode = retNode.next;
			}
		}
	
		return retNode.data;
	}}

	@Override
	public E deleteFirst() throws NoSuchElementException {
		if(this.isEmpty()) {
			throw new NoSuchElementException();
		}
		size--;
		if(head.next == null) {
			E dataDelete = head.data;
			head = null;
			return dataDelete;
		}
		Node newNode = head.next;
		E dataDelete = head.data;
		head = newNode;

		return dataDelete;
	}

	@Override
	public E delete(int index) throws IndexOutOfBoundsException {

		if(index > size-1 || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Iterator<E> iter = new LinkedListIterator(head);
		
		E checkData = get(index);
		
		while (iter.hasNext()) {
			if(iter.next() == checkData) {
				iter.remove();
			}
		}
		return checkData;
	}

	@Override
	public int indexOf(E element){
		Iterator<E> iter = new LinkedListIterator(head);
		int indexOfElement = 0;
		while (iter.hasNext()) {
			if(iter.next() == element) {
				return indexOfElement;
			}
		indexOfElement++;
		}
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;

	}

	@Override
	public Object[] toArray() {
		Object[] returnArray =  new Object[size];	
		Iterator<E> iter = new LinkedListIterator(head);
		if(returnArray.length>0) {
		for (int i = 0; i < size; i++) {
			returnArray[i] = iter.next();
			}
		}
		return returnArray;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator(head);
	}

}
