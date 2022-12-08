package comprehensive;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomPhraseGenerator {


    private Grammar grammarRuleSet;
    private String phrase;
    private String filePath;
    private File file;
    private ArrayList<ArrayList<PhraseRule>> backingArray;
    private Random r = new Random();
    private StringBuilder finalPhrase = new StringBuilder();
    private HashMap<String,Integer> whichTerminal = new HashMap<String,Integer>();

    public RandomPhraseGenerator(String filePath) {

        this.filePath = filePath;
        this.file = new File(filePath);
        this.grammarRuleSet = new Grammar(file);
        this.backingArray = grammarRuleSet.getBackingArray();
        for(int i = 1; i < backingArray.size();i++) {
        	whichTerminal.put(backingArray.get(i).get(0).getValue(), i);
        }
        
        
    }

    public String generatePhrase(){

        for(int i = 1; i < backingArray.get(0).size();i++) {
        
        	if(backingArray.get(0).get(i).getIsTerminal()) {
        		finalPhrase.append(backingArray.get(0).get(i).getValue());
        		
        	}
        	else {
        	int whichTerminal  = whichNonTerminal(backingArray.get(0).get(i));
                generatePhraseRecursive(whichTerminal);
        		}
        	
        }
          String endPhrase = finalPhrase.toString();
          this.finalPhrase = new StringBuilder();
          return endPhrase;
        }
    
    private void generatePhraseRecursive(int c) {
    	 
    	  int sizing = (backingArray.get(c).size()-1);
          int pickedPhrase = r.nextInt(sizing)+1;
          PhraseRule addedPhrase = backingArray.get(c).get(pickedPhrase);
          for(String phrase : addedPhrase.getValue().split("((?<=>)|(?=<))")) {
          PhraseRule newPhrase= new PhraseRule(phrase);
          if(newPhrase.getIsTerminal()) {
        	  finalPhrase.append(newPhrase.getValue());
          } else{
        	 generatePhraseRecursive(whichNonTerminal(newPhrase));
    	  }
         
       }
    }
    
    
    private int whichNonTerminal(PhraseRule rule) {
    	return whichTerminal.get(rule.getValue());
    }
    
    public static void main(String[] args){

//        String file = ;
        int n = 10;
    	StringBuilder phraseList = new StringBuilder();
        RandomPhraseGenerator gen = new RandomPhraseGenerator("Assignment 11/comprehensive/generatedGrammar.g");
    	for(int i = 0 ; i < n;i++) {
    	phraseList.append(gen.generatePhrase());
    	phraseList.append("\n");
    	}
    	System.out.print(phraseList.toString());
    }

}
