package java112.analyzer;
import java.io.*;
import java.util.*;
import java.text.*;

/**
 * The purpose of this class is to count each non-empty non-null token,
 * and then generate a file summary to output.
 */
public class FileSummaryAnalyzer implements TokenAnalyzer {
    private int totalTokensCount;
    /**
     * This method sets the initial value of totalTokensCount to 0.
     */
    public FileSummaryAnalyzer() {
        totalTokensCount = 0;
    }
    /**
     * This method returns totalTokensCount.
     * @return returns the totatlTokensCount
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }
    /**
     * This method counts each word token by adding 1 to totalTokensCount.
     * @param token a token
     */
    public void processToken(String token) {
        if (token.isEmpty() || token == null || token == "\\s") {
            return;
        } else {
            totalTokensCount++;
        }
    }
    /**
     * This method writes the entire summary.txt text file by getting various
     * data from the input file.
     * @param inputFilePath this is the file to be read and analyzed
     * @param ouputFilePath this is the text file location to be saved to
     */
    public void generateOutputFile(String inputFilePath, String ouputFilePath) {
        SimpleDateFormat sdf = new SimpleDateFormat(
                "EEE MMM dd HH:mm:ss z yyyy");
        Date date = new Date();
        File file = new File(inputFilePath);
        try (PrintWriter output = new PrintWriter(new BufferedWriter(
                new FileWriter(outputFilePath)))) {
            output.println("Application: Token Checker Deluxe");
            output.println("Author: Kevin Leader");
            output.println("Author Email: kleader@madisoncollege.edu");
            output.println("File: " + inputFilePath);
            output.println("Date of Analysis: " + sdf.format(date)));
            output.println("Last Modified: "
                    + sdf.format(inputFilePath.lastModified()));
            output.println("File Size: " + file.length();
            output.println("File URI: " + inputFilePath);
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
