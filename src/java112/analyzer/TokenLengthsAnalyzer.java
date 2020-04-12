package java112.analyzer;

import java.io.*;
import java.util.*;

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
     * Constructor that initiates the properties and tokenLengths hashmap
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
        if (token == null || token.isBlank()) {
            return;
        } else {
            if (tokenLengths.containsKey(token.length())) {
                tokenLengths.replace(token.length(),
                        tokenLengths.get(token.length()) + 1);
            } else {
                tokenLengths.put(token.length(), 1);
            }
        }
    }

    /**
     * This method returns a map of token lengths and the corresponding number
     * of tokens for each length.
     * @return A map with the length of each token as the key and
     * the number of tokens with the key's length as the value
     */
    public Map<Integer, Integer> getTokenLengths() {
        return tokenLengths;
    }

    /**
     * This method generates a text file with token lengths and corresponding
     * number of tokens at that length in two formats: integer and histogram.
     * @param inputFilePath  The command line location of the input file
     */
    public void generateOutputFile(String inputFilePath) {
        try (PrintWriter output = new PrintWriter(new BufferedWriter(new
                FileWriter(properties.getProperty("output.directory") +
                properties.getProperty("output.file.token.lengths"))))) {

            // Defining local variables
            Set<Map.Entry<Integer, Integer>> entries = tokenLengths.entrySet();
            int largestValue = 0;
            String star = "*";
            int numberOfStars = 0;

            // Outputting numbers graph and finding the largest token length
            for (Map.Entry<Integer, Integer> entry : entries) {
                output.println(entry.getKey() + "\t" + entry.getValue());
                if (entry.getValue() > largestValue) {
                    largestValue = entry.getValue();
                }
            }

            // Outputting the histogram
            for (Map.Entry<Integer, Integer> entry : entries) {
                numberOfStars = (int) Math.round(((double) entry.getValue() /
                        (double) largestValue) * 76);
                if (numberOfStars == 0) {
                    output.println(entry.getKey() + "\t" + "*");
                } else {
                    output.println(entry.getKey() + "\t"
                            + star.repeat(numberOfStars));
                }
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
