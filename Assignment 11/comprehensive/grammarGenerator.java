package comprehensive;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Hashtable;

public class grammarGenerator {



    void generateNonTerminals(int n,ArrayList<String> list){
        for(int i = 0; i < n; i++){
            list.add("<"+Integer.toString(i)+">");
        }
    }
    void generateTerminals(int n,ArrayList<String> list){
        for(int i = 0; i < n; i++){
            list.add(Integer.toString(i));
        }
    }

    void generateGrammar(int sizeN) throws IOException {
        System.out.println("Creating a grammar of size " + Integer.toString(sizeN) +"...");
        Writer writer = new FileWriter(new File("Assignment 11/comprehensive/generatedGrammar.g"));

        ArrayList<String> nonTerminals = new ArrayList<>();
        generateNonTerminals(sizeN,nonTerminals);
        Hashtable<String,ArrayList<String>> hashtable = new Hashtable<>();
        StringBuilder startBuilder = new StringBuilder();
        for (String string : nonTerminals){
            ArrayList<String> terminalList = new ArrayList<>();
            generateTerminals(sizeN,terminalList);
            hashtable.put(string,terminalList);
            startBuilder.append(string);
        }

        for(String string : nonTerminals){
            writer.write("{\n");
            writer.write(string);
            writer.write("\n");
            ArrayList<String> terminalList = hashtable.get(string);
            for(String rule : terminalList){
                writer.write(rule);
                writer.write("\n");
            }
            writer.write("}\n");
        }
        writer.write("{\n");
        writer.write("<start>");
        writer.write("\n");
        writer.write(startBuilder.toString());
        writer.write("\n}\n");
        writer.close();
        System.out.println("Done!");
    }

    public static void main(String[] args) throws IOException {

        grammarGenerator generator = new grammarGenerator();
        try {
            generator.generateGrammar(1000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
