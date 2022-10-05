package com.assign05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class ArrayListSorter <T> {

    public int sizeThreshold = 1;

    /**
     * Changes the mergeSort to insertSort Threshold.
     *
     * @param n - size desired.
     */

    public void changeMergeSize(int n) {
        sizeThreshold = n;
    }

    /**
     * Getter Method for Threshold.
     * @return
     */
    public int getThreshold() {
        return sizeThreshold;
    }


    public static <T> void insertionSort(ArrayList<T> array,ArrayList<T> tempArr) {
        for (int i = 0; i <= array.size(); i++) {
            int j = i;
            while (j > 0 && array.get(i).compareTo(array.get(j - 1)) == -1) {
                temp[j] = tempArr.get(j - 1);
                j--;
            }
        }

        for(int k = 0; k < temp.size(); k++) {
            array.removeAll(array);
            array.add(temp[k]);
        }
    }

    public void mergesort(ArrayList<T> arr, ArrayList<T> temp, int start, int end) {

        // TODO: Replace this with an insertion sort threshold
        if ((start + sizeThreshold - 1) >= end) {
            instertionSort(arr);
        }

        int mid = start + (end - start) / 2;
        mergesort(arr, temp, start, mid);
        mergesort(arr, temp, mid + 1, end);
        merge(arr, temp, start, mid, end);
    }

    public void merge(ArrayList<T> arr, ArrayList<T> temp, int start, int mid, int end) {

        int i = start;
        int j = mid + 1;
        int mergePos = start;


        while (i <= mid && j <= end) {
            if (arr.get(1).compareTo(arr.get(1))) {
                //
                temp[mergePos++] = arr[i++];
            } else {
                temp[mergePos++] = arr[j++];
            }
        }

//        copy anything left over from larger half to temp
//        copy temp (from start to end) back into arr (from start to end)

    }


    public <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr) {



        ArrayList<T> temp = new ArrayList<T>(arr.size());

        mergesort(arr, temp, 0, arr.size() - 1);

    }

    public ArrayList<Integer> generateAscending(int size) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) {

            arrayList.add(i);

        }
        return arrayList;
    }

    public ArrayList<Integer> generateDescending(int size) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(size);
        for (int i = size; i > 0; i--) {
            arrayList.add(i);
        }
        return arrayList;
    }

    public ArrayList<Integer> generatePermuted(int size) {
        return Collections.shuffle(shufflegenerateAscending(size));
    }


    public static void main(String[] args){
        System.out.println("Hi");
    }


}
////    find pivot, swap with item at rightBound;
//        public void quickSort(ArrayList<T>, Comparator <? super T> ){
//       
//            int L = leftBound, 
//            int R = rightBound - 1;
//
//        while(L <= R){
//            while(L < rightBound && arr[L] <= pivot){
//            L++;}
//        while(R >= leftBound && arr[R] >= pivot)
//            R--;
//
//        if(L < R)
//            swapReferences(arr, L, R);
//    }
//
//    swapReferences(arr, L, rightBound);}
//}

