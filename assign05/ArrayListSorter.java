package com.Assignments.assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class creates ArrayLists in either ascending, descending, or permuted
 * order as well as sorts ArrayLists by either merge sort(in possible
 * combination of insertion sort) or quicksort algorithms.
 * 
 * Just as a note to whoever is grading this assignment, there are commented out
 * helper methods. These were mainly to help with testing and work if uncommented
 * out, but for grading purposes we were informed to comment them out.
 *
 * @author Amelia Nelson and Sebastian Barney
 * @version October 6, 2022
 */

public class ArrayListSorter<T> {
//  Variable dictating the size of the threshold in which a mergesort segment is insertion sorted.
	public static int sizeThreshold = 3;
//	In deciding a pivot, if the variable whichMethod is 1, the median
//	 of the first, middle, and last index of the segment is chosen as  pivot. If the whichMethod
//	 variable is 2, a random index within the segment is chosen as a pivot. If whichMethod is any
//	 ther integer, the first index within teh segmetn is chosen as a pivot.
	public static int whichMethod = 2;

//	/**
//	 * HELPER METHOD Changes the mergeSort to insertSort Threshold.
//	 *
//	 * @param n - size desired.
//	 */
//
//	public void changeMergeSize(int n) {
//		sizeThreshold = n;
//	}

//	/**
//	 * HELPER METHOD Getter Method for Threshold.
//	 * 
//	 * @return
//	 */
//	public int getThreshold() {
//		return sizeThreshold;
//	}

	/**
	 * Sorts a given array via insertion sort (using compareTo interface of objects
	 * within the ArrayList) between the indexes of start and end.
	 * 
	 * @param <T>   Object type within ArrayList that extends the Comparable
	 *              interface
	 * @param array ArrayList of object type T
	 * @param start The index of inputed array in which the method starts to
	 *              insertion sort of the contents
	 * @param end   The index of inputed array in which the method stops the
	 *              insertion sort of the contents
	 */
	public static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> array, int start, int end) {
		// Loops through each number in the array to start the comparisons with
		for (int i = start; i <= end; i++) {
			int j = i;
			T temp = array.get(i);
			// Compares the current chosen index value and compares it to the others in the
			// array
			while ((j > start && temp.compareTo(array.get(j - 1)) <= 0)) {
				array.set(j, array.get(j - 1));
				j--;
			}
			// Places the current index value in its sorted position
			array.set(j, temp);
		}

	}

	/**
	 * Driver method for mergesort. Sorts an inputed ArrayList (using compareTo
	 * interface of objects within the ArrayList) via mergesort.
	 * 
	 * @param <T> Object type within ArrayList that extends the Comparable interface
	 * @param arr ArrayList of object type T to be mergesorted
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr) {
		// Creates a temporary and fills array of the necessary size
		ArrayList<T> temp = new ArrayList<T>();
		for (int i = 0; i < arr.size(); i++) {
			temp.add(null);
		}
		// Calls on recursive method of mergesort
		mergesort(arr, temp, 0, arr.size() - 1);

	}

	/**
	 * The recursive method of mergesort. Splits the given ArrayList into segments,
	 * insertion sorts the segments if the threshold value is long enough, then
	 * sorts the list as the segments are recombined.
	 * 
	 * @param <T>   Object type within ArrayList that extends the Comparable
	 *              interface
	 * @param arr   ArrayList of object type T to be merge sorted
	 * @param temp  ArrayList used to temporarily store objects T when
	 *              merging/sorting arr
	 * @param start The starting index of the chosen array segment
	 * @param end   The end index of the chosen array segment
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr, ArrayList<T> temp, int start,
			int end) {
		// Splits array into two segments
		int mid = start + (end - start) / 2;
		// Checks if the segment has been split into the size of the given threshold
		if ((start + (sizeThreshold - 1)) >= end) {
			if (start == end) {
				return;
			}
			// Insertion sorts if the segment is indeed size of threshold
			insertionSort(arr, start, end);
			return;
		}
		// Recursive callings of mergesort, splitting the segment further if size is not
		// within threshold
		mergesort(arr, temp, start, mid);
		mergesort(arr, temp, mid + 1, end);
		// Sorts the inputed array when merging the segments together again
		merge(arr, temp, start, mid, end);
	}

	/**
	 * Merges two segments of the array that was inputed into mergesort and
	 * recursively split. During the merge the two segments are sorted when being
	 * placed into the combined segment.
	 * 
	 * @param <T>   Object type within ArrayList that extends the Comparable
	 *              interface
	 * @param arr   ArrayList of object type T to be merge sorted
	 * @param temp  ArrayList used to temporarily store objects T when
	 *              merging/sorting arr
	 * @param start The starting index of the end combined array segment
	 * @param mid   The middle index of the end combined array segment (start of one
	 *              of the uncombined segments)
	 * @param end   The end index of the end combined array segment
	 */
	public static <T extends Comparable<? super T>> void merge(ArrayList<T> arr, ArrayList<T> temp, int start, int mid,
			int end) {
		// Sets up variables for the starting indexes of the segments, as well as the
		// merge position index
		int i = start;
		int j = mid + 1;
		int mergePos = start;

		// Goes through each segment, putting the found smaller value next within the
		// temp array
		while (i <= mid && j <= end) {
			if (arr.get(i).compareTo(arr.get(j)) <= 0) {

				temp.set(mergePos++, arr.get(i++));
			} else {
				temp.set(mergePos++, arr.get(j++));
			}
			// If one segment is completely added to temp, the remaining of the other
			// segment is added
		}
		while (i <= mid) {
			temp.set(mergePos++, arr.get(i++));
		}
		while (j <= end) {
			temp.set(mergePos++, arr.get(j++));
		}
		for (int k = start; k <= end; k++) {
			arr.set(k, temp.get(k));
		}

	}

	/**
	 * An ArrayList integers of the size of the inputed integer is created. The
	 * integers are in ascending order, from 1-inputed integer.
	 * 
	 * @param size The size of the ArrayLisst, as well as the end largest integer of
	 *             the ArrayList
	 * @return ArrayList<Integer> of size of the inputed integer in ascending order
	 */
	public static ArrayList<Integer> generateAscending(int size) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(size);
		for (int k = 1; k < size + 1; k++) {
			arrayList.add(k);
		}
		return arrayList;
	}

	/**
	 * An ArrayList integers of the size of the inputed integer is created. The
	 * integers are in descending order, from inputed integer-1.
	 * 
	 * @param size The size of the ArrayLisst, as well as the starting largest
	 *             integer of the ArrayList
	 * @return ArrayList<Integer> of size of the inputed integer in descending order
	 */
	public static ArrayList<Integer> generateDescending(int size) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(size);
		for (int i = size; i > 0; i--) {
			arrayList.add(i);
		}
		return arrayList;
	}

	/**
	 * An ArrayList integers of the size of the inputed integer is created. The
	 * integers are in permuted order, from 1-inputed integer.
	 * 
	 * @param size The size of the ArrayLisst, as well as the largest integer of the
	 *             ArrayList
	 * @return ArrayList<Integer> of size of the inputed integer in permuted order
	 */
	public static ArrayList<Integer> generatePermuted(int size) {

		ArrayList<Integer> a = ArrayListSorter.generateAscending(size);
		Collections.shuffle(a);
		return a;
	}

//	/**
//	 * HELPER METHOD. Generates An ArrayList of size of the inputed integer of
//	 * random integers between 0 and 100000.
//	 * 
//	 * @param size size of oututed ArrayList
//	 * @return Arraylist of size of the inputed integer of random integers
//	 */
//	public static ArrayList<Integer> generateRandomInts(int size) {
//
//		ArrayList<Integer> arrayList = new ArrayList<Integer>(size);
//		for (int i = 0; i < size; i++) {
//
//			int min = 0;
//			int max = 100000;
//			arrayList.add((int) Math.floor(Math.random() * (max - min + 1) + min));
//
//		}
//		return arrayList;
//	}

//	/**
//	 * HELPER METHOD. Creates an ArrayList characters of the size of the inputed
//	 * integer is created. The characters are in ascending order, from 1-inputed
//	 * integer.
//	 * 
//	 * @param size The size of the ArrayLisst, as well as the end largest Character
//	 *             of the ArrayList
//	 * @return ArrayList<Character> of size of the inputed integer in ascending
//	 *         order
//	 */
//	public static ArrayList<Character> generateAscendingChars(int size) {
//
//		ArrayList<Character> arrayList = new ArrayList<Character>(size);
//		for (int i = 0; i < size; i++) {
//
//			arrayList.add(((char) i));
//
//		}
//		return arrayList;
//	}

//	/**
//	 * HELPER METHOD. Creates an ArrayList characters of the size of the inputed
//	 * integer is created. The characters are in descending order, from inputed
//	 * integer-1.
//	 * 
//	 * @param size The size of the ArrayLisst, as well as the starting largest
//	 *             integer of the ArrayList
//	 * @return ArrayList<Character> of size of the inputed integer in descending
//	 *         order
//	 */
//	public static ArrayList<Character> generateDescendingChars(int size) {
//
//		ArrayList<Character> arrayList = new ArrayList<Character>(size);
//		for (int i = size; i > 0; i--) {
//
//			arrayList.add(((char) i));
//
//		}
//		return arrayList;
//	}

//	/**
//	 * HELPER METHOD. Creates an ArrayList characters of the size of the inputed
//	 * integer is created. The characters are in permuted order, from inputed
//	 * integer-1.
//	 * 
//	 * @param size The size of the ArrayLisst, as well as the starting largest
//	 *             integer of the ArrayList
//	 * @return ArrayList<Character> of size of the inputed integer in permuted order
//	 */
//	public static ArrayList<Character> generatePermutedChars(int size) {
//
//		ArrayList<Character> a = ArrayListSorter.generateAscendingChars(size);
//		Collections.shuffle(a);
//		return a;
//	}

//	/**
//	 * HELPER METHOD. Creates an ArrayList of random characters of the size of the
//	 * inputed integer is created.
//	 * 
//	 * @param size The size of the ArrayLisst, as well as the starting largest
//	 *             integer of the ArrayList
//	 * @return ArrayList<Character> of size of the inputed integer in permuted order
//	 */
//	public static ArrayList<Character> generateRandomChars(int size) {
//
//		ArrayList<Character> arrayList = new ArrayList<Character>(size);
//		for (int i = 0; i < size; i++) {
//
//			int min = 0;
//			int max = 100000;
//			arrayList.add((char) Math.floor(Math.random() * (max - min + 1) + min));
//
//		}
//		return arrayList;
//	}

//	/**
//	 * HELPER METHOD. Creates an ArrayList doubles of the size of the inputed
//	 * integer is created. The integers are in ascending order, incrimented by
//	 * inputed increment size up to inputed size integer.
//	 * 
//	 * @param size          The size of the ArrayLisst, as well as the end largest
//	 *                      integer of the ArrayList
//	 * @param incrementSize size of increments between doubles in array
//	 * @return ArrayList<Double> of size of the inputed integer in ascending order
//	 */
//	public static ArrayList<Double> generateAscendingDoubles(int max, double incrementSize) {
//
//		int arrSize = (int) (max / incrementSize);
//		ArrayList<Double> arrayList = new ArrayList<Double>(arrSize);
//		double d = incrementSize;
//		int i = 0;
//		while (i < arrSize) {
//			arrayList.add(d);
//			d += incrementSize;
//			i++;
//
//		}
//		return arrayList;
//	}

//	/**
//	 * HELPER METHOD. Creates an ArrayList doubles of the size of the inputed
//	 * integer is created. The integers are in descending order, incrimented by
//	 * inputed increment size starting from inputed size.
//	 * 
//	 * @param size          The size of the ArrayLisst, as well as the end largest
//	 *                      integer of the ArrayList
//	 * @param incrementSize size of increments between doubles in array
//	 * @return ArrayList<Double> of size of the inputed integer in descending order
//	 */
//	public static ArrayList<Double> generateDescendingDoubles(int max, double incrementSize) {
//
//		int arrSize = (int) (max / incrementSize);
//		ArrayList<Double> arrayList = new ArrayList<Double>(arrSize);
//		double d = max;
//		int i = 0;
//		while (i < arrSize) {
//			arrayList.add(d);
//			d -= incrementSize;
//			i++;
//
//		}
//		return arrayList;
//	}

//	/**
//	 * HELPER METHOD. Creates an ArrayList doubles of the size of the inputed
//	 * integer is created. The integers are in permuted order, incrimented by
//	 * inputed increment up to inputed size.
//	 * 
//	 * @param size          The size of the ArrayLisst, as well as the end largest
//	 *                      integer of the ArrayList
//	 * @param incrementSize size of increments between doubles in array
//	 * @return ArrayList<Double> of size of the inputed integer in permuted order
//	 */
//	public static ArrayList<Double> generatePermutedDoubles(int max, double incrementSize) {
//
//		ArrayList<Double> a = ArrayListSorter.generateAscendingDoubles(max, incrementSize);
//		Collections.shuffle(a);
//		return a;
//	}

//	/**
//	 * HELPER METHOD. Creates an ArrayList of random doubles of the size of the
//	 * inputed integer is created. The integers are in random order, incrimented by
//	 * inputed increment up to inputed size.
//	 * 
//	 * @param size          The size of the ArrayLisst, as well as the end largest
//	 *                      integer of the ArrayList
//	 * @param incrementSize size of increments between doubles in array
//	 * @return ArrayList<Double> of size of the inputed integer
//	 */
//	public static ArrayList<Double> generateRandomDoubles(int size) {
//
//		ArrayList<Double> arrayList = new ArrayList<Double>(size);
//		for (int i = 0; i < size; i++) {
//
//			int min = 0;
//			int max = 100000;
//			arrayList.add(Math.floor(Math.random() * (max - min + 1) + min));
//
//		}
//		return arrayList;
//	}

	/**
	 * Driver method for quicksort. Sorts an inputed ArrayList (using compareTo
	 * interface of objects within the ArrayList) via quicksort.
	 * 
	 * @param <T> Object type within ArrayList that extends the Comparable interface
	 * @param arr ArrayList of object type T to be quicksorted
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr) {
		quicksort(arr, 0, arr.size() - 1);
	}

	/**
	 * The recursive method of quicksort. Splits the given ArrayList into segments
	 * depending on if they are larger or smaller than the chosen pivot until the
	 * arraylist is sorted. In deciding a pivot, if the variable whichMethod is 1, the median
	 * of the first, middle, and last index of the segment is chosen as  pivot. If the whichMethod
	 * variable is 2, a random index within the segment is chosen as a pivot. If whichMethod is any
	 * ther integer, the first index within teh segmetn is chosen as a pivot.
	 * 
	 * @param <T>        Object type within ArrayList that extends the Comparable
	 *                   interface
	 * @param arr        ArrayList of object type T to be quicksorted
	 * @param leftBound  the left most boundary index of the segment of arr
	 *                   currently being recursively called/sorted
	 * @param rightBound the right most boundary of the segment of arr currently
	 *                   being recursively called/sorted
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr, int leftBound, int rightBound) {
		// Checks whether to end the recursive calling
		if (leftBound < rightBound) {
			// Sets up indexes of the right & left boundary indexes
			int L = leftBound;
			int R = rightBound - 1;
			// Decides which pivot to use-decides pivot
			int pivotInt = leftBound;
			if (whichMethod == 1) {
				pivotInt = pivotMethodAverageFirstMiddleLast(arr, leftBound, rightBound);
			}
			else if (whichMethod == 2) {
				pivotInt = pivotMethodRandom(arr, leftBound, rightBound);
			}
			else {
				pivotInt = pivotMethodFirstIndex(arr, leftBound);
			}
			// Sets up pivot, places it temporarily at end of segment
			T pivot = arr.get(pivotInt);
			swapReferences(arr, pivotInt, rightBound);
			// Sorts segment into further segments, either above or below pivot
			while (L <= R) {
				while (L < rightBound && arr.get(L).compareTo(pivot) <= 0)
					L++;
				while (R >= leftBound && arr.get(R).compareTo(pivot) >= 0)
					R--;

				if (L < R)
					swapReferences(arr, L, R);
			}
			// Puts pivot into propper place, calls recursive function if segments further
			// need to be split/sorted
			swapReferences(arr, L, rightBound);
			quicksort(arr, leftBound, L - 1);
			quicksort(arr, L + 1, rightBound);
		} else {
			return;
		}
	}
	
	

	/**
	 * Swaps the contents of the indexes (L,R) of the inputed ArrayList.
	 * 
	 * @param <T> Object type within ArrayList that extends the Comparable interface
	 * @param arr ArrayList of object type T to be merge sorted
	 * @param L   index of array that is to have its contents switched
	 * @param R   index of array that is to have its contents switched
	 */
	public static <T extends Comparable<? super T>> void swapReferences(ArrayList<T> arr, int L, int R) {
		T temp = arr.get(R);
		arr.set(R, arr.get(L));
		arr.set(L, temp);
	}

	/**
	 * Takes the beginning, end, and middle index of the chosen segment of the array
	 * being sorted by mergesort and finds which one is the median of the three. It
	 * then chooses the index of the median and returns that as the pivot for the
	 * current mergesort.
	 * 
	 * @param <T>   Object type within ArrayList that extends the Comparable
	 *              interface
	 * @param arr   ArrayList of object type T to be merge sorted
	 * @param start The starting index of the chosen array segment
	 * @param end   The end index of the chosen array segment
	 * @return Chosen integer index to act as pivot
	 */
	public static <T extends Comparable<? super T>> int pivotMethodAverageFirstMiddleLast(ArrayList<T> arr, int start,
			int end) {
		int mid = ((end - start) / 2) + start;
		T startT = arr.get(start);
		T midT = arr.get(mid);
		T endT = arr.get(end);

		if (startT.compareTo(midT) <= 0 && midT.compareTo(endT) <= 0) {
			return mid;
		}
		if (endT.compareTo(midT) <= 0 && midT.compareTo(startT) <= 0) {
			return mid;
		}

		if (midT.compareTo(startT) <= 0 && startT.compareTo(endT) <= 0) {
			return start;
		}
		if (endT.compareTo(startT) <= 0 && startT.compareTo(midT) <= 0) {
			return start;
		} else {
			return end;
		}
	}

	/**
	 * Randomly chooses an index within the segment of arr (the array being sorted
	 * in mergesort) between the start and end index to be used as a pivot within
	 * the sort.
	 * 
	 * @param <T>   Object type within ArrayList that extends the Comparable
	 *              interface
	 * @param arr   ArrayList of object type T to be merge sorted
	 * @param start The starting index of the chosen array segment
	 * @param end   The end index of the chosen array segment
	 * @return Chosen integer index to act as pivot
	 */
	public static <T extends Comparable<? super T>> int pivotMethodRandom(ArrayList<T> arr, int start, int end) {
		Random random = new Random();
		int pivot = start + random.nextInt((end - start) + 1);
		return pivot;

	}
	/**
	 * Chooses the first index within the segmetn of arr (the array being sorted in mergesort) to be used
	 * as a pivot
	 * @param <T> Object type within ArrayList that extends the Comparable
	 *              interface
	 * @param arr ArrayList of object type T to be merge sorted
	 * @param start The starting index of the chosen array segment
	 * @return Chosen integer index to act as pivot
	 */
	public static <T extends Comparable<? super T>> int pivotMethodFirstIndex(ArrayList<T> arr, int start) {
		int pivot = start;
		return pivot;

	}
}
