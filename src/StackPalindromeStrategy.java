public final class StackPalindromeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        return PalindromeAlgorithms.isStackPalindrome(input);
    }

    @Override
    public String getName() {
        return "Stack Strategy";
    }
}
