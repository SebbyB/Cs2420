package assign10;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Binary MaxHeap data structure that uses a Generic Data Type.
 * Implements Priority Queue interface.
 * {@code @Authors} Sebastian Barney and Amelia Neilson
 * @param <E> - Generic type E for Element
 */
public class BinaryMaxHeap<E> implements PriorityQueue<E>{


	/**
	 * Creates a backing array variable.
	 * Internally,
	 * keeps track of the Index within the backing array needs to be called for the smallest element added.
	 * keeps track of the "size" of the heap which is how many elements have been added to it.
	 * keeps track of a comparator, and if it is needed.
	 * Has 2 private variables to initialize size and growth factor for the array.
	 */

	private E[] backingArray;
	private int currentAddInd;
	private int size;
	private Comparator<? super E> comparator;
	private boolean isComparator = false;
	private int initSize = 10;
	private int growFactor = 2;


	/**
	 * Empty Constructor for the class. Creates an empty BinaryMaxHeap.
	 * Initializes the empty array to the initial size.
	 * Initializes the size variable and current Add Index variables;
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap() {
	backingArray = (E[]) new Object[initSize];
	size = 0;
	currentAddInd = 0;
	}

	/**
	 * Constructor for class with a comparator argument.
	 * Creates an empty binary heap that uses a comparator.
	 * Initializes variables and backing array. Changes method to use comparator.
	 * @param comp - comparator being used.
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(Comparator<? super E> comp) {
		isComparator = true;
		comparator = comp;
		backingArray = (E[]) new Object[initSize];
		size = 0;
		currentAddInd = 0;
	}

	/**
	 * Constructor for class with a list to add to the heap.
	 * Creates a binary max heap with the list being the data the heap contains.
	 * Initializes variables and arrays then adds everything in the list to the backingArray.
	 * After everything has been added to the array, it gets heapified.
	 * @param dataList - list of items to be added to the heap.
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(List<? extends E> dataList) {
		size = 0;
		currentAddInd = 0;
		backingArray = (E[]) new Object[dataList.size()];
		buildHeap(dataList);
	}

	/**
	 * Constructor that creates a binary heap with both a comparator and a list.
	 * Essentially a combination of the other two constructors.
	 * @param dataList - list of items to be added to the heap.
	 * @param comp - comparator being used.
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(List<? extends E> dataList, Comparator<? super E> comp) {
		isComparator = true;
		comparator = comp;
		size = 0;
		currentAddInd = 0;
		backingArray = (E[]) new Object[dataList.size()];
		buildHeap(dataList);
	}

	/**
	 * Adds an Item to the heap.
	 * @param item - item to be added.
	 */
	@Override
	public void add(E item) {
		// if the backing array is too small then make it bigger.
		if (currentAddInd >= backingArray.length) {
			growArray();
		}
		//add the item to the index added.
		//Increment the size and the index.
		//percolate the item in the heap structure.
		backingArray[currentAddInd] = item;
		size++;
		currentAddInd++;
		percolateUp(item, currentAddInd-1);
	}


	/**
	 * peeks the max item in the heap.
	 * @return - the item.
	 * @throws NoSuchElementException - if the heap is empty there is no max so throw.
	 */
	@Override
	public E peek() throws NoSuchElementException {
		if(this.isEmpty()){throw new NoSuchElementException();}
		return this.backingArray[0];
	}

	/**
	 * Extracts the max item from the heap.
	 * @return - the item.
	 * @throws NoSuchElementException - if the heap is empty there is no max so throw.
	 */
	@Override
	public E extractMax() throws NoSuchElementException {
		E max = peek();
		E data = backingArray[currentAddInd - 1];
		backingArray[0] = data;

		backingArray[currentAddInd] = null;
		percolateDown(data);

		size--;
		currentAddInd--;
		return max;

	}

	/**
	 * Gets the size of the heap, which is the number of elements in the heap.
	 * @return - size.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Checks if the heap is empty.
	 * @return true if the heap is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Clears the heap by reinitializing size, index, and backing array variables.
	 */
	@Override@SuppressWarnings("unchecked")
	public void clear() {
		size = 0;
		currentAddInd = 0;
		backingArray = (E[])new Object[initSize];
	}

	/**
	 * turns the heap into an array.
	 * @return object array containing heap data.
	 */
	@Override
	public Object[] toArray() {

		Object[] retArray = new Object[size];
		System.arraycopy(this.backingArray, 0, retArray, 0, size);
		return retArray;
	}

	/**
	 * builds a heap from a list.
	 * @param list - list to create heap from.
	 */
	private void buildHeap(List<? extends E>list) {
		while(backingArray.length < list.size()){
			growArray();
		}
		int lastCheckIndex = (list.size() - 2)/2;
		for(int index = 0; index < list.size(); index++){
			backingArray[index] = list.get(index);
		}
		for(int i = 0; i <= lastCheckIndex; i++){
			percolateDown(backingArray[i]);
		}
	}

	/**
	 * Percolates an element up the heap.
	 * @param element - element to be percolated.
	 * @param index - index of the element.
	 */
	private void percolateUp(E element, int index) {
		int prevInd = index;
		index = (index - 1)/2;
		while (innerCompare(element,backingArray[index]) >= 0 && prevInd != 0){
			E data1 = backingArray[prevInd];
			E data2 = backingArray[index];
			backingArray[index] = data1;
			backingArray[prevInd] = data2;
			prevInd = index;
			index = (index - 1)/2;
		}
	}

	/**
	 * Percolates an element down the heap.
	 * @param element - element to be percolated.
	 */
	private void percolateDown(E element) {
		for(int index = 1; index < backingArray.length; index+=2){

			
			int leftChildIndex = index;
			int rightChildIndex = index + 1;
			E leftChild = backingArray[leftChildIndex];
			E rightChild = backingArray[rightChildIndex];

			if((Objects.isNull(leftChild) && Objects.isNull(rightChild)) || (Objects.isNull(element))){
				break;
			}
			if(Objects.isNull(leftChild) || Objects.isNull(rightChild)){
				if(!Objects.isNull(leftChild)){
					int compVal = innerCompare(element,leftChild);
					if(compVal == 1){
						backingArray[leftChildIndex] = element;
					} else if (compVal == 0) {
						break;
					}
					else {
						continue;
					}
				}
				if(!Objects.isNull(rightChild)){
					int compVal = innerCompare(element,rightChild);
					if(compVal == 1){
						backingArray[rightChildIndex] = element;
					} else if (compVal == 0) {
						break;
					}
					else {
						continue;
					}
				}
			}
		}
	}

	/**
	 * Compares two elements.
	 * @param elementLeft - object for comparing.
	 * @param elementRight - object to compare.
	 * @return 1 if the left element is larger than the right. 0 if they are equal. -1 if it is less than or null.
	 */
	@SuppressWarnings("unchecked")
	private int innerCompare(E elementLeft, E elementRight) {
		if(Objects.isNull(elementLeft) || Objects.isNull(elementRight)){
			return -1;
		}
		if(isComparator){
			return comparator.compare(elementLeft,elementRight);
		}
		else{
			return ((Comparable<? super E>) elementLeft).compareTo(elementRight);
		}
	}

	/**
	 * Grows the backing Array by some growth factor, kept track of internally.
	 */
	@SuppressWarnings("unchecked")
	private void growArray() {
		//Makes an array that is larger, then copies the data over.
		int backArrLen = this.backingArray.length;
		E[] tempArray = (E[]) new Object[backArrLen*growFactor];
		System.arraycopy(this.backingArray, 0, tempArray, 0, backArrLen);
		this.backingArray = tempArray;
	}
	/*
	   ===========================================
	   =             Testing Methods             =
	   ===========================================
	 */

	/**
	 * Gets the backing array.
	 * @return the backing array of the heap.
	 */
	public E[] getBackingArray() {
		return backingArray;
	}

	/**
	 * Sets the initial size variable.
	 * @param n - what it gets set to.
	 */
	public void setInitSize(int n){
		initSize = n;
	}

	/**
	 * Gets the initial size
	 * @return initial size.
	 */
	public int getInitSize(){
		return initSize;
	}

	/**
	 * Sets growth factor.
	 * @param n - what it gets set to.
	 */
	public void setGrowthFactor(int n){
		growFactor = n;
	}

	/**
	 * gets the growth factor.
	 * @return - the growth factor.
	 */
	public int getGrowthFactor(){
		return growFactor;
	}

}
