public final class PalindromeContext {
    private final PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        return strategy.isPalindrome(input);
    }

    public String getStrategyName() {
        return strategy.getName();
    }
}
