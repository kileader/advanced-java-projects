public class DistinctTokensAnalyzer implements TokenAnalyzer {
    public DistinctTokensAnalyzer() {

    }
    
    private Set<String> distinctTokens;

    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }
