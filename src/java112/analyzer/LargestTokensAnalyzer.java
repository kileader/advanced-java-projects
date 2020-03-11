package java112.analyzer;

import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * The purpose of this class is to find tokens larger than the specified minimum
 * length and add them to a set
 * @author Kevin Leader
 */
public class LargestTokensAnalyzer implements TokenAnalyzer {

    private Properties properties;
    private Set<String> largestTokens;
    private int minimumTokenLength;

    /**
     * Empty constructor
     */
    public LargestTokensAnalyzer() {

    }

    /**
     * Constructor with one Properties parameter
     * @param properties properties to be used for the output
     */
    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        minimumTokenLength = Integer.parseInt(properties.getProperty(
                "largest.words.minimum.length"));
    }

    /**
     * This method checks each token to see if it is longer than minimum length,
     * then adds valid tokens to the largestTokens string set.
     * @param token a token
     */
    public void processToken(String token) {
        if (token.length() >= minimumTokenLength) {
            largestTokens.add(token);
        }
    }

    /**
     * This method returns the largestTokens string set.
     * @return string set of tokens larger than largest.words.minimum.length
     */
    public Set<String> getLargestTokens() {
        return largestTokens;
    }

    /**
     * This method generates a text document of the largest distinct tokens.
     * @param inputFilePath  The command line location of the input file
     */
    public void generateOutputFile(String inputFilePath){
        try (PrintWriter output = new PrintWriter(new BufferedWriter(
                new FileWriter(properties.getProperty("output.directory")
                + properties.getProperty("output.file.largest.words"))))) {
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
