package java112.analyzer;
import java.io.*;
import java.util.*;
import java.text.*;

/**
 * This purpose of this class is to check for valid tokens, and then add them
 * to a SortedSet to check for and output distinct values.
 * @author Kevin Leader
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {
    private SortedSet<String> distinctTokens = new TreeSet<>();
    /**
     * This is the constructor method.
     */
    public DistinctTokensAnalyzer() {}
    /**
     * This method returns the distinctTokens sorted set.
     * @return the sorted set of strings consisting of distinct tokens
     */
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }
    /**
     * This method checks for valid tokens, then adds valid tokens to the
     * distinctTokens SortedSet.
     * @param token a token taken from readInputFile method of FileAnalysis
     */
    @Override
    public void processToken(String token) {
        if (token == null || token.isBlank()) {
            return;
        } else {
            distinctTokens.add(token);
        }
    }
    /**
     * This method generates a text document of distinct tokens.
     * @param inputFilePath  The command line location of the input file
     * @param outputFilePath The location the distinct tokens output file
     */
    @Override
    public void generateOutputFile(String inputFilePath,
            String outputFilePath){
        try (PrintWriter output = new PrintWriter(new BufferedWriter(
                new FileWriter(outputFilePath)))) {
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
