package comprehensive;


public class PhraseRule {


    private boolean isTerminal = true;
    private boolean isStart = false;
    private String value;
    private int internalIndex;

    public PhraseRule(String val) {
        if (val.charAt(0) == '<') {
            isTerminal = false;
            if (val.equals("<start>")) {
                isStart = true;
            }
        }
            value = val;
    }


    public void setIsTerminalFalse(){
        this.isTerminal = false;
    }
    public String getValue(){
        return value;
    }
    public void setInternalIndex(int i) {
    	this.internalIndex = i;
    }

    public boolean getIsTerminal() {
    	return isTerminal;
    }
    
    public boolean getIsStart() {
    	return isStart;
    } 
    public boolean equals(PhraseRule rule){
            return this.value.equals(rule.value);

        }
    }