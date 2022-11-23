package assign09;


import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Timer {

    public String CSV_FILE_NAME;
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











    public static String[] goodHashPutTiming(int timesToLoop, ArrayList<StudentGoodHash> students, ArrayList<Double> gpa, double lambda) {


        if(students.size() != gpa.size()){
            return null;
        }
        int size = gpa.size();
        HashTable<StudentGoodHash,Double> testTable = new HashTable<>();
        testTable.setLambda(lambda);
        long startTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for(int j = 0; j < size; j++){
                testTable.put(students.get(j),gpa.get(j));
            }
            testTable.clear();
        }
        long midPointTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for (int j = 0; j < size; j++){
                students.get(j);
                gpa.get(j);
            }
            testTable.clear();
        }

    
        long endTime = System.nanoTime();
        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
        return new String[] {Long.toString(avg), Integer.toString(testTable.numCollisions())};

    }

    public static String[] mediumHashPutTiming(int timesToLoop, ArrayList<StudentMediumHash> students, ArrayList<Double> gpa, double lambda) {


        if(students.size() != gpa.size()){
            return null;
        }
        int size = gpa.size();
        HashTable<StudentMediumHash,Double> testTable = new HashTable<>();
        testTable.setLambda(lambda);
        long startTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for(int j = 0; j < size; j++){
                testTable.put(students.get(j),gpa.get(j));
            }
            testTable.clear();
        }
        long midPointTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for (int j = 0; j < size; j++){
                students.get(j);
                gpa.get(j);
            }
            testTable.clear();
        }


        long endTime = System.nanoTime();
        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
        return new String[] {Long.toString(avg), Integer.toString(testTable.numCollisions())};

    }

    public static String[] badHashPutTiming(int timesToLoop, ArrayList<StudentBadHash> students, ArrayList<Double> gpa, double lambda) {


        if(students.size() != gpa.size()){
            return null;
        }
        int size = gpa.size();
        HashTable<StudentBadHash,Double> testTable = new HashTable<>();
        testTable.setLambda(lambda);

        long startTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for(int j = 0; j < size; j++){
                testTable.put(students.get(j),gpa.get(j));
            }
            testTable.clear();
        }
        long midPointTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for (int j = 0; j < size; j++){
                students.get(j);
                gpa.get(j);
            }
            testTable.clear();
        }


        long endTime = System.nanoTime();
        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
        return new String[] {Long.toString(avg), Integer.toString(testTable.numCollisions())};

    }


    public static String[] goodHashGetTiming(int timesToLoop, ArrayList<StudentGoodHash> students, ArrayList<Double> gpa, double lambda) {


        if(students.size() != gpa.size()){
            return null;
        }
        int size = gpa.size();
        HashTable<StudentGoodHash,Double> testTable = new HashTable<>();
        testTable.setLambda(lambda);

        for(int k = 0; k < size; k++){
            testTable.put(students.get(k),gpa.get(k));
        }
        long startTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for(int j = 0; j < size; j++){
                testTable.get(students.get(j));
            }
        }
        long midPointTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for (int j = 0; j < size; j++){
                students.get(j);
            }
        }


        long endTime = System.nanoTime();
        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
//        return Long.toString(avg);
        return new String[] {Long.toString(avg), Integer.toString(testTable.numCollisions())};
    }


    public static String[] mediumHashGetTiming(int timesToLoop, ArrayList<StudentMediumHash> students, ArrayList<Double> gpa, double lambda) {


        if(students.size() != gpa.size()){
            return null;
        }
        int size = gpa.size();
        HashTable<StudentMediumHash,Double> testTable = new HashTable<>();
        testTable.setLambda(lambda);

        for(int k = 0; k < size; k++){
            testTable.put(students.get(k),gpa.get(k));
        }
        long startTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for(int j = 0; j < size; j++){
                testTable.get(students.get(j));
            }
        }
        long midPointTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for (int j = 0; j < size; j++){
                students.get(j);
            }
        }


        long endTime = System.nanoTime();
        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
//        return Long.toString(avg);
        return new String[] {Long.toString(avg), Integer.toString(testTable.numCollisions())};

    }
    
    public static String[] badHashGetTiming(int timesToLoop, ArrayList<StudentBadHash> students, ArrayList<Double> gpa, double lambda) {
        

        if(students.size() != gpa.size()){
            return null;
        }
        int size = gpa.size();
        HashTable<StudentBadHash,Double> testTable = new HashTable<>();
        for(int k = 0; k < size; k++){
            testTable.put(students.get(k),gpa.get(k));
        }
        long startTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for(int j = 0; j < size; j++){
                testTable.get(students.get(j));
            }
        }
        long midPointTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for (int j = 0; j < size; j++){
                students.get(j);
            }
        }


        long endTime = System.nanoTime();
        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
        return new String[] {Long.toString(avg), Integer.toString(testTable.numCollisions())};
    }

    public static String ourHashTiming(int timesToLoop, ArrayList<String> strings, ArrayList<Integer> ints) {


        if(strings.size() != ints.size()){
            return null;
        }
        int size = ints.size();
        HashTable<Integer,String> testTable = new HashTable<>();
        testTable.setLambda(1);
        for(int k = 0; k < size; k++){
            testTable.put(ints.get(k),strings.get(k));
        }
        long startTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for(int j = 0; j < size; j++){
                testTable.get(ints.get(j));
            }
        }
        long midPointTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for (int j = 0; j < size; j++){
                ints.get(j);
            }
        }


        long endTime = System.nanoTime();
        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
        return Long.toString(avg);
    }


    public static String javaHashTiming(int timesToLoop, ArrayList<String> strings, ArrayList<Integer> ints) {


        if(strings.size() != ints.size()){
            return null;
        }
        int size = ints.size();
        HashMap<Integer,String> testTable = new HashMap<>();
        for(int k = 0; k < size; k++){
            testTable.put(ints.get(k),strings.get(k));
        }
        long startTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for(int j = 0; j < size; j++){
                testTable.get(ints.get(j));
            }
        }
        long midPointTime = System.nanoTime();
        for (int i = 1; i <= timesToLoop; i++) {
            for (int j = 0; j < size; j++){
                ints.get(j);
            }
        }


        long endTime = System.nanoTime();
        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
        return Long.toString(avg);
    }
    
    public static ArrayList<StudentBadHash> generateBadStudentList(int n){
        ArrayList<StudentBadHash> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String firstName = "a" + Integer.toString(i);
            String lastName = "b" + Integer.toString(i);
            int uid = 1000000 + i;
            list.add(new StudentBadHash(uid,firstName, lastName));
        }
        return list;
    }
    public static ArrayList<StudentMediumHash> generateMediumStudentList(int n){
        ArrayList<StudentMediumHash> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String firstName = "a" + Integer.toString(i);
            String lastName = "b" + Integer.toString(i);
            int uid = 1000000 + i;
            list.add(new StudentMediumHash(uid,firstName, lastName));
        }
        return list;
    }
    public static ArrayList<StudentGoodHash> generateGoodStudentList(int n){
        ArrayList<StudentGoodHash> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String firstName = "a" + Integer.toString(i);
            String lastName = "b" + Integer.toString(i);
            int uid = 1000000 + i;
            list.add(new StudentGoodHash(uid,firstName, lastName));
        }
        return list;
    }
    public static ArrayList<Double> generateGPA(int n){

        ArrayList<Double> list = new ArrayList<>();
        double d = 3;
        for(double i = 0; i < n; i++){
            list.add(d + ((i%10)/10));
        }
        return list;
    }
    public static ArrayList<String> generateStrings(int n){

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(Integer.toString(i));
        }
        return list;
    }
    public static ArrayList<Integer> generateInts(int n){

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        return list;
    }
    




    public static void collectDataFirstExperiment(int n, int increment, int timesToLoop, double lambda){

        System.out.println(seperate);
        System.out.println("Starting First Timing Experiment...");
        System.out.println("Parameters: (n, IncrementOfArray, timesToLoop)");
        System.out.println("(" + Integer.toString(n) + "," + Integer.toString(increment) + Integer.toString(timesToLoop)+")");
        System.out.println("Data: (Items in List (n), BadHashGetTime (ns), BHGet Collisions,  MediumHashGetTime (ns), MHGet Collisions, GoodHashGetTime (ns), GHGet Collisions," +
                " BadHashPutTime (ns), BHPut Collisions,  MediumHashPutTime (ns), MHPut Collisions, GoodHashPutTime (ns), GHPut Collisions)");

        String[] dataPoint = new String[]{"Items in List (n)" ,  "BadHashGetTime (ns)" , "BHGet Collisions"  ,
                "MediumHashGetTime (ns)" , "MHGet Collisions" ,
                "GoodHashGetTime (ns)" , "GHGet Collisions" ,
                "BadHashPutTime (ns)" , "BHPut Collisions"  ,
                "MediumHashPutTime (ns)", "MHPut Collisions" ,
                "GoodHashPutTime (ns)" ,  "GHPut Collisions"};
        
        

        System.out.println(seperate);

        ArrayList<String[]> data = new ArrayList<String[]>();
        data.add(dataPoint);
        System.out.println(seperate);

        System.out.println("Timing Code...");
        System.out.println(seperate);




        for(int i = 0; i <= n; i+= increment){

            
            
            ArrayList<StudentBadHash> badStudents = generateBadStudentList(i);
            ArrayList<StudentMediumHash> mediumStudents = generateMediumStudentList(i);
            ArrayList<StudentGoodHash> goodStudents = generateGoodStudentList(i);
            ArrayList<Double> gpaList = generateGPA(i);
            
            String BHGT = badHashGetTiming(timesToLoop,badStudents,gpaList, lambda)[0];
            String BHGC = badHashGetTiming(timesToLoop,badStudents,gpaList,lambda)[1];
            String MHGT = mediumHashGetTiming(timesToLoop,mediumStudents,gpaList,lambda)[0];
            String MHGC = mediumHashGetTiming(timesToLoop,mediumStudents,gpaList,lambda)[1];
            String GHGT = goodHashGetTiming(timesToLoop,goodStudents,gpaList,lambda)[0];
            String GHGC = goodHashGetTiming(timesToLoop,goodStudents,gpaList,lambda)[1];
            String BHPT = badHashPutTiming(timesToLoop,badStudents,gpaList,lambda)[0];
            String BHPC = badHashPutTiming(timesToLoop,badStudents,gpaList,lambda)[1];
            String MHPT = mediumHashPutTiming(timesToLoop,mediumStudents,gpaList,lambda)[0];
            String MHPC = mediumHashPutTiming(timesToLoop,mediumStudents,gpaList,lambda)[1];
            String GHPT = goodHashPutTiming(timesToLoop,goodStudents,gpaList,lambda)[0];
            String GHPC = goodHashPutTiming(timesToLoop,goodStudents,gpaList,lambda)[1];

            dataPoint = new String[]{Integer.toString(i),BHGT,BHGC,MHGT,MHGC,GHGT,GHGC,BHPT,BHPC,MHPT,MHPC,GHPT,GHPC};
            data.add(dataPoint);
            System.out.println(i);

        }

        System.out.println("Exporting To File...");
        String f =  "FirstExp" + ".csv";
        System.out.println(f);
        Path p = Paths.get(f);
        String file = p.getFileName().toString();
        writeDataAtOnce(file, data);
        System.out.println(seperate);
        System.out.println("Done");
        System.out.println(seperate);

    }



    public static void collectLambda(int n,int maxLambda, double increment, int timesToLoop){

        System.out.println(seperate);
        System.out.println("Starting First Timing Experiment...");
        System.out.println("Parameters: (n, IncrementOfLambda, timesToLoop)");
        System.out.println("(" + Integer.toString(n) + "," + Double.toString(increment) + Integer.toString(timesToLoop)+")");
        System.out.println("Data: ()");

        String[] dataPoint = new String[]{"Lambda", "BadHashGetTime (ns)" , "BHGet Collisions" ,
                "MediumHashGetTime (ns)" , "MHGet Collisions" ,
                "GoodHashGetTime (ns)" , "GHGet Collisions" ,
                "BadHashPutTime (ns)" , "BHPut Collisions"  ,
                "MediumHashPutTime (ns)", "MHPut Collisions" ,
                "GoodHashPutTime (ns)",  "GHPut Collisions"};



        System.out.println(seperate);

        ArrayList<String[]> data = new ArrayList<String[]>();
        data.add(dataPoint);
        System.out.println(seperate);

        System.out.println("Timing Code...");
        System.out.println(seperate);



        for(double i = .25; i <= maxLambda; i+= increment){



            ArrayList<StudentBadHash> badStudents = generateBadStudentList(n);
            ArrayList<StudentMediumHash> mediumStudents = generateMediumStudentList(n);
            ArrayList<StudentGoodHash> goodStudents = generateGoodStudentList(n);
            ArrayList<Double> gpaList = generateGPA(n);

            String BHGT = badHashGetTiming(timesToLoop,badStudents,gpaList, i)[0];
            String BHGC = badHashGetTiming(timesToLoop,badStudents,gpaList,i)[1];
            String MHGT = mediumHashGetTiming(timesToLoop,mediumStudents,gpaList,i)[0];
            String MHGC = mediumHashGetTiming(timesToLoop,mediumStudents,gpaList,i)[1];
            String GHGT = goodHashGetTiming(timesToLoop,goodStudents,gpaList,i)[0];
            String GHGC = goodHashGetTiming(timesToLoop,goodStudents,gpaList,i)[1];
            String BHPT = badHashPutTiming(timesToLoop,badStudents,gpaList,i)[0];
            String BHPC = badHashPutTiming(timesToLoop,badStudents,gpaList,i)[1];
            String MHPT = mediumHashPutTiming(timesToLoop,mediumStudents,gpaList,i)[0];
            String MHPC = mediumHashPutTiming(timesToLoop,mediumStudents,gpaList,i)[1];
            String GHPT = goodHashPutTiming(timesToLoop,goodStudents,gpaList,i)[0];
            String GHPC = goodHashPutTiming(timesToLoop,goodStudents,gpaList,i)[1];

            dataPoint = new String[]{Double.toString(i),BHGT,BHGC,MHGT,MHGC,GHGT,GHGC,BHPT,BHPC,MHPT,MHPC,GHPT,GHPC};
            data.add(dataPoint);

            System.out.println(i);

        }

        System.out.println("Exporting To File...");
        String f =  "Lambda" + ".csv";
        System.out.println(f);
        Path p = Paths.get(f);
        String file = p.getFileName().toString();
        writeDataAtOnce(file, data);
        System.out.println(seperate);
        System.out.println("Done");
        System.out.println(seperate);

    }

    public static void collectJavaVsOursComp(int n, int increment, int timesToLoop){

        System.out.println(seperate);
        System.out.println("Starting First Timing Experiment...");
        System.out.println("Parameters: (n, IncrementOfLambda, timesToLoop)");
        System.out.println("(" + Integer.toString(n) + "," + Double.toString(increment) + Integer.toString(timesToLoop)+")");
        System.out.println("Data: ()");

        String[] dataPoint = new String[]{"n", "Ours" ,"Javas"};



        System.out.println(seperate);

        ArrayList<String[]> data = new ArrayList<String[]>();
        data.add(dataPoint);
        System.out.println(seperate);

        System.out.println("Timing Code...");
        System.out.println(seperate);



        for(int i = 0; i <= n; i+= increment){




            ArrayList<String> strings = generateStrings(i);
            ArrayList<Integer> ints = generateInts(i);
            String Javas = javaHashTiming(timesToLoop,strings,ints);
            String Ours = ourHashTiming(timesToLoop,strings,ints);


            dataPoint = new String[]{Integer.toString(i),Ours,Javas};
            data.add(dataPoint);
            System.out.println(i);


        }

        System.out.println("Exporting To File...");
        String f =  "JavaVsOursComp" + ".csv";
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
        System.out.println("Increment n...");
        int increment = S.nextInt();
        System.out.println("Times to Loop...");
        int timesToLoop = S.nextInt();
        System.out.println("Lambda Increment...");
        double lambdaincrement = S.nextDouble();
        System.out.println("MaxLambda");
        int maxLambda = S.nextInt();

        collectDataFirstExperiment(maxSize,increment,timesToLoop,1);
        collectLambda(maxSize,maxLambda,lambdaincrement,timesToLoop);
        collectJavaVsOursComp(maxSize,increment,timesToLoop);




    }



}
