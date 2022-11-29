package comprehensive;

import org.junit.Rule;

import java.io.File;
import java.util.*;

public class Grammar {



    ArrayList<LinkedList<PhraseRule>> backingArray;
    LinkedList<PhraseRule> startSentence;



    int size = 0;

    public Grammar (File inputFile){

        System.out.println("Creating Grammar from " + inputFile.toString() + "...");
        try {
           Scanner in = new Scanner(inputFile);
           setBackingArray(in);
           setStart();
        }


        catch (Exception e){
            System.out.println("Grammar Creation Failed...");
            e.printStackTrace();
        }
        finally {
            System.out.println(Integer.toString(size) +"\tDone.");
        }

    }

    private void setStart(){

        LinkedList<PhraseRule> init = backingArray.get(0);
        LinkedList<PhraseRule> start = new LinkedList<>();

        String initString = init.get(1).value;
        char[] initArr = initString.toCharArray();
        boolean add = false;
        char open = ' ',  close = '.';
        char next, curr;
        String rule = "";
        for(int i = 0; i < initArr.length - 1; i++){
           curr = initArr[i];
           if(curr == (' ') || curr == '.'){
               rule+="";
            }
        }

        backingArray.set(0,start);
    }

    private void setBackingArray(Scanner in){
        backingArray = new ArrayList<LinkedList<PhraseRule>>();
        boolean add = false;
        LinkedList<PhraseRule> RuleList = new LinkedList<PhraseRule>();
        int index = 0;
        while (in.hasNext()){


            String open = "{";
            String close = "}";
            String next = in.nextLine();
            if(add){
                if (next.contains(close)) {
                    add = false;
                    backingArray.add(new LinkedList<>(RuleList));
                    backingArray.get(index).getFirst().internalIndex = index;
                    RuleList.clear();
                    index++;
                }
                else{
                    RuleList.add(new PhraseRule(next));
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
        LinkedList<PhraseRule> list = backingArray.get(index);
        String retString ="";
        for (PhraseRule rule : list) {
            retString += " " + rule.getValue();
        }
        return retString;
    }

    public String toString(){

        String retString = "";
        for (int i = 0; i < backingArray.size(); i++) {
            retString+= RuleListToString(i) + "\n";
        }
        return retString;
    }

    public static void main(String[] args){
//        Grammar grammar = new Grammar(new File("C:\\Users\\Public\\Documents\\JavaProj\\Assignment 11\\super_simple.g"));
        Grammar grammar = new Grammar(new File("C:\\Users\\Public\\Documents\\JavaProj\\Assignment 11\\assignment_extension_request.g"));
        System.out.println(grammar.toString());
    }


}
