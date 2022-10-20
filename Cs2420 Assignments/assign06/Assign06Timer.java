package com.assign05.assign06;


import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Assign06Timer {

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

    


    public static ArrayList<String[]> pushTimeLinkedList( int maxSizeList, int increment){
        int min = 1;
        int max = maxSizeList;
        int size = max / increment;

        
        int j = 1;
        ArrayList<String[]> data = new ArrayList<String[]>(size);
       
        while (j < maxSizeList) {

            if(j == 0){j++;}


            long startTime = System.nanoTime();
            for (int i = min; i <= j; i++) {
                LinkedListStack<Integer> list = new  LinkedListStack<>();
                list.push(i);
            }
            long midPointTime = System.nanoTime();
            for (int i = min; i <= j; i++) {
                LinkedListStack<Integer> l = new  LinkedListStack<>();
            }
            long endTime = System.nanoTime();
            long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / j;


            if ((j % 10) != 0) {
                j--;
            }
            data.add(new String[]{Integer.toString(j)+  "," + Long.toString(avg) });
            j += increment;
        }
        return data;
    }

    public static ArrayList<String[]> pushTimeArrayList( int maxSizeArray, int increment){
        int min = 1;
        int max = maxSizeArray;
        int size = max / increment;


        int j = 1;
        ArrayList<String[]> data = new ArrayList<String[]>(size);
       
        while (j < maxSizeArray) {

            if(j == 0){j++;}

            long startTime = System.nanoTime();
            for (int i = min; i <= j; i++) {
                ArrayStack<Integer> list = new ArrayStack<>();
                list.push(i);
            }
            long midPointTime = System.nanoTime();
            for (int i = min; i <= j; i++) {
                ArrayStack<Integer> l = new ArrayStack<>();
            }
            long endTime = System.nanoTime();
            long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / j;
            if ((j % 10) != 0) {
                j--;
            }
            data.add(new String[]{Integer.toString(j)+  "," + Long.toString(avg) });
            j += increment;
        }
        return data;
    }


    public static ArrayList<String[]> popTimeArrayList( int maxSize, int increment){
        int min = 1;
        int max = maxSize;
        int size = max / increment;


        int j = 1;
        ArrayList<String[]> data = new ArrayList<String[]>(size);
       
        while (j < maxSize) {

            if(j == 0){j++;}


            long startTime = System.nanoTime();
            for (int i = min; i <= j; i++) {
                ArrayStack<Integer> list = new ArrayStack<>();
                list.push(i);
                list.pop();
            }
            long midPointTime = System.nanoTime();
            for (int i = min; i <= j; i++) {
                ArrayStack<Integer> l = new ArrayStack<>();
                l.push(i);
            }
            long endTime = System.nanoTime();
            long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / j;
            if ((j % 10) != 0) {
                j--;
            }
            data.add(new String[]{Integer.toString(j)+  "," + Long.toString(avg) });
            j += increment;
        }
        return data;
    }

    public static ArrayList<String[]> popTimeLinkedList( int maxSizeList, int increment){
        int min = 1;
        int max = maxSizeList;
        int size = max / increment;


        int j = 1;
        ArrayList<String[]> data = new ArrayList<String[]>(size);
       
        while (j < maxSizeList) {

            if(j == 0){j++;}


            long startTime = System.nanoTime();
            for (int i = min; i <= j; i++) {
                LinkedListStack<Integer> list = new  LinkedListStack<>();
                list.push(i);
                list.pop();
            }
            long midPointTime = System.nanoTime();
            for (int i = min; i <= j; i++) {
                LinkedListStack<Integer> l = new  LinkedListStack<>();
                l.push(i);
            }
            long endTime = System.nanoTime();
            long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / j;
            if ((j % 10) != 0) {
                j--;
            }
            data.add(new String[]{Integer.toString(j)+  "," + Long.toString(avg) });
            j += increment;
        }
        return data;
    }


    public static ArrayList<String[]> peekTimeArrayList( int maxSize, int increment){
        int min = 1;
        int max = maxSize;
        int size = max / increment;


        int j = 1;
        ArrayList<String[]> data = new ArrayList<String[]>(size);
       
        while (j < maxSize) {

            if(j == 0){j++;}


            long startTime = System.nanoTime();
            for (int i = min; i <= j; i++) {
                ArrayStack<Integer> list = new ArrayStack<>();
                list.push(i);
                list.peek();
            }
            long midPointTime = System.nanoTime();
            for (int i = min; i <= j; i++) {
                ArrayStack<Integer> l = new ArrayStack<>();
                l.push(i);
            }
            long endTime = System.nanoTime();
            long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / j;
            if ((j % 10) != 0) {
                j--;
            }
            data.add(new String[]{Integer.toString(j)+  "," + Long.toString(avg) });
            j += increment;
        }
        return data;
    }

    public static ArrayList<String[]> peekTimeLinkedList( int maxSizeList, int increment){
        int min = 1;
        int max = maxSizeList;
        int size = max / increment;


        int j = 1;
        ArrayList<String[]> data = new ArrayList<String[]>(size);
       
        while (j < maxSizeList) {

            if(j == 0){j++;}



            long startTime = System.nanoTime();
            for (int i = min; i <= j; i++) {
                LinkedListStack<Integer> list = new  LinkedListStack<>();
                list.push(i);
                list.peek();
            }
            long midPointTime = System.nanoTime();
            for (int i = min; i <= j; i++) {
                LinkedListStack<Integer> l = new  LinkedListStack<>();
                l.push(i);
            }
            long endTime = System.nanoTime();
            long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / j;
            if ((j % 10) != 0) {
                j--;
            }
            data.add(new String[]{Integer.toString(j)+  "," + Long.toString(avg) });
            j += increment;
        }
        return data;
    }
    
    
    
    public static void collectDataArrayList( int MaxSizeArray, int increment){

        System.out.println(seperate);


        System.out.println("Starting Timing Experiments on ArrayList...");
        System.out.println("Parameters: (MaxSizeArray, IncrementOfArray)");
        System.out.println("(" + Integer.toString(MaxSizeArray) + "," + Integer.toString(increment) + ")");
        System.out.println("Data: (Items in List, Time in NanoSeconds )");

        String[] data = new String[]{"ItemsInList"  + "," + "time(ns)"};

        System.out.println(seperate);

        ArrayList<String[]> a = new ArrayList<String[]>();
        a.add(data);
                System.out.println(seperate);

        System.out.println("Timing Push Code...");
                System.out.println(seperate);
        a.addAll(pushTimeArrayList(MaxSizeArray,increment));
        System.out.println("Exporting To File...");
        String f =  "ArrayListPushTimes" + ".csv";
        System.out.println(f);
        Path p = Paths.get(f);
        String file = p.getFileName().toString();
        writeDataAtOnce(file, a);
                System.out.println(seperate);

        ArrayList<String[]> b = new ArrayList<String[]>();
        b.add(data);
        System.out.println("Timing Pop Code...");
        System.out.println(seperate);
        b.addAll(popTimeArrayList(MaxSizeArray,increment));
        System.out.println("Exporting To File...");
        f =  "ArrayListPopTimes" + ".csv";
        System.out.println(f);
        p = Paths.get(f);
        file = p.getFileName().toString();

        writeDataAtOnce(file, b);
        System.out.println(seperate);


        ArrayList<String[]> c = new ArrayList<String[]>();
        c.add(data);
        System.out.println("Timing Peek Code...");
        System.out.println(seperate);
        c.addAll(peekTimeArrayList(MaxSizeArray,increment));
        System.out.println("Exporting To File...");
        f =  "ArrayListPeekTimes" + ".csv";
        System.out.println(f);
        p = Paths.get(f);
        file = p.getFileName().toString();

        writeDataAtOnce(file, c);
        System.out.println(seperate);



        System.out.println("Done");
                System.out.println(seperate);


        
    }

    public static void collectDataLinkedList(int MaxSizeArray, int increment){

        System.out.println(seperate);


        System.out.println("Starting Timing Experiments on LinkedList...");
        System.out.println("Parameters: (TimesToLoop, MaxSizeList, IncrementOfList)");
        System.out.println("("  + Integer.toString(MaxSizeArray) + "," + Integer.toString(increment) + ")");
        System.out.println("Data: (Items in List, Time in NanoSeconds )");

        String[] data = new String[]{"ItemsInList"  + "," + "time(ns)"};

        System.out.println(seperate);

        ArrayList<String[]> a = new ArrayList<String[]>();
        a.add(data);
        System.out.println(seperate);

        System.out.println("Timing Push Code...");
        System.out.println(seperate);
        a.addAll(pushTimeLinkedList(MaxSizeArray,increment));
        System.out.println("Exporting To File...");
        String f =  "LinkedListPushTimes" + ".csv";
        System.out.println(f);
        Path p = Paths.get(f);
        String file = p.getFileName().toString();
        writeDataAtOnce(file, a);
        System.out.println(seperate);

        ArrayList<String[]> b = new ArrayList<String[]>();
        b.add(data);
        System.out.println("Timing Pop Code...");
        System.out.println(seperate);
        b.addAll(popTimeLinkedList(MaxSizeArray,increment));
        System.out.println("Exporting To File...");
        f =  "LinkedListPopTimes" + ".csv";
        System.out.println(f);
        p = Paths.get(f);
        file = p.getFileName().toString();

        writeDataAtOnce(file, b);
        System.out.println(seperate);


        ArrayList<String[]> c = new ArrayList<String[]>();
        c.add(data);
        System.out.println("Timing Peek Code...");
        System.out.println(seperate);
        c.addAll(peekTimeLinkedList(MaxSizeArray,increment));
        System.out.println("Exporting To File...");
        f =  "LinkedListPeekTimes" + ".csv";
        System.out.println(f);
        p = Paths.get(f);
        file = p.getFileName().toString();

        writeDataAtOnce(file, c);
        System.out.println(seperate);



        System.out.println("Done");
        System.out.println(seperate);



    }
    public static void main(String[] args){



        Scanner S = new Scanner(System.in);
        System.out.println(seperate);
        System.out.println("Start Data Collection with parameters:");
        System.out.println("MaxSize...");
        int maxSize = S.nextInt();
        System.out.println("Increment...");
        int increment = S.nextInt();



        collectDataArrayList(maxSize,increment);
//1000
    }



}
