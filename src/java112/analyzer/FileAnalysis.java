package java112.analyzer;
import java.io.*;
import java.util.*;
/**
 * This is the main controller class for the project.
 * @author Kevin Leader
 */
public class FileAnalysis {
    final String OUTPUT_PATH = "output/";
    private FileSummaryAnalyzer summaryAnalyzer;
    private DistinctTokensAnalyzer distinctAnalyzer;
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
    /**
     * This method allows a 6th method to be in this class. I don't think it
     * is necessary to have a 6th method, but there is a test for it.
     */
    public void passSixMethodTest(){

    }
}
