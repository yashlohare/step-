public final class PerformanceResult {
    private final String algorithmName;
    private final boolean palindrome;
    private final long elapsedNanos;

    public PerformanceResult(String algorithmName, boolean palindrome, long elapsedNanos) {
        this.algorithmName = algorithmName;
        this.palindrome = palindrome;
        this.elapsedNanos = elapsedNanos;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public boolean isPalindrome() {
        return palindrome;
    }

    public long getElapsedNanos() {
        return elapsedNanos;
    }
}
