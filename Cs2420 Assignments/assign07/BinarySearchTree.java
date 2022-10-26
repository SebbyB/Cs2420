//package assign07;
package com.assign05.assign07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;


public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type>{

	BinaryNode root = null;
	int size = 0;

	private class BinaryNode {
		Type data;
		BinaryNode rightChild;
		BinaryNode leftChild;

		BinaryNode(Type element) {
			data = element;
			rightChild = null;
			leftChild = null;
			
		}	
		
		public Type lastRecursive() {
		if (this.rightChild == null) {
			return this.data;
		}
		else return this.rightChild.lastRecursive();
		}	
		
		public Type firstRecursive() {
		if (this.leftChild == null) {
			return this.data;
		}
		else return this.leftChild.firstRecursive();
	}
	
	}
	@Override
	public boolean add(Type item) {
		if (root == null) {
			root = new BinaryNode(item);
			size++;
			return true;
		}
		return addRecursive(item, root);
	}
	
	public boolean addRecursive(Type item, BinaryNode currentNode) {


		if (item.compareTo(currentNode.data) < 0) {
			if (currentNode.leftChild == null) {
				currentNode.leftChild = new BinaryNode(item);
				size++;
				return true;
			}
			else{
			return addRecursive(item, currentNode.leftChild);
			}
		}
		if (item.compareTo(currentNode.data) > 0) {
			if (currentNode.rightChild == null) {
				currentNode.rightChild = new BinaryNode(item);
				size++;
				return true;
			}
			else{
			return addRecursive(item, currentNode.rightChild);
			}
		}
		return false;
	}
		
	

	@Override
	public boolean addAll(Collection<? extends Type> items) {
		
		boolean change = false;
		for(Type element: items) {
			if (this.add(element)){
				change = true;
			};
		}
		return change;
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public boolean contains(Type item) {
		return containsRecursive(item, root);
	}
	
	public boolean containsRecursive(Type item, BinaryNode current) {
		if (item.compareTo(current.data) < 0) {
			if (current.leftChild ==null) {
				return false;
			}
			else {
				return containsRecursive(item, current.leftChild);
			}
		}
		if (item.compareTo(current.data) > 0) {
			if (current.rightChild ==null) {
				return false;
			}
			else {
				return containsRecursive(item, current.rightChild);
			}
		}
		return true;
	}

	@Override
	public boolean containsAll(Collection<? extends Type> items) {		
		for(Type element: items) {
			return this.contains(element);
		}
		return false;
	}

	@Override
	public Type first() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return root.firstRecursive();
	}

	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	@Override
	public Type last() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return root.lastRecursive();
	}
	


	@Override
	public boolean remove(Type item) {

		if(root == null){
			return false;
		}
		return removeRecursive(item,root);
	}
	
	public boolean removeRecursive(Type item, BinaryNode current) {
		if (current.rightChild.data == item) {
			removeFunctionDecide(current.rightChild,current,false);
			return true;
		};
		if (current.leftChild.data == item) {
			removeFunctionDecide(current.leftChild,current,true);
			return true;
		};
		if (item.compareTo(current.data) < 0) {
			if(current.leftChild != null) {
				removeRecursive(item,current.leftChild);
			}

		};
			if(current.rightChild != null) {
				removeRecursive(item,current.rightChild);
			}
			return true;
	}
	
	public void noLeafRemoval( BinaryNode toBeRemoved) {
		toBeRemoved = null;
		}
	
	public void oneLeafRemoval(BinaryNode parentToRemoved, BinaryNode toBeRemoved, boolean removeLeft, boolean parentRemoveLeft) {	
		if(parentRemoveLeft) {
			if(removeLeft) {
				parentToRemoved.leftChild = toBeRemoved.leftChild;
			}else {
				parentToRemoved.leftChild = toBeRemoved.rightChild;
			}
		}
		else {
			if(removeLeft) {
				parentToRemoved.rightChild = toBeRemoved.leftChild;
			}else {
				parentToRemoved.rightChild = toBeRemoved.rightChild;
			}
		}
			
	}
	
	public Type findSucessorRecursive(BinaryNode current, BinaryNode parentNode) {
		if(current.rightChild != null) {
			findSucessorRecursive(current.rightChild, current);
		}
		Type newData = current.data;
		if(current.leftChild != null) {
			oneLeafRemoval(parentNode,current,true,false);
		}else {
			noLeafRemoval(current);
		}
		return newData;
				
	}
	
	public boolean twoLeafRemoval( BinaryNode currentRemove) {
		Type newData = findSucessorRecursive(currentRemove.leftChild, currentRemove);
		currentRemove.data = newData;
		return true;
		}
	

	
	public boolean removeFunctionDecide(BinaryNode nodeToRemove, BinaryNode parentToRemoved, boolean leftChildRemove) {
		if(nodeToRemove.leftChild == null && nodeToRemove.rightChild== null) {
			noLeafRemoval(nodeToRemove);
		}
		if(nodeToRemove.leftChild != null && nodeToRemove.rightChild!= null) {
			twoLeafRemoval(nodeToRemove);
		}
		if(nodeToRemove.leftChild == null) {
			oneLeafRemoval(parentToRemoved, nodeToRemove, false, leftChildRemove);
		}else {
			oneLeafRemoval(parentToRemoved, nodeToRemove, true, leftChildRemove);
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<? extends Type> items) {


		if(items.isEmpty()){ return false;}

		for (Type item : items){
			remove(item);
			if(items.contains(item)){return false;}
		}
		return true;

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ArrayList<Type> toArrayList() {

		ArrayList<Type> retList = new ArrayList<>();

		for(int i = size; i >= 0; i++){


		}
		// TODO Auto-generated method stub
		return null;
	}

}
