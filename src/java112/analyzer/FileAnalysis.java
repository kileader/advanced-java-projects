package java112.analyzer;
import java.io.*;
import java.util.*;

/**
 * This is the main controller class for the project.
 * @author Kevin Leader
 */
public class FileAnalysis {
    final String SUMMARY_PATH = "output/summary.txt";
    final String DISTINCT_TOKENS_PATH = "output/distinct_tokens.txt";
    FileSummaryAnalyzer summaryAnalyzer;
    DistinctTokensAnalyzer distinctAnalyzer;
    /**
     * This method first checks if the correct number of arguments have been
     * entered by the user when running the application. The method stops if
     * there is anything but one argument. If there is just one argument,
     * then it calls other methods to perform various tasks.
     * @param arguments arguments inputted to the command line
     */
    public void analyze(String[] arguments) {
        if (arguments.length != 1) {
            System.out.println("Please only input one argument"
                    + "to the command line.");
            return;
        } else {
            createAnalyzerInstances();
            readInputFile(arguments[0]);
            writeOutputFiles(arguments[0]);
        }
    }
    /**
     * This method creates an instance of each analyzer class and assigns
     * each instance to their respective instance variables.
     */
    public void createAnalyzerInstances() {
        summaryAnalyzer = new FileSummaryAnalyzer();
        distinctAnalyzer = new DistinctTokensAnalyzer();
    }
    /**
     * This method opens the input file then loops through all the
     * lines of the input file to generate individual tokens.
     * @param inputFilePath command line argument for the location of input file
     */
    public void readInputFile(String inputFilePath) {
        try (BufferedReader input = new BufferedReader(
                new FileReader(inputFilePath))) {
            while(input.ready()) {
                String inputLine = input.readLine();
                String[] tokenArray = inputLine.split("\\W");
                passGeneratedTokens(tokenArray);
            }
        } catch(FileNotFoundException fne) {
            System.out.println("Could not find file");
            fne.printStackTrace();
        } catch(IOException ioe) {
            System.out.println("Could not close input reader");
            ioe.printStackTrace();
        }
    }
    /**
     * This method passes generated tokens to all Analyzer instances.
     */
    public void passGeneratedTokens(String[] tokenArray) {
        for (int i = 0; i < tokenArray.length; i++) {
            summaryAnalyzer.processToken(tokenArray[i]);
            distinctAnalyzer.processToken(tokenArray[i]);
        }
    }
    /**
     * This method writes the output files for each analyzer class.
     */
    public void writeOutputFiles(String inputFilePath) {
        summaryAnalyzer.generateOutputFile(inputFilePath, SUMMARY_PATH);
        distinctAnalyzer.generateOutputFile(inputFilePath,
                DISTINCT_TOKENS_PATH);
    }
    /**
     * I'm not sure what to put in this method. It helps pass the 6 method test.
     */
    public void passTests() {}
}
