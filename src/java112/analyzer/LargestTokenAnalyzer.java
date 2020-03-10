package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * The purpose of this class is to find tokens larger than the specified minimum
 * length and add them to a set
 * @author Kevin Leader
 */
public class LargestTokenAnalyzer implements TokenAnalyzer {

    private Properties properties;
    private Set<String> largestTokens;
    private int minimumTokenLength;

    /**
     * Empty constructor
     */
    public LargestTokenAnalyzer() {

    }

    /**
     * Constructor with one Properties parameter
     * @param properties properties to be used for the output
     */
    public LargestTokenAnalyzer(Properties inProperties) {
        properties = inProperties;
        minimumTokenLength = properties.getProperty(
                "largest.words.minimum.length");
    }

    /**
     * This method checks each token to see if it is longer than minimum length,
     * then adds valid tokens to the largestTokens string set.
     * @param token a token
     */
    @Override
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

}
