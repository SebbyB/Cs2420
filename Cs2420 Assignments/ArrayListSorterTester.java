package com.assign05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayListSorterTester {

	
// --------Generate Ascending Tests------------------
	
//	@Test
//	void generateAscendinglessthan0?() {
//		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
//		
//		ArrayList<Integer> tester =  ArrayListSorter.generateAscending(0);
//		assertEquals(0,tester.size());
//        assertEquals(tester.toString(),finalAnswer.toString());
//	}
//	
	@Test
	void generateAscendingEmpty() {
		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
		
		ArrayList<Integer> tester =  ArrayListSorter.generateAscending(0);
		assertEquals(0,tester.size());
        assertEquals(tester.toString(),finalAnswer.toString());
	}
	
	@Test
	void generateAscending1() {
		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
		finalAnswer.add(0);
		ArrayList<Integer> tester =  ArrayListSorter.generateAscending(1);
		assertEquals(1,tester.size());
        assertEquals(tester.toString(),finalAnswer.toString());
	}
	@Test
	void generateAscending1to5() {
		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
		finalAnswer.add(0);
		finalAnswer.add(1);
		finalAnswer.add(2);
		finalAnswer.add(3);
		finalAnswer.add(4);
		
		ArrayList<Integer> tester =  ArrayListSorter.generateAscending(5);
		assertEquals(5,tester.size());
        assertEquals(tester.toString(),finalAnswer.toString());
	}
	@Test
	void generateAscendinglarge() {
		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
		for(int i = 0; i <1000000; i++) {
		finalAnswer.add(i);
		}
		
		ArrayList<Integer> tester =  ArrayListSorter.generateAscending(1000000);
		assertEquals(1000000,tester.size());
        assertEquals(tester.toString(),finalAnswer.toString());
	}
	
	
	// --------Generate Descending Tests------------------
		
//		@Test
//		void generateAscendinglessthan0?() {
//			ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
//			
//			ArrayList<Integer> tester =  ArrayListSorter.generateAscending(0);
//			assertEquals(0,tester.size());
//	        assertEquals(tester.toString(),finalAnswer.toString());
//		}
	//	
	@Test
	void generateDescendingEmpty() {
		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
		
		ArrayList<Integer> tester =  ArrayListSorter.generateDescending(0);
		assertEquals(0,tester.size());
        assertEquals(tester.toString(),finalAnswer.toString());
	}
	
	@Test
	void generateDescending1() {
		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
		finalAnswer.add(1);
		ArrayList<Integer> tester =  ArrayListSorter.generateDescending(1);
		assertEquals(1,tester.size());
        assertEquals(tester.toString(),finalAnswer.toString());
	}
	@Test
	void generateDescending1to5() {
		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
		finalAnswer.add(5);
		finalAnswer.add(4);
		finalAnswer.add(3);
		finalAnswer.add(2);
		finalAnswer.add(1);
		
		ArrayList<Integer> tester =  ArrayListSorter.generateDescending(5);
		assertEquals(5,tester.size());
        assertEquals(tester.toString(),finalAnswer.toString());
	}
	@Test
	void generateDescendinglarge() {
		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
		for(int i = 1000000; i > 0; i--) {
		finalAnswer.add(i);
		}
		
		ArrayList<Integer> tester =  ArrayListSorter.generateDescending(1000000);
		assertEquals(1000000,tester.size());
        assertEquals(tester.toString(),finalAnswer.toString());
	}
	// --------Generate Permuted Tests------------------
	
//	@Test
//	void generateAscendinglessthan0?() {
//		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
//		
//		ArrayList<Integer> tester =  ArrayListSorter.generateAscending(0);
//		assertEquals(0,tester.size());
//        assertEquals(tester.toString(),finalAnswer.toString());
//	}
//	
	@Test
	void generatePermutedEmpty() {
		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
		
		ArrayList<Integer> tester =  ArrayListSorter.generatePermuted(0);
		assertEquals(0,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());
	}
	
	@Test
	void generatePermuted1() {
		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();

		ArrayList<Integer> finalAns =  ArrayListSorter.generateAscending(1);
		ArrayList<Integer> tester =  ArrayListSorter.generatePermuted(1);
		assertEquals(1,tester.size());
	    assertEquals(finalAns.toString(),tester.toString());

	}
	@Test
	void generatePermuted1to5() {
		
		ArrayList<Integer> tester =  ArrayListSorter.generatePermuted(5);
		
		assertEquals(5,tester.size());
		for(int i = 0; i< 5; i++) {
	    assertTrue(tester.contains(i));
	    }
	}
	@Test
	void generatePermutedLarge() {

		int n = 10000;
		ArrayList<Integer> tester =  ArrayListSorter.generatePermuted(n);
		ArrayList<Integer> fin = ArrayListSorter.generateAscending(n);
		assertEquals(n,tester.size());
		assertTrue(tester.containsAll(fin));
	}
	// --------insertionSort Tests------------------
	@Test
	void insertionSort1Int(){
		int n = 1;

		ArrayList<Integer> fin = ArrayListSorter.generateAscending(n);
		ArrayList<Integer> tester = ArrayListSorter.generatePermuted(n);
		ArrayList<Integer> temp = new ArrayList<>(n);
		ArrayListSorter.insertionSort(tester);
		assertEquals(fin,tester);
		for(int i = 0; i < n-1; i++){
			assertEquals(fin.get(i),tester.get(i));
		}

	}

	@Test
	void insertionSort5Int(){
		int n = 5;

		ArrayList<Integer> fin = ArrayListSorter.generateAscending(n);
		ArrayList<Integer> tester = ArrayListSorter.generatePermuted(n);
		ArrayListSorter.insertionSort(tester);
		assertEquals(fin,tester);
		for(int i = 0; i < n-1; i++){
			assertEquals(fin.get(i),tester.get(i));
		}

	}

	@Test
	void insertionSort15Int(){
		int n = 15;

		ArrayList<Integer> fin = ArrayListSorter.generateAscending(n);
		ArrayList<Integer> tester = ArrayListSorter.generatePermuted(n);
		ArrayList<Integer> temp = new ArrayList<>(n);
		ArrayListSorter.insertionSort(tester);
		assertEquals(fin,tester);
		for(int i = 0; i < n-1; i++){
			assertEquals(fin.get(i),tester.get(i));
		}

	}

	@Test
	void insertionSort50Int(){
		int n = 50;

		ArrayList<Integer> fin = ArrayListSorter.generateAscending(n);
		ArrayList<Integer> tester = ArrayListSorter.generatePermuted(n);

		ArrayListSorter.insertionSort(tester);
		assertEquals(fin,tester);
		for(int i = 0; i < n-1; i++){
			assertEquals(fin.get(i),tester.get(i));
		}

	}

	@Test
	void insertionSort100Int(){
		int n = 100;

		ArrayList<Integer> fin = ArrayListSorter.generateAscending(n);
		ArrayList<Integer> tester = ArrayListSorter.generatePermuted(n);
		ArrayListSorter.insertionSort(tester);
		assertEquals(fin,tester);
		for(int i = 0; i < n-1; i++){
			assertEquals(fin.get(i),tester.get(i));
		}

	}

	@Test
	void insertionSort1000Int(){
		int n = 1000;

		ArrayList<Integer> fin = ArrayListSorter.generateAscending(n);
		ArrayList<Integer> tester = ArrayListSorter.generatePermuted(n);
		ArrayListSorter.insertionSort(tester);
		assertEquals(fin,tester);
		for(int i = 0; i < n-1; i++){
		assertEquals(fin.get(i),tester.get(i));
		}
	}


	@Test
	void insertionSort100000Int(){
		int n = 100000;

		ArrayList<Integer> fin = ArrayListSorter.generateAscending(n);
		ArrayList<Integer> tester = ArrayListSorter.generatePermuted(n);
		ArrayListSorter.insertionSort(tester);
		assertEquals(fin,tester);
		for(int i = 0; i < n-1; i++){
			assertEquals(fin.get(i),tester.get(i));
		}
	}

	@Test
	void insertionSortCharPermuted() {

		ArrayList<Character> finalAnswer = new ArrayList<Character>();
		finalAnswer.add('a');
		finalAnswer.add('b');
		finalAnswer.add('c');
		finalAnswer.add('d');
		finalAnswer.add('e');
		ArrayList<Character> tester =   new ArrayList<Character>();
		tester.add('c');
		tester.add('b');
		tester.add('e');
		tester.add('a');
		tester.add('d');

		ArrayListSorter.insertionSort((tester));
		assertEquals(5,tester.size());
		assertEquals(tester.toString(),finalAnswer.toString());
	}


	// --------Mergesort Tests------------------

	@Test
	void mergeSortEmptyInt() {
		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();

		int n = 0;
		ArrayList<Integer> tester =  ArrayListSorter.generatePermuted(n);
		ArrayList<Integer> fin = ArrayListSorter.generateAscending(n);
		ArrayListSorter.mergesort(tester);
		assertEquals(0,tester.size());
	    assertEquals(tester.toString(),fin.toString());
		
	}
	
	@Test
	void mergeSortOneInt() {
		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
		finalAnswer.add(2);
		
		ArrayList<Integer> tester =  new ArrayList<Integer>();
		finalAnswer.add(2);
		
		ArrayListSorter.mergesort(tester);
		assertEquals(1,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());
		
	}
	
	@Test
	void mergeSort1_5IntPermuted() {

		int n = 5;

		ArrayList<Integer> fin = ArrayListSorter.generateAscending(n);
		ArrayList<Integer> tester =  ArrayListSorter.generatePermuted(n);

		ArrayListSorter.mergesort(tester);
		assertEquals(5,tester.size());
	    assertEquals(fin.toString(),tester.toString());
		
	}
	
	@Test
	void mergeSortCharPermuted() {

		ArrayList<Character> finalAnswer = new ArrayList<Character>();
		finalAnswer.add('a');
		finalAnswer.add('b');
		finalAnswer.add('c');
		finalAnswer.add('d');
		finalAnswer.add('e');
		ArrayList<Character> tester =   new ArrayList<Character>();
		tester.add('c');
		tester.add('b');
		tester.add('e');
		tester.add('a');
		tester.add('d');

		ArrayListSorter.mergesort(tester);
		assertEquals(5,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());
	}
	@Test
	void mergeSort1_13IntPermuted() {

		ArrayList<Integer> finalAnswer = ArrayListSorter.generateAscending(13);
		ArrayList<Integer> tester =  ArrayListSorter.generatePermuted(13);

		ArrayListSorter.mergesort(tester);
		assertEquals(13,tester.size());
			for(int i = 0; i < 20; i++){
				assertEquals(tester.toString(),finalAnswer.toString());
		}
	}
	
	@Test
	void mergeSort1_22IntPermuted() {
		for(int i = 0; i < 20; i++) {
		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(22);
		ArrayList<Integer> tester =  ArrayListSorter.generatePermuted(22);

		ArrayListSorter.mergesort(tester);
		assertEquals(22,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());
		}
	}
	
	@Test
	void mergeSort1_10000IntPermuted() {

		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(10000);
		ArrayList<Integer> tester =  ArrayListSorter.generatePermuted(10000);

		ArrayListSorter.mergesort(tester);
		assertEquals(10000,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());
		
	}

	
	@Test
	void mergeSort1_5IntAscending() {

		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
		finalAnswer.add(1);
		finalAnswer.add(2);
		finalAnswer.add(3);
		finalAnswer.add(4);
		finalAnswer.add(5);
		ArrayList<Integer> doubleCheck = ArrayListSorter.generateAscending(5);
		ArrayList<Integer> tester =  ArrayListSorter.generateAscending(5);

		ArrayListSorter.mergesort(tester);
		assertEquals(5,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());
	    assertEquals(tester.toString(),doubleCheck.toString());
		
	}
	@Test
	void mergeSortCharAscending() {

		ArrayList<Character> finalAnswer = new ArrayList<Character>();
		finalAnswer.add('a');
		finalAnswer.add('b');
		finalAnswer.add('c');
		finalAnswer.add('d');
		finalAnswer.add('e');
		ArrayList<Character> tester =   new ArrayList<Character>();
		tester.add('a');
		tester.add('b');
		tester.add('c');
		tester.add('d');
		tester.add('e');
		ArrayListSorter.mergesort(tester);
		assertEquals(5,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());
	}
	
	@Test
	void mergeSort1_13IntAscending() {

		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(13);
		ArrayList<Integer> tester =  ArrayListSorter.generateAscending(13);

		ArrayListSorter.mergesort(tester);
		assertEquals(13,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());

	}
	
	@Test
	void mergeSort1_22IntAscending() {
		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(13);
		ArrayList<Integer> tester =  ArrayListSorter.generateAscending(13);

		ArrayListSorter.mergesort(tester);
		assertEquals(22,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());

	}
	
	@Test
	void mergeSort1_10000IntAscending() {

		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(10000);
		ArrayList<Integer> tester =  ArrayListSorter.generateAscending(10000);

		ArrayListSorter.mergesort(tester);
		assertEquals(10000,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());
		
	}
	
	
	@Test
	void mergeSort1_5IntDescending() {

		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
		finalAnswer.add(1);
		finalAnswer.add(2);
		finalAnswer.add(3);
		finalAnswer.add(4);
		finalAnswer.add(5);
		ArrayList<Integer> doubleCheck = ArrayListSorter.generateAscending(5);
		ArrayList<Integer> tester =  ArrayListSorter.generateDescending(5);

		ArrayListSorter.mergesort(tester);
		assertEquals(5,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());
	    assertEquals(tester.toString(),doubleCheck.toString());
		
	}
	
	@Test
	void mergeSortCharDecending() {

		ArrayList<Character> finalAnswer = new ArrayList<Character>();
		finalAnswer.add('a');
		finalAnswer.add('b');
		finalAnswer.add('c');
		finalAnswer.add('d');
		finalAnswer.add('e');
		ArrayList<Character> tester =   new ArrayList<Character>();
		tester.add('e');
		tester.add('d');
		tester.add('c');
		tester.add('b');
		tester.add('a');
		ArrayListSorter.mergesort(tester);
		assertEquals(5,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());
	}
	
	@Test
	void mergeSort1_13IntDescending() {
		
		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(13);
		ArrayList<Integer> tester =  ArrayListSorter.generateDescending(13);

		ArrayListSorter.mergesort(tester);
		assertEquals(13,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());
		
	}
	
	@Test
	void mergeSort1_22IntDescending() {
		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(22);
		ArrayList<Integer> tester =  ArrayListSorter.generateDescending(22);

		ArrayListSorter.mergesort(tester);
		assertEquals(22,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());

	}
	
	@Test
	void mergeSort1_10000IntDescending() {

		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(10000);
		ArrayList<Integer> tester =  ArrayListSorter.generateDescending(10000);

		ArrayListSorter.mergesort(tester);
		assertEquals(10000,tester.size());
	    assertEquals(tester.toString(),finalAnswer.toString());
		
	}
	
//	// --------QuickSort Tests------------------
//
//	@Test
//	void quickSortEmptyInt() {
//		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
//
//		ArrayList<Integer> tester =  new ArrayList<Integer>();
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(0,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//
//	}
//
//	@Test
//	void quickSortOneInt() {
//		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
//		finalAnswer.add(2);
//
//		ArrayList<Integer> tester =  new ArrayList<Integer>();
//		tester.add(2);
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(1,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//
//	}
//
//	@Test
//	void quickSort1_5IntPermuted() {
//
//		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
//		finalAnswer.add(1);
//		finalAnswer.add(2);
//		finalAnswer.add(3);
//		finalAnswer.add(4);
//		finalAnswer.add(5);
//		ArrayList<Integer> doubleCheck = ArrayListSorter.generateAscending(5);
//		ArrayList<Integer> tester =  ArrayListSorter.generatePermuted(5);
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(5,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//	    assertEquals(tester.toString(),doubleCheck.toString());
//
//	}
//
//	@Test
//	void quickSortCharPermuted() {
//
//		ArrayList<Character> finalAnswer = new ArrayList<Character>();
//		finalAnswer.add('a');
//		finalAnswer.add('b');
//		finalAnswer.add('c');
//		finalAnswer.add('d');
//		finalAnswer.add('e');
//		ArrayList<Character> tester =   new ArrayList<Character>();
//		tester.add('c');
//		tester.add('b');
//		tester.add('e');
//		tester.add('a');
//		tester.add('d');
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(5,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//	}
//	@Test
//	void quickSort1_13IntPermuted() {
//		for(int i = 0; i < 20; i++) {
//		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(13);
//		ArrayList<Integer> tester =  ArrayListSorter.generatePermuted(13);
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(13,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//		}
//	}
//
//	@Test
//	void quickSort1_22IntPermuted() {
//		for(int i = 0; i < 20; i++) {
//		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(22);
//		ArrayList<Integer> tester =  ArrayListSorter.generatePermuted(22);
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(22,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//		}
//	}
//
//	@Test
//	void quickSort1_10000IntPermuted() {
//
//		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(10000);
//		ArrayList<Integer> tester =  ArrayListSorter.generatePermuted(10000);
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(10000,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//
//	}
//
//
//	@Test
//	void quickSort1_5IntAscending() {
//
//		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
//		finalAnswer.add(1);
//		finalAnswer.add(2);
//		finalAnswer.add(3);
//		finalAnswer.add(4);
//		finalAnswer.add(5);
//		ArrayList<Integer> doubleCheck = ArrayListSorter.generateAscending(5);
//		ArrayList<Integer> tester =  ArrayListSorter.generateAscending(5);
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(5,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//	    assertEquals(tester.toString(),doubleCheck.toString());
//
//	}
//	@Test
//	void quickSortCharAscending() {
//
//		ArrayList<Character> finalAnswer = new ArrayList<Character>();
//		finalAnswer.add('a');
//		finalAnswer.add('b');
//		finalAnswer.add('c');
//		finalAnswer.add('d');
//		finalAnswer.add('e');
//		ArrayList<Character> tester =   new ArrayList<Character>();
//		tester.add('a');
//		tester.add('b');
//		tester.add('c');
//		tester.add('d');
//		tester.add('e');
//		ArrayListSorter.quicksort(tester);
//		assertEquals(5,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//	}
//
//	@Test
//	void quickSort1_13IntAscending() {
//
//		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(13);
//		ArrayList<Integer> tester =  ArrayListSorter.generateAscending(13);
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(13,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//
//	}
//
//	@Test
//	void quickSort1_22IntAscending() {
//		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(13);
//		ArrayList<Integer> tester =  ArrayListSorter.generateAscending(13);
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(22,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//
//	}
//
//	@Test
//	void quickSort1_10000IntAscending() {
//
//		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(10000);
//		ArrayList<Integer> tester =  ArrayListSorter.generateAscending(10000);
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(10000,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//
//	}
//
//
//	@Test
//	void quickSort1_5IntDescending() {
//
//		ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
//		finalAnswer.add(1);
//		finalAnswer.add(2);
//		finalAnswer.add(3);
//		finalAnswer.add(4);
//		finalAnswer.add(5);
//		ArrayList<Integer> doubleCheck = ArrayListSorter.generateAscending(5);
//		ArrayList<Integer> tester =  ArrayListSorter.generateDescending(5);
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(5,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//	    assertEquals(tester.toString(),doubleCheck.toString());
//
//	}
//
//	@Test
//	void quickSortCharDecending() {
//
//		ArrayList<Character> finalAnswer = new ArrayList<Character>();
//		finalAnswer.add('a');
//		finalAnswer.add('b');
//		finalAnswer.add('c');
//		finalAnswer.add('d');
//		finalAnswer.add('e');
//		ArrayList<Character> tester =   new ArrayList<Character>();
//		tester.add('e');
//		tester.add('d');
//		tester.add('c');
//		tester.add('b');
//		tester.add('a');
//		ArrayListSorter.quicksort(tester);
//		assertEquals(5,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//	}
//
//	@Test
//	void quickSort1_13IntDescending() {
//
//		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(13);
//		ArrayList<Integer> tester =  ArrayListSorter.generateDescending(13);
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(13,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//
//	}
//
//	@Test
//	void quickSort1_22IntDescending() {
//		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(22);
//		ArrayList<Integer> tester =  ArrayListSorter.generateDescending(22);
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(22,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//
//	}
//
//	@Test
//	void quickSort1_10000IntDescending() {
//
//		ArrayList<Integer> finalAnswer= ArrayListSorter.generateAscending(10000);
//		ArrayList<Integer> tester =  ArrayListSorter.generateDescending(10000);
//
//		ArrayListSorter.quicksort(tester);
//		assertEquals(10000,tester.size());
//	    assertEquals(tester.toString(),finalAnswer.toString());
//
//	}

}
