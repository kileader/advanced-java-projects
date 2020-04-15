package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * The purpose of this class is to determine where search tokens are located
 * in the input file.
 * @author Kevin Leader
 */
public class TokenLocationSearchAnalyzer implements TokenAnalyzer {

    private Map<String, List<Integer>> foundLocations;
    private Properties properties;
    private int currentTokenLocation;
    private static final int MAX_LINE_LENGTH = 80; // do all upper

    /**
     * Empty constructor
     */
    public TokenLocationSearchAnalyzer() {

    }

    /**
     * Constructor that reads the search tokens starts to construct a map
     * @param properties properties to be used for the output
     */
    public TokenLocationSearchAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        foundLocations = new TreeMap<String, List<Integer>>();
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
     * This method generates a text file with search words and their found
     * locations.
     * @param inputFilePath  The command line location of the input file
     */
    public void generateOutputFile(String inputFilePath) {
        try (PrintWriter output = new PrintWriter(new BufferedWriter(new
                FileWriter(properties.getProperty("output.directory") +
                properties.getProperty("output.file.token.search.locations")))))
        {

            // Define local variables
            Set<Map.Entry<String, List<Integer>>> entries =
                    foundLocations.entrySet(); // Change to set
            int currentLocationIndex = -1; // Set a counter for location
            int currentEntriesIndex = -1; // Set a counter for the set
            int lineLength = 0; // Set a counter for length of output line
            boolean lineStart; // Indicate if it's a new line or not

            // Output for each searchword, the entire text file
            for (Map.Entry<String, List<Integer>> entry : entries) {

                // Count the current index for the searchword
                currentEntriesIndex++;

                // Write the searchword and = then [ on next line
                output.print(entry.getKey() + " =\n[");

                // Record the current line length with the [
                lineLength = 1;

                // Check for cases of last searchword and/or nothing found
                if (entry.getValue().isEmpty() &&
                        (currentEntriesIndex + 1 == entries.size())) {
                    output.print("]");
                } else if (entry.getValue().isEmpty()) {
                    output.print("]\n\n");
                } else { // Display all the location numbers for this searchword

                    // Indicate the start of a new line
                    lineStart = true;

                    // Loop to get each location for the current searchword
                    for (Integer location : entry.getValue()) {

                        // Add the length of the location to the linelength
                        lineLength += String.valueOf(location).length();

                        // Count the index of the current location
                        currentLocationIndex++;

                        // Change to new line if the location will put over 80
                        if (lineLength + 2 > MAX_LINE_LENGTH) {
                            output.print("\n");
                            // Set the linelength to length of location
                            lineLength = String.valueOf(location).length();
                            lineStart = true;
                        } else { // Otherwise, indicate this isn't a new line
                            lineStart = false;
                        }

                        // Add a space and +1 to line length if not new line
                        if (!lineStart && currentLocationIndex != 0) {
                            output.print(" ");
                            lineLength++;
                        }

                        // Output the location number to the file
                        output.print(location);

                        // If this is the last location...
                        if (currentLocationIndex + 1 ==
                                entry.getValue().size()) {

                            output.print("]"); // Add a bracket

                            // If this is not the last searchword...
                            if (currentEntriesIndex + 1 != entries.size()) {
                                output.print("\n\n"); // Add two line breaks
                                currentLocationIndex = -1; // Reset location
                            }

                        } else { // If not the last location...
                            output.print(","); // Add a comma
                            lineLength++; // Add +1 to the line length
                        }
                    }
                    // Reset the line length
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
