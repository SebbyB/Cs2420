package comprehensive;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class TimingExp {









    static String GrammarPath = "Assignment 11/comprehensive/generatedGrammar.g";
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




    public static String timingWithPhraseGen(int numPhrases, int timesToLoop,RandomPhraseGenerator generator) {



        long startTime;
        long endTime;
        long midPointTime;
            startTime = System.nanoTime();
        for(int i = 1; i <= timesToLoop; i++) {
            for (int j = 1; j <= numPhrases; j++){
                generator.generatePhrase();
            }
        }
        midPointTime = System.nanoTime();
        for(int i = 1; i <= timesToLoop; i++) {

        }
        endTime = System.nanoTime();

        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / numPhrases*timesToLoop;
        return Long.toString(avg);

    }
    public static String timingWithoutPhraseGen(int numPhrases,int timesToLoop,String filePath) {



        long startTime;
        long endTime;
        long midPointTime;
            startTime = System.nanoTime();
            for(int i = 1; i <= timesToLoop; i++) {
                RandomPhraseGenerator generator = new RandomPhraseGenerator(filePath);
               for (int j = 1; j <= numPhrases; j++){
                   generator.generatePhrase();
               }
        }
            midPointTime = System.nanoTime();
            for(int i = 1; i <= timesToLoop; i++) {

            }
        endTime = System.nanoTime();

        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / numPhrases*timesToLoop;
        return Long.toString(avg);

    }
    public static String createGrammar(int timesToLoop,String filePath) {


        long startTime;
        long endTime;
        long midPointTime;



            startTime = System.nanoTime();
            for(int i = 1; i <= timesToLoop; i++) {
                    RandomPhraseGenerator generator = new RandomPhraseGenerator(filePath);
            }
            midPointTime = System.nanoTime();
            for(int i = 1; i <= timesToLoop; i++) {
            }
            endTime = System.nanoTime();

        long avg = ((midPointTime - startTime) - (endTime - midPointTime)) / timesToLoop;
        return Long.toString(avg);

    }


    public static void runExp(int n,int timesToLoop,int increment) throws IOException {

            System.out.println(seperate);
            System.out.println("Running Exp");
            System.out.println(seperate);

            String withGrammar = "withGrammar (ns)";
            String withoutGrammar = "withoutGrammar(ns)";
            String N = "n";
            ArrayList<String[]> data = new ArrayList<>();
//            String[] dataPoint = {peek,comma,bestCaseAdd,comma,worstCaseAdd,comma,bestCaseExtractMax,comma,worstCaseExtractMax};
            String[] dataPoint = {N,withGrammar,withoutGrammar};
//            String[] dataPoint = {N,withGrammar};
            System.out.println(Arrays.toString(dataPoint));
            data.add(dataPoint);

            grammarGenerator gramgen = new grammarGenerator();
            gramgen.generateGrammar(50);
            try{
            for(int size = 1; size <= n; size+= increment){

                N = Integer.toString(size);
                RandomPhraseGenerator generator = new RandomPhraseGenerator(GrammarPath);
                withGrammar = timingWithPhraseGen(size,timesToLoop,generator);
                withoutGrammar = timingWithoutPhraseGen(size,timesToLoop,GrammarPath);

                dataPoint = new String[]{N,withGrammar,withoutGrammar};
//                 dataPoint = new String[] {N,withGrammar};
                data.add(dataPoint);


        }}
            catch (Exception e){
                e.printStackTrace();
            }

            finally{
            CSV_FILE_NAME = "Assignment 11/Assign11Exp1.csv";
            System.out.println("Writing to file: " + CSV_FILE_NAME);
            writeDataAtOnce(CSV_FILE_NAME,data);
            System.out.println(seperate);
            System.out.println("Done");
            System.out.println(seperate);
    }}
    public static void runExp2(int n,int timesToLoop,int increment){

            System.out.println(seperate);
            System.out.println("Running Exp");
            System.out.println(seperate);

            String withGrammar = "withGrammar (ns)";
            String withoutGrammar = "withoutGrammar(ns)";
            String N = "n";
            ArrayList<String[]> data = new ArrayList<>();
//            String[] dataPoint = {peek,comma,bestCaseAdd,comma,worstCaseAdd,comma,bestCaseExtractMax,comma,worstCaseExtractMax};
            String[] dataPoint = {N,withGrammar,withoutGrammar};
            System.out.println(Arrays.toString(dataPoint));
            data.add(dataPoint);


            try{
            for(int size = 1; size <= n; size+= increment){
                grammarGenerator gramgen = new grammarGenerator();
                gramgen.generateGrammar(size);
                N = Integer.toString(size);
                RandomPhraseGenerator generator = new RandomPhraseGenerator(GrammarPath);
                withGrammar = timingWithPhraseGen(n,timesToLoop,generator);
                withoutGrammar = timingWithoutPhraseGen(n,timesToLoop,GrammarPath);

                dataPoint = new String[]{N,withGrammar,withoutGrammar};
                data.add(dataPoint);
        }}
            catch (Exception e){
                e.printStackTrace();
            }

            finally{
            CSV_FILE_NAME = "Assignment 11/Assign11Exp2.csv";
            System.out.println("Writing to file: " + CSV_FILE_NAME);
            writeDataAtOnce(CSV_FILE_NAME,data);
            System.out.println(seperate);
            System.out.println("Done");
            System.out.println(seperate);
    }}


         public static void main(String[] args) throws IOException {
             Scanner S = new Scanner(System.in);
             System.out.println(seperate);
             System.out.println("Start Data Collection with parameters:");
             System.out.println("MaxSize...");
             int maxSize = S.nextInt();
             System.out.println("Increment n...");
             int increment = S.nextInt();
             System.out.println("Times to Loop...");
             int timesToLoop = S.nextInt();
//             System.out.println("numPhrases...");
//             int numPhrases = S.nextInt();
//
             runExp(maxSize,timesToLoop,increment);
//             runExp2(maxSize,timesToLoop,increment);
         }









}
