package assign10;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class TimingExp {









        public static String CSV_FILE_NAME;
        public static String seperate = "===========================================================\n===========================================================";
        public static String comma = ",";


        public static void writeDataAtOnce(String filePath, ArrayList<String[]> data) {

            // first create file object for file placed at location
            // specified by filepath
            File file = new File(filePath);

            try {
                // create FileWriter object with file as parameter
                FileWriter outputFile = new FileWriter(file);

                // create CSVWriter object filewriter object as parameter
                CSVWriter writer = new CSVWriter(outputFile, ',',
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




    public static String addTiming(int timesToLoop,int size, boolean isWorst) {

        BinaryMaxHeap<Integer> testHeap = new BinaryMaxHeap<>();

        long startTime;
        long endTime;
        long midPointTime;
        if(isWorst){
            startTime = System.nanoTime();
            for(int i = 1; i <= timesToLoop; i++) {
                for(int j = 0; j < size; j++){
                    testHeap.add(j);
                    continue;
                }
        }
            midPointTime = System.nanoTime();
            for(int i = 1; i <= timesToLoop; i++) {
                for (int j = 0; j < size; j++){
                    continue;
                }
            }
        endTime = System.nanoTime();
        }
        else {
             startTime = System.nanoTime();
            for (int i = 1; i <= timesToLoop; i++) {
                for(int j = size; j > 0; j--){
                    testHeap.add(j);
                }
            }
             midPointTime = System.nanoTime();
            for (int i = 1; i <= timesToLoop; i++) {
                for (int j = size; j > 0; j--){
                }
            }
             endTime = System.nanoTime();
        }
        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
        return Long.toString(avg);

    }
    public static String extractMaxTiming(int timesToLoop,int size, boolean isWorst) {

        BinaryMaxHeap<Integer> testHeap = new BinaryMaxHeap<>();

        long startTime;
        long endTime;
        long midPointTime;

        if(!isWorst){
            startTime = System.nanoTime();
            for(int i = 1; i <= timesToLoop; i++) {
                for(int j = 0; j < size; j++){
                    testHeap.add(j);
                }
                testHeap.extractMax();
                testHeap.clear();
        }
            midPointTime = System.nanoTime();
            for(int i = 1; i <= timesToLoop; i++) {
                for(int j = 0; j < size; j++){
                    testHeap.add(j);
                }
                testHeap.clear();
            }
        endTime = System.nanoTime();
        }
        else {
            startTime = System.nanoTime();
            for(int i = 1; i <= timesToLoop; i++) {
                for(int j = size; j > 0; j--){
                    testHeap.add(j);
                }
                testHeap.extractMax();
                testHeap.clear();
            }
            midPointTime = System.nanoTime();
            for(int i = 1; i <= timesToLoop; i++) {
                for(int j = size; j > 0; j--){
                    testHeap.add(j);
                }
                testHeap.clear();
            }
            endTime = System.nanoTime();
        }
        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
        return Long.toString(avg);

    }
    public static String peekTiming(int timesToLoop,int size) {

        BinaryMaxHeap<Integer> testHeap = new BinaryMaxHeap<>();

        for(int j = 0; j < size; j++){
            testHeap.add(j);
        }
        long startTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
                testHeap.peek();
        }
        long midPointTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
        }
        long endTime = System.nanoTime();

        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
        return Long.toString(avg);
    }

    public static String oursVsJavasTiming(int timesToLoop,int k, ArrayList<Integer> list, boolean isOurs) {



        long startTime;
        long endTime;
        long midPointTime;

        if(isOurs){
            startTime = System.nanoTime();
            for(int i = 1; i <= timesToLoop; i++) {
                FindKLargest.findKLargestHeap(list,k);
            }
            midPointTime = System.nanoTime();
            for(int i = 1; i <= timesToLoop; i++) {

            }
            endTime = System.nanoTime();
        }
        else {
            startTime = System.nanoTime();
            for(int i = 1; i <= timesToLoop; i++) {
                FindKLargest.findKLargestSort(list,k);
            }
            midPointTime = System.nanoTime();
            for(int i = 1; i <= timesToLoop; i++) {

            }
            endTime = System.nanoTime();
        }
        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
        return Long.toString(avg);

    }

    public static void runExp(int n,int timesToLoop,int increment){

            System.out.println(seperate);
            System.out.println("Running Exp");
            System.out.println(seperate);

            String peek = "peek() time (ns)";
            String bestCaseAdd = "add() Best Case time (ns)";
            String worstCaseAdd = "add() Worst Case time (ns)";
            String bestCaseExtractMax = "extractMax() Best Case time (ns)";
            String worstCaseExtractMax = "extractMax() Worst Case time (ns)";
            String N = "Items (n)";
            String nLogN = "nlogn";
            String logN = " logn";
            ArrayList<String[]> data = new ArrayList<>();
//            String[] dataPoint = {peek,comma,bestCaseAdd,comma,worstCaseAdd,comma,bestCaseExtractMax,comma,worstCaseExtractMax};
            String[] dataPoint = {peek,bestCaseAdd,worstCaseAdd,bestCaseExtractMax,worstCaseExtractMax,N,logN,nLogN};
            System.out.println(Arrays.toString(dataPoint));
            data.add(dataPoint);
            try{
            for(int size = 0; size <= n; size+= increment){


//                System.out.println(size);

                peek = peekTiming(timesToLoop,n);
                bestCaseAdd= addTiming(timesToLoop,n,false);
                worstCaseAdd = addTiming(timesToLoop,n,true);
                bestCaseExtractMax = extractMaxTiming(timesToLoop,n,false);
                worstCaseExtractMax = extractMaxTiming(timesToLoop,n,true);
                N = Integer.toString(size);
                nLogN = Double.toString(size*java.lang.Math.log10(size));
                logN = Double.toString(java.lang.Math.log10(size));
//                dataPoint = new String[]{peek,comma,bestCaseAdd,comma,worstCaseAdd,comma,bestCaseExtractMax,comma,worstCaseExtractMax};
                dataPoint = new String[]{peek,bestCaseAdd,worstCaseAdd,bestCaseExtractMax,worstCaseExtractMax,N,logN,nLogN};
                data.add(dataPoint);


        }}
            catch (Exception e){
                e.printStackTrace();
            }

            finally{
            CSV_FILE_NAME = "Assignment 10/assign10/CSV Files/Assign10Exp1.csv";
            System.out.println("Writing to file: " + CSV_FILE_NAME);
            writeDataAtOnce(CSV_FILE_NAME,data);
            System.out.println(seperate);
            System.out.println("Done");
            System.out.println(seperate);
    }}

    public static void runExp2(int n,int timesToLoop,int increment){

        System.out.println(seperate);
        System.out.println("Running Exp2");
        System.out.println(seperate);

        String ours = "our Find Largest Time (ns)";
        String java = "Java's Find Largest Time (ns)";
        String N = "Items (k)";

        ArrayList<String[]> data = new ArrayList<>();
//            String[] dataPoint = {peek,comma,bestCaseAdd,comma,worstCaseAdd,comma,bestCaseExtractMax,comma,worstCaseExtractMax};
        String[] dataPoint = {ours,java,N};
        System.out.println(Arrays.toString(dataPoint));
        data.add(dataPoint);
try {
    for (int size = 0; size <= n - 2; size += increment) {
        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println(size);
        for (int i = 0; i <= n; i++) {
            list.add(i);
        }
        ArrayList<Integer> list2 = new ArrayList<>(list);
        ours = oursVsJavasTiming(timesToLoop, size, list, true);
        java = oursVsJavasTiming(timesToLoop, size, list2, false);

        N = Integer.toString(size);
//                dataPoint = new String[]{peek,comma,bestCaseAdd,comma,worstCaseAdd,comma,bestCaseExtractMax,comma,worstCaseExtractMax};
        dataPoint = new String[]{ours, java, N};
        data.add(dataPoint);


    }
}
catch (Exception e){
    e.printStackTrace();
}
finally {


        CSV_FILE_NAME = "Assignment 10/assign10/CSV Files/Assign10Exp2.csv";
        System.out.println("Writing to file: " + CSV_FILE_NAME);
        writeDataAtOnce(CSV_FILE_NAME,data);
        System.out.println(seperate);
        System.out.println("Done");
        System.out.println(seperate);}
    }






         public static void main(String[] args) {
             Scanner S = new Scanner(System.in);
             System.out.println(seperate);
             System.out.println("Start Data Collection with parameters:");
             System.out.println("MaxSize...");
             int maxSize = S.nextInt();
             System.out.println("Increment n...");
             int increment = S.nextInt();
             System.out.println("Times to Loop...");
             int timesToLoop = S.nextInt();


             runExp(maxSize,timesToLoop,increment);
             runExp2(maxSize,timesToLoop,increment);
        }









}
