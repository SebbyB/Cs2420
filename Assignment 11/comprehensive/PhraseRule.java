package comprehensive;

import java.util.ArrayList;

public class PhraseRule {


    private boolean isTerminal = true;
    private boolean isStart = false;
    private String value;





    public PhraseRule(String val) {
        if (val.contains("<")) {
            isTerminal = false;
            if (val.equals("<start>")) {
                isStart = true;
            }
        }
            value = val;
    }



    public String getValue(){
        return value;
    }


    public String toString(){
        return "Value: " + value + "\t isTerminal: " + Boolean.toString(isTerminal) + "\t isStart:" + Boolean.toString(isStart);
    }
    
    public boolean getIsTerminal() {
    	return isTerminal;
    }
    public boolean getIsStart(){
        return isStart;
    }
    public boolean equals(PhraseRule rule){
            return this.value.equals(rule.value);
        }
    }