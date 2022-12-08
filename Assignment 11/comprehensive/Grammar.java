

package comprehensive;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Grammar {


	private int startRule = 0;
    private ArrayList<ArrayList<PhraseRule>> backingArray;
    private int size = 0;

    public Grammar (File inputFile){
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
        }
    }

    public ArrayList<ArrayList<PhraseRule>> getBackingArray(){
    	return backingArray;
    }

    private void setStart(){

        ArrayList<PhraseRule> init = backingArray.get(startRule);
        ArrayList<PhraseRule> start = new ArrayList<>();
        String initString = init.get(1).getValue();
        start.add(new PhraseRule(init.get(0).getValue()));
        for(String string : initString.split("((?<=>)|(?=<))")){
           start.add(new PhraseRule(string));
       }
        
        backingArray.add(0,start);
    }

    private void setBackingArray(Scanner in){
    	int startRuleCounter = 0;
        backingArray = new ArrayList<ArrayList<PhraseRule>>();
        boolean add = false;
        ArrayList<PhraseRule> RuleList = new ArrayList<PhraseRule>();
        int index = 0;
        String open = "{";
        String close = "}";        
        while (in.hasNext()){
            String next = in.nextLine();
            if(add){
                if (next.contains(close)) {
                	startRuleCounter++;
                    add = false;
                    backingArray.add(new ArrayList<PhraseRule>(RuleList));
                    backingArray.get(index).get(0).setInternalIndex(index);
                    RuleList.clear();
                    index++;
                }
                else{
                    PhraseRule rule = new PhraseRule(next);
                    if(rule.getIsStart()) {
                    	startRule = startRuleCounter;
                    }
                    RuleList.add(rule);
                    size++;}
            }
            if(next.contains(open)){
                add = true;
            }
        }
    }
   
//------------Methods Primarily used for testing purposes-------------
//    public String RuleListToString(int index){
//
//        if(index > backingArray.size() - 1){
//            throw new IndexOutOfBoundsException();
//        }
//        ArrayList<PhraseRule> list = backingArray.get(index);
//        StringBuilder retString = new StringBuilder();
//        for (PhraseRule rule : list) {
//            retString.append(" ").append(rule.getValue());
//        }
//        return retString.toString();
//    }
//
//    public String toString(){
//
//        StringBuilder retString = new StringBuilder();
//        for (int i = 0; i < backingArray.size(); i++) {
//            retString.append(RuleListToString(i)).append("\n");
//        }
//        return retString.toString();
//    }

}