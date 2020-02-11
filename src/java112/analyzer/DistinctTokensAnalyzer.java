package java112.analyzer;
import java.io.*;
import java.util.*;
import java.text.*;

public class DistinctTokensAnalyzer implements TokenAnalyzer {
    private Set<String> distinctTokens = new HashSet<>();
    public DistinctTokensAnalyzer() {

    }
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }
    @Override
    public void processToken(String token) {
        if (token.isEmpty() || token == null || token == "\\s") {
            return;
        } else {
            distinctTokens.add(token);
        }
    }
    @Override
    public void generateOutputFile(String inputFilePath, String ouputFilePath){
        try (PrintWriter output = new PrintWriter(new BufferedWriter(
                new FileWriter("output/distinct_tokens.txt")))) {
            for (String token : distinctTokens) {
                output.println(token);
            }
        } catch(FileNotFoundException fne) {
            System.out.println("Could not find file");
            fne.printStackTrace();
        } catch(IOException ioe) {
            System.out.println("Could not close output writer");
            ioe.printStackTrace();
        }
    }
}
