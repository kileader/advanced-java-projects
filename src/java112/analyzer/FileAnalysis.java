package java112.analyzer;

/**
 * This is the main controller class for the project.
 *
 * @author Kevin Leader
 */
public class FileAnalysis {

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
        if (arguments.lenth != 1) {
            System.out.println("Please only input one argument"
                    + "to the command line.");
            return;
        } else {
            createAnalyzerInstances();

            private String inputFilePath = arguments[0];
            openInputFile(inputFilePath);

        }
    }
    /**
     * This method creates an instance of each analyzer class and assigns
     * each instance to their respective instance variables
     */
    public void createAnalyzerInstances() {
        summaryAnalyzer = new FileSummaryAnalyzer();
        distinctAnalyzer = new DistinctTokensAnalyzer();
    }
    /**
     * TODO NEEDS WORK
     * This method opens the input file then loops through all the
     * lines of the input file to generate individual tokens.
     * @param inputFilePath command line argument for the location of input file
     */
    public String[] openInputFile(String inputFilePath) {
        try (BufferedReader input = new BufferedReader(
                new FileReader(inputFilePath)) {
            while(input.ready()) {
                String inputLine = input.readLine();
                String[] tokenArray = inputLine.split("\\W"));
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
     * TODO EVERYTHING
     * This method passes generated tokens to all Analyzer instances.
     */
    public void processToken(String token) {

    }
    public writeOutputFiles() {
        
    }
}
