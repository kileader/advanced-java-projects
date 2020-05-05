package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * This purpose of this class is to create a text file of distinct tokens with
 * counts of how many times each token appears.
 * @author Kevin Leader
 */
public class DistinctTokenCountsAnalyzer implements TokenAnalyzer {

    private Properties properties;
    private Map<String, Integer> distinctTokenCounts;

    /**
     * Empty constructor
     */
    public DistinctTokenCountsAnalyzer() {
    }

    /**
     * Constructor with one Properties parameter
     * @param properties properties to be used for the output
     */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        distinctTokenCounts = new TreeMap<String, Integer>();
    }

    /**
     * This method checks each token for uniqueness and validity, then adds it
     * to the distinctTokenCounts map appropriately
     * @param token a token taken from the distinctTokens set
     */
    public void processToken(String token) {
        if (token == null || token.isBlank()) {
            return;
        } else if (distinctTokenCounts.containsKey(token)) {
            distinctTokenCounts.replace(token,
                    distinctTokenCounts.get(token) + 1);
        } else {
            distinctTokenCounts.put(token, 1);
        }
    }

    /**
     * This method returns a map of distinct tokens and their counts
     * @return map of distinct tokens and their counts
     */
    public Map<String, Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }

    /**
     * This method generates a text document of distinct tokens and their counts
     * @param inputFilePath  The command line location of the input file
     */
    public void generateOutputFile(String inputFilePath) {
        try (PrintWriter output = new PrintWriter(new BufferedWriter(
                new FileWriter(properties.getProperty("output.directory")
                + properties.getProperty("output.file.distinct.counts"))))) {
            for (Map.Entry<String, Integer> entry :
                    distinctTokenCounts.entrySet()) {
        		String k = entry.getKey();
        		Integer v = entry.getValue();
        		output.println(k + "\t" + v);
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
