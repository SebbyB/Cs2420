//package assign07;
package com.Assignments.assign07;

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
		size =0;
		root = null;
	}

	@Override
	public boolean contains(Type item) {
		if (root == null) {
			return false;
		}
			
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
			if(!this.contains(element)) {
				return false;
			}
		}
		return true;
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
		if(root.data.compareTo(item)==0) {
			if(root.rightChild == null && root.leftChild == null) {
				root = null;
				size --;
				return true;
			}
			if(root.rightChild == null) {
				root = root.leftChild;
				size --;
				return true;
			}
			if(root.leftChild == null) {
				root = root.rightChild;
				size--;
				return true;
			}
			size--;
			twoLeafRemoval(root);
			return true;
		}
		return removeRecursive(item,root);
	}
	
	public boolean removeRecursive(Type item, BinaryNode current) {

		if(current.rightChild != null) {
			if (current.rightChild.data.compareTo(item) == 0) {
				size--;
				removeFunctionDecide(current.rightChild,current,false);
				return true;
			}
		};
		if(current.leftChild != null) {
			if (current.leftChild.data.compareTo(item)==0) {
				size--;
				removeFunctionDecide(current.leftChild,current,true);
				return true;
			};
		}
		if (current.leftChild == null && current.rightChild == null) {
			return false;
		}
		else	
			if (item.compareTo(current.data) < 0) {
				if(current.leftChild != null) {
				return removeRecursive(item,current.leftChild);
				}
				else {
					return false;
				}
			}

		if(current.rightChild != null) {
				return removeRecursive(item,current.rightChild);
		}
		else {
			return false;
		}
		
	}
	
	public void noLeafRemoval( BinaryNode parentNode, boolean removeLeftChild) {
		if(removeLeftChild) {
			parentNode.leftChild = null;
		}else {
			parentNode.rightChild = null;
			
			}
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
	
	public Type findSucessorRecursive(BinaryNode current, BinaryNode parentNode, boolean rightOrLeft) {
		if(current.rightChild != null) {
			return findSucessorRecursive(current.rightChild, current,false);
		}
		else {
		if(current.leftChild != null) {
			oneLeafRemoval(parentNode,current,true,rightOrLeft);
		}else {
			noLeafRemoval(parentNode,rightOrLeft);
		}
		 return current.data;
	   }
				
	}
	
	public boolean twoLeafRemoval(BinaryNode currentRemove) {
		Type newData = findSucessorRecursive(currentRemove.leftChild, currentRemove, true);
		currentRemove.data = newData;
		return true;
		}
	

	
	public void removeFunctionDecide(BinaryNode nodeToRemove, BinaryNode parentToRemoved, boolean leftChildRemove) {
		
		if(nodeToRemove.leftChild == null && nodeToRemove.rightChild== null) {
			noLeafRemoval(parentToRemoved,leftChildRemove);
		}
		else if(nodeToRemove.leftChild != null && nodeToRemove.rightChild!= null) {
			twoLeafRemoval(nodeToRemove);
		}
		else if(nodeToRemove.leftChild == null) {
			oneLeafRemoval(parentToRemoved, nodeToRemove, false, leftChildRemove);
		}else {
			oneLeafRemoval(parentToRemoved, nodeToRemove, true, leftChildRemove);
		}
		
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
		ArrayList<Type> retList = new ArrayList<Type>(this.size());
		toArrayListRecurssive(retList, root);
		return retList;
	}

	private void toArrayListRecurssive(ArrayList<Type> retList, BinaryNode current) {
		boolean addAgain = true;
		boolean addAgain2 = true;
		if(current.leftChild != null) {
			toArrayListRecurssive(retList, current.leftChild);
		}
		else{
			retList.add(current.data);
			addAgain = false;
			addAgain2 = false;
		}

		if(addAgain) {
			retList.add(current.data);
			addAgain2 = false;
		}

		if(current.rightChild != null) {
			toArrayListRecurssive(retList, current.rightChild);
		}
		else{
			if(addAgain2) {
				retList.add(current.data);
			}
		}
		return;

	}





}
