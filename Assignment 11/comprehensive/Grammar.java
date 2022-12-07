

package comprehensive;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Grammar {




    private Hashtable<PhraseRule, ArrayList<PhraseRule>> backingTable;
    private ArrayList<PhraseRule> startSentence;
    private ArrayList<PhraseRule> keys;
    private PhraseRule startKey;



    int size = 0;

    public Grammar (String fileName){
        File inputFile = new File(fileName);
        try {
           Scanner in = new Scanner(inputFile);
           scanIn(in);
           setKeys();
//           setBackingTable();
           setStartSentence();
            System.out.println("Grammar Creation Successful!");
        }


        catch (Exception e){
            System.out.println("Grammar Creation Failed...");
            e.printStackTrace();
        }
        finally {
            System.out.println(Integer.toString(size) +"\tDone.");
        }
    }

    private void setStartSentence() {
        startSentence = backingTable.get(startKey);
    }

    public ArrayList<PhraseRule> getRules(PhraseRule rule){

        for(PhraseRule key : keys) {
            if (key.equals(rule)) {

                return backingTable.get(key);
            }
        }
        throw new NoSuchElementException();
    }
    public ArrayList<PhraseRule> getStartSentence(){
    	return startSentence;
    }
//    private void setBackingTable() {
//        Hashtable<PhraseRule, ArrayList<PhraseRule>> newTable = new Hashtable<>();
//        for (PhraseRule key : keys) {
//            if(key.getIsStart()){
//
//                startKey = key;
//
//            }
//            ArrayList<PhraseRule> initList = backingTable.get(key), newList = new ArrayList<PhraseRule>();
//            for (PhraseRule rule : initList) {
//                String phraseString = rule.getValue();
//                for (String string : phraseString.split("((?<=(>)|(?=<))")) {
//                    newList.add(new PhraseRule(string));
//                    size++;
//                }
//            }
//        newTable.put(key,newList);
//        }
//        backingTable = newTable;
//    }



    private void scanIn(Scanner in){
        boolean add = false;
        ArrayList<PhraseRule> RuleList = new ArrayList<PhraseRule>();
        backingTable = new Hashtable<>();
        while (in.hasNext()){


            String open = "{";
            String close = "}";
            String next = in.nextLine();
            if(add){
                if (next.contains(close)) {
                    add = false;
                    PhraseRule key = RuleList.get(0);
                    RuleList.remove(key);
                    if(key.getIsStart()){

                        startKey = key;

                    }
                    ArrayList<PhraseRule> value = new ArrayList<>(RuleList);
                    backingTable.put(key,value);
                    RuleList.clear();
                }
                else{

                    PhraseRule rule = new PhraseRule(next);
                    RuleList.add(rule);
                    }
            }
            if(next.contains(open)){
                add = true;
            }
        }
    }

    private void setKeys(){
    keys = new ArrayList<>(backingTable.keySet());
    }


    public static void main(String[] args){


//        Grammar grammar = new Grammar("Assignment 11/super_simple.g");
        Grammar grammar = new Grammar("Assignment 11/assignment_extension_request.g");

        for (PhraseRule key : grammar.keys){
        System.out.println(key);
        System.out.println("\n");
        System.out.println(grammar.getRules(key));
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("\n");


        }


    }



}