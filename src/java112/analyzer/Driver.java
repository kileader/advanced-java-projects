package java112.analyzer;
/**
 * This class instantiates an instance of the project's main processing class.
 * Then it runs an analysis for the given args (the input file path).
 * @author Kevin Leader
 */
public class Driver {
    /**
     * The main method.
     * @param args command line arguments (the input file path)
     */
    public static void main(String[] args) {
        FileAnalysis fa = new FileAnalysis();
        fa.analyze(args);
    }
}
