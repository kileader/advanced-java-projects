package java112.analyzer;

import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * The purpose of this class is to determine the length distribution of tokens
 * in the input file and display the distribution in a number format and a
 * histogram format.
 * @author Kevin Leader
 */
public class TokenLengthsAnalyzer implements TokenAnalyzer {

    private Map<Integer, Integer> tokenLengths;
    private Properties properties;

    /**
     * Empty constructor
     */
    public TokenLengthsAnalyzer() {

    }

    /**
     * Constructor with one Properties parameter
     * @param properties properties to be used for the output
     */
    public TokenLengthsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        tokenLengths = new HashMap<Integer, Integer>();
    }

    /**
     * This method takes a token and changes the tokenLengths map accordingly.
     * @param token a token
     */
    public void processToken(String token) {

    }

    /**
     * This method returns a map of token lengths and the corresponding number
     * of tokens for each length.
     * @return tokenLengths A map with the length of each token as the key and
     * the number of tokens with the key's length as the value
     */
    public Map<Integer, Integer> getTokenLengths() {
        return tokenLengths;
    }

    /**
     * This method generates a text
     * @param inputFilePath  The command line location of the input file
     */
    public void generateOutputFile(String inputFilePath){
        try (PrintWriter output = new PrintWriter(new BufferedWriter(new
                FileWriter(properties.getProperty("output.directory") +
                properties.getProperty("output.file.token.lengths"))))) {
            for (String token : largestTokens) {
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
