package comprehensive;

public class PhraseRule {


    boolean isTerminal = true;
    boolean isStart = false;
    String value;
    int internalIndex;


    public PhraseRule(String val){
        new PhraseRule(val, true);
    }

    public PhraseRule(String val,boolean start) {

        if(start){
            isStart = false;
            StringBuilder sb= new StringBuilder(val);
            String pattern = "[^a-zA-Z0-9]";
            for(int i = 0; i < val.length(); i++) {
                if(Character.toString(val.charAt(i)).matches(pattern)) {
                    sb.insert(i, ' ');
                }
            }
            val = sb.toString();
        }
        if (val.charAt(0) == '<') {
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

    public boolean getStartBool(){
        return isStart;
    }
    public String toString(){
        return "Value: " + value + "\t isTerminal: " + Boolean.toString(isTerminal) + "\t isStart:" + Boolean.toString(isStart);
    }

        boolean equals(PhraseRule rule){

            return this.value.equals(rule.value);

        }
    }