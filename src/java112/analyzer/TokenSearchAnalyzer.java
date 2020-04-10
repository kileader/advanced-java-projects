package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * The purpose of this class is to determine where search tokens are located
 * in the input file.
 * @author Kevin Leader
 */
public class TokenSearchAnalyzer implements TokenAnalyzer {

    private Map<String, List<Integer>> foundLocations;
    private Properties properties;
    private int currentTokenLocation;

    /**
     * Empty constructor
     */
    public TokenSearchAnalyzer() {

    }

    /**
     * Constructor with one Properties parameter
     * @param properties properties to be used for the output
     */
    public TokenSearchAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        foundLocations = new HashMap<String, List<Integer>>();
    }

    /**
     * This method takes a token and
     * @param token a token
     */
    public void processToken(String token) {
        if (token == null || token.isBlank()) {
            return;
        } else {
            try (InputStream inputStream = this.getClass().getResourceAsStream(
                    properties.getProperty("classpath.search.tokens"));
                 InputStreamReader inputStreamReader =
                         new InputStreamReader(inputStream);
                 BufferedReader searchTokensReader =
                         new BufferedReader(inputStreamReader)) {
                readSearchTokens(searchTokensReader);

            } catch (IOException inputOutputException) {
                inputOutputException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * This method returns a map of found locations.
     * @return Locations where the search tokens are found within the file.
     */
    public Map<String, List<Integer>> getFoundLocations() {
        return foundLocations;
    }

    /**
     * This method reads through the search tokens in a loop.
     * @param input
     */
    public void readSearchTokens(BufferedReader input) {
        while (input.ready()) {
            String inputLine = input.readLine();
            String searchToken =
        }
    }

    /**
     * This method generates a text file with
     * @param inputFilePath  The command line location of the input file
     */
    public void generateOutputFile(String inputFilePath) {
        try (PrintWriter output = new PrintWriter(new BufferedWriter(new
                FileWriter(properties.getProperty("output.directory") +
                properties.getProperty("output.file.search.locations"))))) {

        } catch(FileNotFoundException fne) {
            System.out.println("Could not find file");
            fne.printStackTrace();
        } catch(IOException ioe) {
            System.out.println("Could not close output writer");
            ioe.printStackTrace();
        }
    }
}
