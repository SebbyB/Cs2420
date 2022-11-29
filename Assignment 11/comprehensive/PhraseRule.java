package comprehensive;

import java.util.LinkedList;

public class PhraseRule {


    boolean isTerminal = false;
    boolean isStart = false;
    String value;
    int internalIndex;

    public PhraseRule(String val) {
        value = val;
        if (val.charAt(0) == '<') {
            isTerminal = true;
            int beginning = 1;
            int end = val.length() - 2;
            if (val.equals("<start>")) {
                isStart = true;
                }

            }

        }


        public String getValue(){
        return value;
        }
        public String toString(){
        return "Value: " + value + "\t isTerminal: " + Boolean.toString(isTerminal) + "\t isStart:" + Boolean.toString(isStart);
        }

    }