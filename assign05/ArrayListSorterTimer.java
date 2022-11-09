package com.Assignments.assign05;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ArrayListSorterTimer {

    public String CSV_FILE_NAME;


    public static void writeDataAtOnce(String filePath, ArrayList<String[]> data) {

        // first create file object for file placed at location
        // specified by filepath
        File file = new File(filePath);

        try {
            // create FileWriter object with file as parameter
            FileWriter outputFile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputFile, ';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            writer.writeAll(data);
            // closing writer connection
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


        public static void mergeIntsWithThreshold(int mergeThreshold, ArrayList<Integer> list){
        ArrayListSorter.sizeThreshold = mergeThreshold;
        ArrayListSorter.mergesort(list);
        
    }

    public static void quickSortIntsWithThreshold(int quickThreshold, ArrayList<Integer> list){
        ArrayListSorter.whichMethod = quickThreshold;
        ArrayListSorter.quicksort(list);

    }
    public static ArrayList<String[]> mergeTime(int timesToLoop, int mergeThreshold, int maxSizeArray, int increment){
        int min = 1;
        int max = maxSizeArray;
        int size = max / increment;


        int index = 0;
        int j = 0;
        ArrayList<String[]> data = new ArrayList<String[]>(size);

        while (index < size) {

            int arraySize = min + j;
            ArrayList<Integer> list = ArrayListSorter.generatePermuted(arraySize);

            long startTime = System.nanoTime();
            for (int i = 0; i < timesToLoop; i++) {
                ArrayList<Integer> arr = new ArrayList<Integer>(list);
                mergeIntsWithThreshold(mergeThreshold, arr);
            }
            long midPointTime = System.nanoTime();
            for (int i = 0; i < timesToLoop; i++) {
                ArrayList<Integer> arr = new ArrayList<Integer>(list);
            }
            long endTime = System.nanoTime();
            long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
            data.add(new String[]{Integer.toString(j) + "," + Long.toString(avg) + "," + Integer.toString(mergeThreshold) + "," + Integer.toString(timesToLoop)});
            j += increment;
            index++;
        }
        return data;
    }

    public static ArrayList<String[]> quickSortTime(int timesToLoop,int quickThreshold, int maxSizeArray, int increment){
        int min = 1;
        int max = maxSizeArray;
        int size = max / increment;

        int index = 0;
        int j = 0;
        ArrayList<String[]> data = new ArrayList<String[]>(size);

        while (index < size) {

            int arraySize = min + j;
            ArrayList<Integer> list = ArrayListSorter.generatePermuted(arraySize);

            long startTime = System.nanoTime();
            for (int i = 0; i < timesToLoop; i++) {
                ArrayList<Integer> arr = new ArrayList<Integer>(list);
                quickSortIntsWithThreshold(quickThreshold, arr);
            }
            long midPointTime = System.nanoTime();
            for (int i = 0; i < timesToLoop; i++) {
                ArrayList<Integer> arr = new ArrayList<Integer>(list);
            }
            long endTime = System.nanoTime();
            long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
            data.add(new String[]{Integer.toString(j) + "," + Long.toString(avg) + "," + Integer.toString(quickThreshold) + "," + Integer.toString(timesToLoop)});
            j += increment;
            index++;
        }
        return data;
    }

    public static void getDATAQS(int timesToLoop,int arrSize, int incrementArr){


        ArrayList<String[]> a = new ArrayList<String[]>();
        a.add(new String[]{"itemsInArray" + "," + "time(ns)" +"," + "mergeThreshold" + "," + "timesToLoop"});



        String f =  "QS_TimesTo" + Integer.toString(timesToLoop) + "MergeThresholdTo1000ArrSizeTo" + Integer.toString(arrSize) + ".csv";

        System.out.println("===========================================================\n===========================================================");
        System.out.println(f);
        System.out.println("===========================================================\n===========================================================");
        Path p = Paths.get(f);
        String file = p.getFileName().toString();

        for(int i = 1; i <= 1; i++){
            System.out.println("Writing File for... \n" +" Times to loop: " + Integer.toString(i) + " "
                    +" Items In Array: " + Integer.toString(arrSize) + "QsMethod" + Integer.toString(1));

                a.addAll(quickSortTime(100,1,arrSize,incrementArr));

        }
        for(int i = 1; i <= 1; i++){
            System.out.println("Writing File for... \n" +" Times to loop: " + Integer.toString(i) + " "
                    +" Items In Array: " + Integer.toString(arrSize) + "QsMethod" + Integer.toString(3));

            a.addAll(quickSortTime(100,3,arrSize,incrementArr));

        }
        for(int i = 1; i <= 1; i++){
            System.out.println("Writing File for... \n" +" Times to loop: " + Integer.toString(i) + " "
                    +" Items In Array: " + Integer.toString(arrSize) + "QsMethod" + Integer.toString(2));

            a.addAll(quickSortTime(100,2,arrSize,incrementArr));

        }
        writeDataAtOnce(file, a);
    }
    public static void getDATAMS(int timesToLoop,int arrSize, int incrementArr){
        System.out.println("===========================================================\n===========================================================");
        ArrayList<String[]> a = new ArrayList<String[]>();
        a.add(new String[]{"itemsInArray" + "," + "time(ns)" +"," + "mergeThreshold" + "," + "timesToLoop"});

        String f =  "MS_TimesTo" + Integer.toString(timesToLoop) + "MergeThresholdTo1000ArrSizeTo" + Integer.toString(arrSize) + ".csv";
        System.out.println(f);
        System.out.println("===========================================================\n===========================================================");

        Path p = Paths.get(f);
        String file = p.getFileName().toString();
        int varInc = 1;
        int varEnd = 10;
        int varStart = 1;


            System.out.println("Writing File for... \n" +" Times to loop: " + Integer.toString(timesToLoop) + " "
                    +" Items In Array: " + Integer.toString(arrSize) + "mergeSizeFrom" + Integer.toString(varStart) + "To" +Integer.toString(varEnd));
            for(int j = varStart; j < varEnd; j+= varInc){
                a.addAll(mergeTime(100,j,arrSize,incrementArr));

        }
        varInc = 5;
        varStart = varEnd;
        varEnd = 25;

        System.out.println("Writing File for... \n" +" Times to loop: " + Integer.toString(timesToLoop) + " "
                +" Items In Array: " + Integer.toString(arrSize) + "mergeSizeFrom" + Integer.toString(varStart) + "To" +Integer.toString(varEnd));
        for(int j = varStart; j < varEnd; j+= varInc){
            a.addAll(mergeTime(100,j,arrSize,incrementArr));

        }
        varInc = 25;
        varStart = varEnd;
        varEnd = 100;
        System.out.println("Writing File for... \n" +" Times to loop: " + Integer.toString(timesToLoop) + " "
                +" Items In Array: " + Integer.toString(arrSize) + "mergeSizeFrom" + Integer.toString(varStart) + "To" +Integer.toString(varEnd));
        for(int j = varStart; j < varEnd; j+= varInc){
            a.addAll(mergeTime(100,j,arrSize,incrementArr));

        }

        varInc = 100;
        varStart = varEnd;
        varEnd = 1000;
        System.out.println("Writing File for... \n" +" Times to loop: " + Integer.toString(timesToLoop) + " "
                +" Items In Array: " + Integer.toString(arrSize) + "mergeSizeFrom" + Integer.toString(varStart) + "To" +Integer.toString(varEnd));
        for(int j = varStart; j < varEnd; j+= varInc){
            a.addAll(mergeTime(100,j,arrSize,incrementArr));

        }
        System.out.println("Writing File for... \n" +" Times to loop: " + Integer.toString(timesToLoop) + " "
                +" Items In Array: " + Integer.toString(arrSize) + "mergeSizeFrom" + Integer.toString(varStart) + "To" +Integer.toString(varEnd));

            a.addAll(mergeTime(100,1000,arrSize,incrementArr));


        writeDataAtOnce(file, a);
        System.out.println("===========================================================\n===========================================================");
        System.out.println("Done");
        System.out.println("===========================================================\n===========================================================");
    }




    public static ArrayList<String[]> getDataBoth(int timesToLoop, int maxSizeArray, int increment){
        int min = 1;
        int max = maxSizeArray;
        int size = max / increment;

        int index = 0;
        int j = 0;
        ArrayList<String[]> data = new ArrayList<String[]>(size);

        while (index < size) {

            int arraySize = min + j;
            ArrayList<Integer> list = ArrayListSorter.generateDescending(arraySize);

            long startTime = System.nanoTime();
            for (int i = 0; i < timesToLoop; i++) {
                ArrayList<Integer> arr = new ArrayList<Integer>(list);
                quickSortIntsWithThreshold(1, arr);
            }
            long midPointTime = System.nanoTime();
            for (int i = 0; i < timesToLoop; i++) {
                ArrayList<Integer> arr = new ArrayList<Integer>(list);
            }
            long endTime = System.nanoTime();
            long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;

            startTime = System.nanoTime();
            for (int i = 0; i < timesToLoop; i++) {
                ArrayList<Integer> arr = new ArrayList<Integer>(list);
                mergeIntsWithThreshold(20, arr);
            }
            midPointTime = System.nanoTime();
            for (int i = 0; i < timesToLoop; i++) {
                ArrayList<Integer> arr = new ArrayList<Integer>(list);
            }
            endTime = System.nanoTime();
            long avg2 = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
            data.add(new String[]{Integer.toString(j) + "," + Long.toString(avg) + "," + Long.toString(avg2)});


            j += increment;
            index++;
        }
        return data;
    }

    public static void getDATAALL(int timesToLoop,int arrSize, int incrementArr){
        System.out.println("===========================================================\n===========================================================");
        ArrayList<String[]> a = new ArrayList<String[]>();
        a.add(new String[]{"itemsInArray" + "," + "timeQS(ns)" +"," + "timeMS(ns)"});

        String f =  "MS_TimesTo" + Integer.toString(timesToLoop) + "Pivot1MergeThreshold20ArrSizeTo" + Integer.toString(arrSize) + ".csv";
        System.out.println(f);
        System.out.println("===========================================================\n===========================================================");

        Path p = Paths.get(f);
        String file = p.getFileName().toString();


        System.out.println("Writing File for... \n" +" Times to loop: " + Integer.toString(timesToLoop) + " "
                +" Items In Array: " + Integer.toString(arrSize) + "Pivot1MergeThreshold20");

        a.addAll(getDataBoth(timesToLoop,arrSize,incrementArr));


        writeDataAtOnce(file, a);
        System.out.println("===========================================================\n===========================================================");
        System.out.println("Done");
        System.out.println("===========================================================\n===========================================================");
    }

    public static void main(String[] args){



//        System.out.println("Starting Data Collection MergeSort");
//        getDATAMS(100,100000,100);
//        System.out.println("===========================================================\n===========================================================");
//        System.out.println("Done");
//        System.out.println("===========================================================\n===========================================================");
        getDATAALL(100,10000,100);
        System.out.println("Starting Data Collection all");
        System.out.println("===========================================================\n===========================================================");
        System.out.println("Done");
        System.out.println("===========================================================\n===========================================================");

    }









}
