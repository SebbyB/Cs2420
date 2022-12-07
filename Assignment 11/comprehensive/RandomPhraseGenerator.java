package comprehensive;

import java.io.File;
import java.util.*;

public class RandomPhraseGenerator {


    Grammar grammarRuleSet;
    String filePath;

    StringBuilder finalPhrase;

    public RandomPhraseGenerator(String filePath) {

        grammarRuleSet = new Grammar(filePath);
        finalPhrase = new StringBuilder();

    }

//    private String solvePhraseRule(PhraseRule rule){
//        StringBuilder intermediatePhrase = new StringBuilder();
//        if(!rule.getIsTerminal()){
//            for (String string : rule.getValue().split("((?<=\s)|(?=[.,:;!?]))")){
//
//                PhraseRule checkRule = new PhraseRule(string);
//                if (checkRule.getIsTerminal()){
//                intermediatePhrase.append(string);
//                }
//                else {
//                    ArrayList<PhraseRule> rules = grammarRuleSet.getRules(checkRule);
//                    return solvePhraseRule(rules.get(new Random().nextInt(rules.size())));
//                }
//            }
//        }
//        else {
//            intermediatePhrase.append(rule.getValue());
//        }
//        return intermediatePhrase.toString();
//    }
    public String generatePhrase() {

        LinkedList<String> stringQueue = new LinkedList<>();
        for (String string : grammarRuleSet.getStartSentence().get(0).getValue().split("((?<=\s)|(?=[!._,@? ]))")){
           stringQueue.push(string);
        }

        while(!stringQueue.isEmpty()){
            PhraseRule checkRule = new PhraseRule(stringQueue.removeLast());
            if(checkRule.getIsTerminal()){
                finalPhrase.append(checkRule.getValue());
            }
            else{
                ArrayList<PhraseRule> rules = grammarRuleSet.getRules(checkRule);
                for(String string : rules.get(new Random().nextInt(rules.size())).getValue().split("((?<=\s)|(?=[!._,@? ]))"))
                        stringQueue.push(string);
            }

        }


return finalPhrase.toString();
    }



//    private void generatePhraseRecursive(int c) {
//
//          int pickedPhrase = r.nextInt(backingArray.get(c).size()-1) + 1;
//          PhraseRule addedPhrase = backingArray.get(c).get(pickedPhrase);
//          for(String phrase : addedPhrase.getValue().split("((?<=>)|(?=<))")) {
//          PhraseRule newPhrase= new PhraseRule(phrase);
//          if(newPhrase.getIsTerminal()) {
//        	  finalPhrase.append(newPhrase.getValue());
//          } else{
//        	 generatePhraseRecursive(whichNonTerminal(newPhrase));
//    	  }
//       }
//    }
//
//
//    private int whichNonTerminal(PhraseRule rule) {
//    	for(int i = 1; i < this.backingArray.get(1).size(); i ++) {
//    		if(backingArray.get(i).get(0).getValue().equals(rule.getValue())){
//    			return i;
//    		}
//    	}
//    		return -1;
//    }


    public static void main(String[] args){


//        int n = Integer.parseInt(args[1]);
        int n = 50;
//        RandomPhraseGenerator gen = new RandomPhraseGenerator("Assignment 11/super_simple.g");
//        for(int i = 0; i < n; i++){
        RandomPhraseGenerator gen1 = new RandomPhraseGenerator("Assignment 11/assignment_extension_request.g");
        for(int i = 0; i < n; i++)
            System.out.println(gen1.generatePhrase());
    }

}
