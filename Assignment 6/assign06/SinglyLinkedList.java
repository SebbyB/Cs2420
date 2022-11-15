package assign06;
//package com.assign05.assign06;


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

	/**
	 * Deletes first element in SinglyLinked List
	 * @return - Value of Element Deleted
	 * @throws NoSuchElementException - If the list is empty there is nothing to delete: throw exception.
	 */
	@Override
	public E deleteFirst() throws NoSuchElementException {
		/**
		 * If the list is empty throw.
		 */
		if(this.isEmpty()) {
			throw new NoSuchElementException();
		}
		/**
		 * Otherwise, decrease the size of the list and get the data from head, Stored as dataDelete.
		 * If the list will be empty after deleting the head, set the head to null.
		 */
		size--;
		E dataDelete = head.data;
		if(head.next == null) {

			head = null;
			return dataDelete;
		}
		/**
		 * Otherwise, move the head.
		 */
		else{
		Node newNode = head.next;
		head = newNode;

		//Return dataDelete.
		return dataDelete;}
	}

	/**
	 * Deletes an element at an index.
	 * @param index - the specified position
	 * @return - value of delete element.
	 * @throws IndexOutOfBoundsException - if index out of bounds throw.
	 */
	@Override
	public E delete(int index) throws IndexOutOfBoundsException {

		/**
		 * Checks if the index is out of bounds. Throws if it does.
		 */
		if(index > size-1 || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		/**
		 * Instantiates an iterator using the list.
		 * Stores data as object.
		 */
		Iterator<E> iter = new LinkedListIterator(head);
		E checkData = get(index);

		/**
		 * Goes through and deletes data from list using iterator.
		 * Then Returns.
		 */
		while (iter.hasNext()) {
			if(iter.next() == checkData) {
				iter.remove();
			}
		}
		return checkData;
	}

	/**
	 * Finds index of element.
	 * @param element - the element to search for
	 * @return index within the linked list that the object is in.
	 */
	@Override
	public int indexOf(E element){
		/**
		 * Initiates iterator at the head. Keeps track of index and loops through iterator.
		 * if the data at any index is the element return index.
		 * If not in list return -1.
		 */

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

	/**
	 * Gets size of linked list.
	 * @return integer value of size.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Checks if the list is empty.
	 * @return true if empty, false if not empty.
	 */
	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	/**
	 * Clears the list by setting head to null and size to 0;
	 */
	@Override
	public void clear() {
		head = null;
		size = 0;

	}

	/**
	 * Changes linkedList into Object Array using Iterator.
	 * @return Array of Objects.
	 */
	@Override
	public Object[] toArray() {
		/**
		 * Initializes Object Array of size.
		 * Initializes iterator with head.
		 * loops through and copies data from LinkedList to Array at every index.
		 * returns Object Array
		 */
		Object[] returnArray =  new Object[size];	
		Iterator<E> iter = new LinkedListIterator(head);
		if(returnArray.length>0) {
		for (int i = 0; i < size; i++) {
			returnArray[i] = iter.next();
			}
		}
		return returnArray;
	}

	/**
	 * initializes an iterator for a LinkedList.
	 * @return Iterator.
	 */
	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator(head);
	}

}
