public final class DequePalindromeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        return PalindromeAlgorithms.isDequePalindrome(input);
    }

    @Override
    public String getName() {
        return "Deque Strategy";
    }
}
