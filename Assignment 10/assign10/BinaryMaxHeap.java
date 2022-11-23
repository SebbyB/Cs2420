package assign10;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;


public class BinaryMaxHeap<E> implements PriorityQueue<E>{
	private int currentAddInd;
	private int initSize = 10;
	private int growFactor = 2;
	private int size;
	private Comparator<? super E> comparator;

	private boolean isComparator = false;
	
	private E[] backingArray;
	
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap() {
	backingArray = (E[]) new Object[initSize];
	size = 0;
	currentAddInd = 0;
	}
	
	public BinaryMaxHeap(Comparator<? super E> comp) {
		isComparator = true;
		comparator = comp;

	}
	
	public BinaryMaxHeap(List<? extends E> dataList) {
		size = 0;
		currentAddInd = 0;
		backingArray = (E[]) new Object[dataList.size()];
		buildHeap(dataList);
	}
	
	public BinaryMaxHeap(List<? extends E> datalist, Comparator<? super E> comp) {
		isComparator = true;
		comparator = comp;
		size = 0;
		currentAddInd = 0;
		backingArray = (E[]) new Object[datalist.size()];
		buildHeap(datalist);
	}

	@Override
	public void add(E item) {
		if (currentAddInd >= backingArray.length) {
			growArray();
		}
		backingArray[currentAddInd] = item;
		size++;
		currentAddInd++;
		percolateUp(item, currentAddInd);

	}



	@Override
	public E peek() throws NoSuchElementException {
		E data = this.backingArray[0];
		return data;
	}

	@Override
	public E extractMax() throws NoSuchElementException {
		E max = peek();
		E data = backingArray[currentAddInd - 1];
		backingArray[0] = data;
		backingArray[currentAddInd - 1] = null;
		percolateDown(data,0);
		size--;
		currentAddInd--;
		return max;
	}

	@Override
	public int size() {
		int checkSize = 0;
		for(E element : this.backingArray){
			if(!element.equals(null)){
				checkSize++;
			}
		}
		if(size != checkSize){
			size = checkSize;
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		for(E element : this.backingArray){
			if(!element.equals(null)){
				return false;
			}
		}
		return true;
	}

	@Override
	public void clear() {
		size = 0;
		currentAddInd = 0;
		backingArray = (E[])new Object[initSize];
	}

	@Override
	public Object[] toArray() {

		Object[] retArray = new Object[size];
		for(int index = 0; index < size; index++){
			retArray[index] = this.backingArray[index];
		}
		return retArray;
	}
	
	private void buildHeap(List<? extends E>list) {
		while(backingArray.length < list.size()){
			growArray();
		}
		int lastCheckIndex = (list.size() - 2)/2;
		for(int index = 0; index < list.size(); index++){
			backingArray[index] = list.get(index);
		}
		for(int i = 0; i <= lastCheckIndex; i++){
			percolateDown(backingArray[i],i);
		}
	}
	
	private void percolateUp(E element, int index) {

		int prevInd = index;
		index = (index - 1)/2;

		while (innerCompare(element,backingArray[index]) >= 0){
			E data1 = backingArray[prevInd];
			E data2 = backingArray[index];
			backingArray[index] = data1;
			backingArray[prevInd] = data2;
			prevInd = index;
			index = (index - 1)/2;
		}
	}
	
	private void percolateDown(E element, int index) {
		index = (index*2)+1;
		while (innerCompare(element,backingArray[index]) < 0){

			int leftChild = index;
			int rightChild = index+1;
			if(backingArray[rightChild].equals(null)){
				if(innerCompare(element,backingArray[leftChild]) <= 0);
				backingArray[index] = element;
			}
			else{
				int greaterChild;
				if(innerCompare(backingArray[leftChild],backingArray[rightChild]) > 0){
					 backingArray[leftChild] = element;

				}
				else{
					backingArray[rightChild] = element;
				}
			}
			index = (index*2)+1;
		}
	}

	private int innerCompare(E elementLeft, E elementRight) {


		if(isComparator){
			return comparator.compare(elementLeft,elementRight);
		}
		else{
			return ((Comparable<? super E>) elementLeft).compareTo(elementRight);
		}
	}

	
	private void growArray() {

		int backArrLen = this.backingArray.length;
		E[] tempArray = (E[]) new Object[backArrLen*growFactor];
		for(int i = 0; i < backArrLen;i++) {
			tempArray[i] = this.backingArray[i];
		}
		this.backingArray = tempArray;
	}

}
