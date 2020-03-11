package java112.analyzer;

import java.io.*;
import java.util.*;
import java112.utilities.*;

/**
 * This is the main controller class for the project. It reads a text file
 * does an analysis on the words within the file.
 * @author Kevin Leader
 */
public class FileAnalysis implements PropertiesLoader {

    private List<TokenAnalyzer> analyzers;

    /**
     * This method first checks if the correct number of arguments have been
     * entered by the user when running the application. The method stops if
     * there is anything but two arguments. If there is two arguments,
     * then it calls other methods to perform various tasks.
     * @param arguments arguments inputted to the command line
     */
    public void analyze(String[] arguments) throws Exception {
        if (arguments.length != 2) {
            System.out.println("Please only input two arguments "
                    + "to the command line.");
            return;
        } else {
            try {
                createAnalyzerList(loadProperties(arguments[1]));
            } catch (Exception exception) {
                exception.printStackTrace();
                throw exception;
            }
            openInputFile(arguments[0]);
            writeOutputFiles(arguments[0]);
        }
    }

    /**
     * This method instanciates a list of token analyzers and passes the
     * analyzer properties to each.
     * @param properties These are the properties for the analyzer.
     */
    public void createAnalyzerList(Properties properties) {

        analyzers = new ArrayList<TokenAnalyzer>();

        analyzers.add(new FileSummaryAnalyzer(properties));
        analyzers.add(new DistinctTokensAnalyzer(properties));
        analyzers.add(new LargestTokensAnalyzer(properties));
        analyzers.add(new DistinctTokenCountsAnalyzer(properties));
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
    public void passGeneratedTokens(String[] tokens) {
        for (String token : tokens) {
            for (TokenAnalyzer analyzer : analyzers) {
                analyzer.processToken(token);
            }
        }
    }

    /**
     * This method writes the output files for each analyzer class.
     * @param inputFilePath command line argument for the location of input file
     */
    public void writeOutputFiles(String inputFilePath) {
        for (TokenAnalyzer analyzer : analyzers) {
            analyzer.generateOutputFile(inputFilePath);
        }
    }
}
