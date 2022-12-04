package comprehensive;

import java.io.File;
import java.util.ArrayList;

public class RandomPhraseGenerator {


    Grammar grammarRuleSet;
    String phrase;
    String filePath;
    File file;
    ArrayList<PhraseRule> start;

    public RandomPhraseGenerator(String filePath) {

        this.filePath = filePath;
        this.file = new File(filePath);
        grammarRuleSet = new Grammar(file);
        start = grammarRuleSet.startSentence;
    }

//    public String generateLinearPhrase(){
//
//        StringBuilder builder = new StringBuilder();
//        for(int index = 0; index < start.size(); index++){
//            PhraseRule rule = start.get(index);
//            if(!rule.isTerminal){
//                ArrayList<PhraseRule> ruleSet = grammarRuleSet.getRule(rule);
//                PhraseRule addRule = ruleSet.get(1);
//                builder.append(addRule.value);
//            }else {
//                builder.append(rule.value);
//            }
//        }
//        return builder.toString();
//    }


    public static void main(String[] args){

        RandomPhraseGenerator gen = new RandomPhraseGenerator("Assignment 11/assignment_extension_request.g");
//        gen.generateLinearPhrase();
    }

}