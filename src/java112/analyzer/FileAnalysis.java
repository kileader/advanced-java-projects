package java112.analyzer;

import java.io.*;
import java.util.*;
/**
 * This is the main controller class for the project.
 * @author Kevin Leader
 */
public class FileAnalysis {
    private static final String OUTPUT_PATH = "output/";
    private List tokenAnalyzerList;
    /**
     * This method first checks if the correct number of arguments have been
     * entered by the user when running the application. The method stops if
     * there is anything but two arguments. If there is two arguments,
     * then it calls other methods to perform various tasks.
     * @param arguments arguments inputted to the command line
     */
    public void analyze(String[] arguments) {
        if (arguments.length != 2) {
            System.out.println("Please only input two arguments"
                    + "to the command line.");
            return;
        } else {
            createAnalyzerInstances();
            openInputFile(arguments[0]);
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
     * lines of the input file.
     * @param inputFilePath command line argument for the location of input file
     */
    public void openInputFile(String inputFilePath) {
        try (BufferedReader input = new BufferedReader(
                new FileReader(inputFilePath))) {
            while(input.ready()) {
                String inputLine = input.readLine();
                formTokenArray(inputLine);
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
     * This method takes the line from the reader and forms an array of tokens.
     * @param inputLine a string for a line from the input file
     */
    public void formTokenArray(String inputLine){
        String[] tokenArray = inputLine.split("\\W");
        passGeneratedTokens(tokenArray);
    }
    /**
     * This method passes generated tokens to all Analyzer instances.
     * @param tokenArray a line of tokens from the input file
     */
    public void passGeneratedTokens(String[] tokenArray) {
        for (int i = 0; i < tokenArray.length; i++) {
            summaryAnalyzer.processToken(tokenArray[i]);
            distinctAnalyzer.processToken(tokenArray[i]);
        }
    }
    /**
     * This method writes the output files for each analyzer class.
     * @param inputFilePath command line argument for the location of input file
     */
    public void writeOutputFiles(String inputFilePath) {
        summaryAnalyzer.generateOutputFile(inputFilePath, OUTPUT_PATH
                + "summary.txt");
        distinctAnalyzer.generateOutputFile(inputFilePath, OUTPUT_PATH
                + "distinct_tokens.txt");
    }
}
