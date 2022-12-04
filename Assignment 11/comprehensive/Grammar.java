package comprehensive;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Grammar {



    ArrayList<ArrayList<PhraseRule>> backingArray;
    ArrayList<PhraseRule> startSentence;
    ArrayList<PhraseRule> ruleSet;


    int size = 0;

    public Grammar (File inputFile){

        System.out.println("Creating Grammar from " + inputFile.toString() + "...");
        try {
           Scanner in = new Scanner(inputFile);
           setBackingArray(in);
           setStart();
//           setIndex();
           setRuleSet();

            System.out.println("");
        }


        catch (Exception e){
            System.out.println("Grammar Creation Failed...");
            e.printStackTrace();
        }
        finally {
            System.out.println(Integer.toString(size) +"\tDone.");
        }

    }

    private void setRuleSet(){
        ruleSet = new ArrayList<>();
        for (int i = 1; i < backingArray.size(); i++){
            PhraseRule rule = backingArray.get(i).get(0);
            rule.internalIndex = i;
            ruleSet.add(rule);

        }
    }
//    private void setIndex(){
//        for(int i = 0; i < backingArray.size(); i++){
//            backingArray.get(i).get(0).internalIndex = i;
//        }
//    }

    private boolean hasRule(PhraseRule rule){
        for(PhraseRule set : ruleSet){
            if(set.equals(rule)){
                rule.internalIndex = set.internalIndex;
                return true;
            }
        }
        return false;
    }
    public ArrayList<PhraseRule> getRules(PhraseRule rule){
        if(hasRule(rule)){
//            PhraseRule compRule = ruleSet.get(ruleSet.indexOf(rule));

        ArrayList<PhraseRule> rules = backingArray.get(rule.internalIndex);
        rules.remove(rule);
        return rules;}
        else {
            throw new NoSuchElementException();
        }
    }
    private void setStart(){

        ArrayList<PhraseRule> init = backingArray.get(0);
        ArrayList<PhraseRule> start = new ArrayList<>();

        String initString = init.get(1).value;
        boolean add = false;
        String open = " ";
        StringBuilder rule = new StringBuilder();
        for(String string : initString.split(open)){
           start.add(new PhraseRule(string));
       }
        backingArray.set(0,start);
        startSentence = start;
    }

    private void setBackingArray(Scanner in){
        boolean isStart = false;
        backingArray = new ArrayList<ArrayList<PhraseRule>>();
        boolean add = false;
        ArrayList<PhraseRule> RuleList = new ArrayList<PhraseRule>();
        int index = 0;
        while (in.hasNext()){


            String open = "{";
            String close = "}";
            String next = in.nextLine();
            if(add){
                if (next.contains(close)) {
                    add = false;
                    backingArray.add(new ArrayList<>(RuleList));
                    backingArray.get(index).get(0).internalIndex = index;
                    RuleList.clear();
                    index++;
                }
                else{

                    PhraseRule rule = new PhraseRule(next,isStart);
                    RuleList.add(rule);
                    isStart = rule.getStartBool();
                    size++;}
            }
            if(next.contains(open)){
                add = true;
            }
        }
    }



    public String RuleListToString(int index){

        if(index > backingArray.size() - 1){
            throw new IndexOutOfBoundsException();
        }
        ArrayList<PhraseRule> list = backingArray.get(index);
        StringBuilder retString = new StringBuilder();
        for (PhraseRule rule : list) {
            retString.append(" ").append(rule.getValue());
        }
        return retString.toString();
    }



    public String toString(){

        StringBuilder retString = new StringBuilder();
        for (int i = 0; i < backingArray.size(); i++) {
            retString.append(RuleListToString(i)).append("\n");
        }
        return retString.toString();
    }

    public static void main(String[] args){
//        Grammar grammar = new Grammar(new File("C:\\Users\\Public\\Documents\\JavaProj\\Assignment 11\\super_simple.g"));
        Grammar grammar = new Grammar(new File("Assignment 11/assignment_extension_request.g"));
        System.out.println(grammar.toString());
        System.out.println(grammar.getRules(new PhraseRule("<plea>")));
//        for(int i = 0; i < grammar.backingArray.size(); i++){
//            System.out.println(RuleListToString(i));
//        }

    }


}
