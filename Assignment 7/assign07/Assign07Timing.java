//package assign06;
package assign07;


import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

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








    public static ArrayList<Integer> generateSortedList(int listSize){

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < listSize; i++) {
            list.add(i);
        }
        return list;
    }
    public static ArrayList<Integer> generateReverseOrderList(int listSize){

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = listSize; i >= 0; i--) {
            list.add(i);
        }
        return list;
    }

    public static ArrayList<Integer> generateRandomList(int listSize){

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < listSize; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }


    public static String containsTiming(int timesToLoop, ArrayList<Integer> list){
        BinarySearchTree<Integer> testTree = new BinarySearchTree<Integer>();

        for(Integer element : list){
            testTree.add(element);
        }
        long startTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {



            testTree.containsAll(list);
        }
        long midPointTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
        }
        long endTime = System.nanoTime();
        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
        return Long.toString(avg);
    }
    public static String containsTimingJava(int timesToLoop, ArrayList<Integer> list){
        java.util.TreeSet testTree = new TreeSet<>();

        for(Integer element : list){
            testTree.add(element);
        }
        long startTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {



            testTree.containsAll(list);
        }
        long midPointTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
        }
        long endTime = System.nanoTime();
        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
        return Long.toString(avg);
    }



    public static void collectDataFirstExperiment(int maxSizeArray, int increment, int timesToLoop){

        System.out.println(seperate);
        System.out.println("Starting First Timing Experiment...");
        System.out.println("Parameters: (MaxSizeArray, IncrementOfArray, timesToLoop)");
        System.out.println("(" + Integer.toString(maxSizeArray) + "," + Integer.toString(increment) + Integer.toString(timesToLoop)+")");
        System.out.println("Data: (Items in List (n), SortedTree Time in NanoSeconds,  Descending Tree Time in NanoSeconds.  RandomTree Time in NanoSeconds )");

        String[] dataPoint = new String[]{"ItemsInList"  + "," + "SortedTree time(ns)" + "," + "DescendingTree time(ns)"+ "," + "RandomTree time(ns)"};

        System.out.println(seperate);

        ArrayList<String[]> data = new ArrayList<String[]>();
        data.add(dataPoint);
        System.out.println(seperate);

        System.out.println("Timing Code...");
        System.out.println(seperate);



        for(int n = 1; n <= maxSizeArray; n++){

            ArrayList<Integer> sortedList = generateSortedList(n);
            String sortedTime = containsTiming(timesToLoop,sortedList);
            ArrayList<Integer> reverseOrderList = generateReverseOrderList(n);
            String descendingTime = containsTiming(timesToLoop,reverseOrderList);
            ArrayList<Integer> randomList = generateRandomList(n);
            String randomTime = containsTiming(timesToLoop,randomList);


            dataPoint = new String[]{Integer.toString(n) + "," + sortedTime +"," + descendingTime+ "," + randomTime};
            data.add(dataPoint);

        }

        System.out.println("Exporting To File...");
        String f =  "ContainsTime" + ".csv";
        System.out.println(f);
        Path p = Paths.get(f);
        String file = p.getFileName().toString();
        writeDataAtOnce(file, data);
        System.out.println(seperate);
        System.out.println("Done");
        System.out.println(seperate);

    }

    public static void collectExp1(int maxSizeArray, int increment, int timesToLoop){

        System.out.println(seperate);
        System.out.println("Starting First Timing Experiment...");
        System.out.println("Parameters: (MaxSizeArray, IncrementOfArray, timesToLoop)");
        System.out.println("(" + Integer.toString(maxSizeArray) + "," + Integer.toString(increment) + Integer.toString(timesToLoop)+")");
        System.out.println("Data: (Items in List (n), SortedTree Time in NanoSeconds,  Descending Tree Time in NanoSeconds.  RandomTree Time in NanoSeconds )");

        String[] dataPoint = new String[]{"ItemsInList"  + "," + "SortedTree time(ns)" + "," + "DescendingTree time(ns)"+ "," + "RandomTree time(ns)"};

        System.out.println(seperate);

        ArrayList<String[]> data = new ArrayList<String[]>();
        data.add(dataPoint);
        System.out.println(seperate);

        System.out.println("Timing Code...");
        System.out.println(seperate);



        for(int n = 1; n <= maxSizeArray; n++){

            ArrayList<Integer> sortedList = generateSortedList(n);
            String sortedTime = containsTiming(timesToLoop,sortedList);
            ArrayList<Integer> reverseOrderList = generateReverseOrderList(n);
            String descendingTime = containsTiming(timesToLoop,reverseOrderList);
            ArrayList<Integer> randomList = generateRandomList(n);
            String randomTime = containsTiming(timesToLoop,randomList);


            dataPoint = new String[]{Integer.toString(n) + "," + sortedTime +"," + descendingTime+ "," + randomTime};
            data.add(dataPoint);

        }

        System.out.println("Exporting To File...");
        String f =  "ContainsTime" + ".csv";
        System.out.println(f);
        Path p = Paths.get(f);
        String file = p.getFileName().toString();
        writeDataAtOnce(file, data);
        System.out.println(seperate);
        System.out.println("Done");
        System.out.println(seperate);

    }


    public static void collectExp2(int maxSizeArray, int increment, int timesToLoop){

        System.out.println(seperate);
        System.out.println("Starting Second Timing Experiment...");
        System.out.println("Parameters: (MaxSizeArray, IncrementOfArray, timesToLoop)");
        System.out.println("(" + Integer.toString(maxSizeArray) + "," + Integer.toString(increment) +","+ Integer.toString(timesToLoop)+")");
        System.out.println("Data: (Items in List (n),Our SortedTree time(ns), Our DescendingTree time(ns), Our RandomTree time(ns), Java SortedTree time(ns), Java DescendingTree time(ns), Java RandomTree time(ns))");

        String[] dataPoint = new String[]{"Items in List (n)"  + "," + "Our SortedTree time(ns)" + "," + "Our DescendingTree time(ns)"+ "," + " Our RandomTree time(ns)" + "," +
                "Java SortedTree time(ns)" + "," + "Java DescendingTree time(ns)"+ "," + " Java RandomTree time(ns)"};

        System.out.println(seperate);

        ArrayList<String[]> data = new ArrayList<String[]>();
        data.add(dataPoint);
        System.out.println(seperate);

        System.out.println("Timing Code...");
        System.out.println(seperate);


        int factor = (maxSizeArray/increment);

        for(int n = 1; n <= maxSizeArray; n+= increment){


//            int percent = n % factor;
//            System.out.println(percent + "% complete...");
            ArrayList<Integer> sortedList = generateSortedList(n);
            String sortedTime = containsTiming(timesToLoop,sortedList);
//            System.out.println("Our sorted... " + n);

            ArrayList<Integer> reverseOrderList = generateReverseOrderList(n);
            String descendingTime = containsTiming(timesToLoop,reverseOrderList);
//            System.out.println("Our reverse... ");

            ArrayList<Integer> randomList = generateRandomList(n);
//            System.out.println("Our random... ");
            String randomTime = containsTiming(timesToLoop,randomList);
            String javaSortedTime = containsTimingJava(timesToLoop,sortedList);
//            System.out.println("Java sorted... ");

            String javaDescendingTime = containsTimingJava(timesToLoop,reverseOrderList);
//            System.out.println("Java reverse... ");

            String javaRandomTime = containsTimingJava(timesToLoop,randomList);
//            System.out.println("Java random... ");



            dataPoint = new String[]{Integer.toString(n) + "," + sortedTime +"," + descendingTime+ "," + randomTime + "," + javaSortedTime +"," + javaDescendingTime+ "," + javaRandomTime};
            data.add(dataPoint);

        }

        System.out.println("Exporting To File...");
        String f =  "ContainsTime" + ".csv";
        System.out.println(f);
        Path p = Paths.get(f);
        String file = p.getFileName().toString();
        writeDataAtOnce(file, data);
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
        System.out.println("Times to Loop...");
        int timesToLoop = S.nextInt();
        collectExp2(maxSize,increment,timesToLoop);




    }



}
