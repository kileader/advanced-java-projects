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
    private final int maxLineLength = 80;

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
        try (InputStream inputStream = this.getClass().getResourceAsStream(
                properties.getProperty("classpath.search.tokens"));
                InputStreamReader inputStreamReader = new
                        InputStreamReader(inputStream);
                BufferedReader input = new BufferedReader(inputStreamReader)) {
            while (input.ready()) {
                String inputLine = input.readLine();
                if (inputLine == null || inputLine.isBlank()) {
                    // Do nothing if it's null or blank
                } else {
                    foundLocations.put(inputLine.trim(), new ArrayList<>());
                }
            }
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * This method takes a token and checks if it is a search token. If it is,
     * it records the location in foundLocations.
     * @param token a token
     */
    public void processToken(String token) {
        if (token == null || token.isBlank()) {
            return;
        } else {
            currentTokenLocation++;
            if (foundLocations.containsKey(token)) {
                List<Integer> list = new ArrayList<>();
                list = foundLocations.get(token);
                list.add(currentTokenLocation);
                foundLocations.put(token, list);
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
     * This method generates a text file with
     * @param inputFilePath  The command line location of the input file
     */
    public void generateOutputFile(String inputFilePath) {
        try (PrintWriter output = new PrintWriter(new BufferedWriter(new
                FileWriter(properties.getProperty("output.directory") +
                properties.getProperty("output.file.search.locations"))))) {

            // Defining local variables
            Set<Map.Entry<String, List<Integer>>> entries =
                    foundLocations.entrySet();
            int currentLocationIndex = 0;
            int currentEntriesIndex = 0;
            int lineLength = 0;

            // Outputting formatted text file
            for (Map.Entry<String, List<Integer>> entry : entries) {
                currentEntriesIndex++;
                output.print(entry.getKey() + " =\n[");
                lineLength = 1;
                if (entry.getValue().isEmpty()) {
                    output.print("]\n\n");
                } else {
                    boolean lineStart = true;
                    for (Integer location : entry.getValue()) {
                        lineLength += String.valueOf(location).length();
                        currentLocationIndex++;
                        if (lineLength + 2 > 80) {
                            output.print("\n");
                            lineLength = String.valueOf(location).length();
                            lineStart = true;
                        } else {
                            lineStart = false;
                        }
                        if (!lineStart && currentLocationIndex != 1) {
                            output.print(" ");
                            lineLength++;
                        }
                        if (currentLocationIndex == entry.getValue().size()) {
                            if (currentEntriesIndex == entries.size()) {
                                output.print(location + "]");
                            } else {
                                output.print(location + "]\n\n");
                                currentLocationIndex = 0;
                            }
                        } else {
                            output.print(location + ",");
                            lineLength++;
                        }
                    }
                    lineLength = 0;
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
