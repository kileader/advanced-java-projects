package java112.analyzer;
import java.io.*;
import java.util.*;
import java.text.*;
import java.net.URI;
/**
 * The purpose of this class is to count each non-empty non-null token,
 * and then generate a file summary to output.
 * @author Kevin Leader
 */
public class FileSummaryAnalyzer implements TokenAnalyzer {
    private int totalTokensCount;
    private Properties properties;
    /**
     * Empty constructor
     */
    public FileSummaryAnalyzer() {

    }
    /**
     * Constructor with one Properties parameter
     * @param properties properties to be used for the output
     */
    public FileSummaryAnalyzer(Properties inProperties) {
        properties = inProperties;
    }
    /**
     * This method returns totalTokensCount.
     * @return returns the totalTokensCount
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }
    /**
     * This method counts each word token by adding 1 to totalTokensCount.
     * @param token a token
     */
    @Override
    public void processToken(String token) {
        if (token == null || token.isBlank()) {
            return;
        } else {
            totalTokensCount++;
        }
    }
    /**
     * This method writes the entire summary.txt text file by getting various
     * data from the input file.
     * @param inputFilePath this is the file to be read and analyzed
     */
    @Override
    public void generateOutputFile(String inputFilePath) {
        SimpleDateFormat sdf = new SimpleDateFormat(
                "EEE MMM dd HH:mm:ss z yyyy");
        Date date = new Date();
        File file = new File(inputFilePath);
        String path = file.getAbsolutePath();
        URI fileUri = file.toURI();
        try (PrintWriter output = new PrintWriter(new BufferedWriter(
                new FileWriter(properties.getProperty("output.directory")
                + properties.getProperty("output.file.summary"))))) {
            output.println("Application: "
                    + properties.getProperty("application.name"));
            output.println("Author: " + properties.getProperty("author"));
            output.println("Author Email: "
                    + properties.getProperty("author.email.address"));
            output.println("File: " + path);
            output.println("Date of Analysis: " + sdf.format(date));
            output.println("Last Modified: "
                    + sdf.format(file.lastModified()));
            output.println("File Size: " + file.length());
            output.println("File URI: " + fileUri);
            output.println("Total Tokens: " + getTotalTokensCount());
        } catch(FileNotFoundException fne) {
            System.out.println("Could not find file");
            fne.printStackTrace();
        } catch(IOException ioe) {
            System.out.println("Could not close output writer");
            ioe.printStackTrace();
        }
    }
}
