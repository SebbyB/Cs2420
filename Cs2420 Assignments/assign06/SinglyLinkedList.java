package com.assign05.assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E> {

	Node head = null;
	int size = 0;

	public SinglyLinkedList() {
	}
	
	private class Node {
		E data;
		Node next;

		Node(E d) {
			data = d;
			next = null;
		}
	}


	private class LinkedListIterator implements Iterator<E> {
		Node previous;
		Node current;
		Node next;
		boolean canRemove;

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
		 * Removes the last retrieved item within teh iterated/sequenced array
		 * 
		 * @throws IllegalStateException if remove is used without next() preceding it
		 *                               (either initially or consecutively)
		 */
		public void remove() throws IllegalStateException {
			if (previous == null && canRemove) {
				canRemove = false;
				deleteFirst();
				}
			else if (hasNext() && canRemove) {
				canRemove = false;
				previous.next = current.next;
				size--;
			} else if (!hasNext() && canRemove) {
				canRemove = false;
				previous.next = null;
				size--;
			} else {

				throw new IllegalStateException();
			}
		}

	}

	@Override
	public void insertFirst(E element) {
		if (head == null) {
			head = new Node(element);

		} else {
			Node temp = new Node(head.data);
			temp.next = head.next;
			head.next = temp;
			head.data = element;
		}
		size++;

	}

	@Override
	public void insert(int index, E element) throws IndexOutOfBoundsException {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			insertFirst(element);
			return;
		}
		if (index == size) {
			Node endAddition = head;
			while (endAddition.next != null) {
				endAddition = endAddition.next;
			}
			endAddition.next = new Node(element);
			size++;
			return;
		}
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

	@Override
	public E getFirst() throws NoSuchElementException {
		if(this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.data;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		
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
