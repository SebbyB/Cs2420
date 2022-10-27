package com.Assignments.assign07;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Assign07Timing {


    public String CSV_FILE_NAME;
    public static String seperate = "===========================================================\n===========================================================";


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







    public static String addTiming(int timesToLoop, ArrayList<Integer> list){

        long startTime = System.nanoTime();

            for (int i = 1; i <= timesToLoop; i++) {
                BinarySearchTree testTree = new BinarySearchTree();
                testTree.addAll(list);
            }

            long midPointTime = System.nanoTime();

            for (int i = 1; i <= timesToLoop; i++) {
                BinarySearchTree testTree = new BinarySearchTree();

            }
            long endTime = System.nanoTime();
            long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
        return Long.toString(avg);
    }

    public static ArrayList<Integer> createSortedArray(int sizeN){

        ArrayList<Integer> retArray = new ArrayList<Integer>();

        for (int i = 1; i <= sizeN; i++){
            retArray.add(i);
        }
        return retArray;
    }


    public static ArrayList<Integer> createUnSortedArray(int sizeN){

        ArrayList<Integer> retArray = new ArrayList<Integer>();

        for (int i = sizeN; i >= 1; i--){
            retArray.add(i);
        }
        return retArray;
    }


    public static void collectDataSortedVsNonSorted( int MaxSizeArray, int increment, int timesToLoop){

        System.out.println(seperate);


        System.out.println("Starting Timing Experiment for Sorted Vs UnSorted");
        System.out.println("Parameters: (MaxSizeArray, IncrementOfArray)");
        System.out.println("(" + Integer.toString(MaxSizeArray) + "," + Integer.toString(increment) + ")");
        System.out.println("Data: (N Items in List, Time in NanoSeconds Sorted, Time in NanoSeconds Unsorted)");

        String[] data = new String[]{"ItemsInList"  + "," + "Sorted time(ns)" +"UnSorted time(ns)"  };

        System.out.println(seperate);

        ArrayList<String[]> expData = new ArrayList<String[]>();
        expData.add(data);
        System.out.println(seperate);








        System.out.println("Timing Code...");
        System.out.println(seperate);






        for(int dataPoint = 1; dataPoint < MaxSizeArray; dataPoint+= increment) {
            ArrayList<Integer> sortedArray = createSortedArray(dataPoint);
            ArrayList<Integer> unSortedArray = createUnSortedArray(dataPoint);
            data = new String[]{Integer.toString(dataPoint), addTiming(timesToLoop, sortedArray), addTiming(timesToLoop, unSortedArray)};
            expData.add(data);
        }
        System.out.println("Exporting To File...");
        String f =  "SortedVsUnsortedTiming" + ".csv";
        System.out.println(f);
        Path p = Paths.get(f);
        String file = p.getFileName().toString();
        writeDataAtOnce(file, expData);
        System.out.println(seperate);





        System.out.println("Done");
        System.out.println(seperate);



    }


    public static void main(String[] args) {


        Scanner S = new Scanner(System.in);
        System.out.println(seperate);
        System.out.println("Start Data Collection with parameters:");
        System.out.println("MaxSize...");
        int maxSize = S.nextInt();
        System.out.println("Increment...");
        int increment = S.nextInt();
        System.out.println("TimesToLoop...");
        int timesToLoop = S.nextInt();
        collectDataSortedVsNonSorted(maxSize,increment,timesToLoop);
    }
}
