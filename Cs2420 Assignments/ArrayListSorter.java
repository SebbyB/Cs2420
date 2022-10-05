package com.assign05;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSorter <T> {

    public static int sizeThreshold = 1;

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


    public static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> array) {
        for (int i = 1; i < array.size(); i++){
            int j = i - 1;
            T temp = array.get(i);
            while((j >= 0 && temp.compareTo(array.get(j)) <= 0)){
                array.set(j + 1,array.get(j));
                j--;

            }

            array.set(j + 1,temp);

        }
    }

    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr, ArrayList<T> temp, int start, int end) {



        int mid = start + (end - start) / 2;
        // TODO: Replace this with an insertion sort threshold
        if ((start + sizeThreshold) >= end) {

            insertionSort(arr);
        }

        mergesort(arr, temp, start, mid);
        mergesort(arr, temp, mid + 1, end);
        merge(arr, temp, start, mid, end);
    }

    public static <T extends Comparable<? super T>> void merge(ArrayList<T> arr, ArrayList<T> temp, int start, int mid, int end) {

        int i = start;
        int j = mid + 1;
        int mergePos = start;


        while (i <= mid && j <= end) {
            if (arr.get(i).compareTo(arr.get(j)) <= 0) {
                //
//                temp[mergePos++] = arr[i++];
                temp.add(mergePos++,arr.get(i++));
            } else {
//                temp[mergePos++] = arr[j++];
                temp.add(mergePos++,arr.get(j++));
            }
        }

//        copy anything left over from larger half to temp
//        copy temp (from start to end) back into arr (from start to end)

    }


    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr) {

        ArrayList<T> temp = new ArrayList<T>(arr.size());

        mergesort(arr, temp, 0, arr.size() - 1);

    }

    public static ArrayList<Integer> generateAscending(int size) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) {

            arrayList.add(i);

        }
        return arrayList;
    }

    public static ArrayList<Integer> generateDescending(int size) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(size);
        for (int i = size; i > 0; i--) {
            arrayList.add(i);
        }
        return arrayList;
    }

    public static ArrayList<Integer> generatePermuted(int size) {

      ArrayList<Integer> a = ArrayListSorter.generateAscending(size);
        Collections.shuffle(a);
        return a;
    }


    public static void main(String[] args){

        ArrayList n = generatePermuted(50);
//        for(int i = 1; i <= 5; i++){
//        n.add(i);}



        System.out.println(n.toString());

        mergesort(n);

        System.out.println(n.toString());


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

