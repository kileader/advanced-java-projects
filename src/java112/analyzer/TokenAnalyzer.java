package java112.analyzer;
/**
 * This interface is for any class that performs an analysis.
 * @author Kevin Leader
 */
public interface TokenAnalyzer {
    /**
     * This is the general structure of the methods that will receive
     * and get info from individual tokens.
     * @param token singular word taken from the input file
     */
    void processToken(String token);
    /**
     * This is the general structure of the methods that will generate the
     * output required for the project.
     * @param inputFilePath  the location of the file being read
     * @param outputFilePath the location of the appropriate output file
     */
    void generateOutputFile(String inputFilePath, String outputFilePath);
}
