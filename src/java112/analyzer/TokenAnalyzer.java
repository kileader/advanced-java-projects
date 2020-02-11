package java112.analyzer;

/**
 * This interface is for any class that performs an analysis.
 * @author Kevin Leader
 */
public interface TokenAnalyzer {
    void processToken(String token);
    void generateOutputFile(String inputFilePath, String outputFilePath);
}
