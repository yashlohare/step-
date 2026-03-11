import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class UseCase12PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            PalindromeContext stackContext = new PalindromeContext(new StackPalindromeStrategy());
            PalindromeContext dequeContext = new PalindromeContext(new DequePalindromeStrategy());

            printStrategyResult(stackContext, input);
            printStrategyResult(dequeContext, input);
        }
    }

    private static void printStrategyResult(PalindromeContext context, String input) {
        boolean palindrome = context.checkPalindrome(input);
        System.out.println("UC12: Strategy Pattern for Palindrome Algorithms");
        System.out.println("Strategy: " + context.getStrategyName());
        System.out.println("Input: " + input);
        System.out.println("Result: " + (palindrome ? "Palindrome" : "Not a palindrome"));
        System.out.println();
    }

    private interface PalindromeStrategy {
        boolean isPalindrome(String input);

        String getName();
    }

    private static class StackPalindromeStrategy implements PalindromeStrategy {
        @Override
        public boolean isPalindrome(String input) {
            Stack<Character> stack = new Stack<>();

            for (char character : input.toCharArray()) {
                stack.push(character);
            }

            for (char character : input.toCharArray()) {
                if (character != stack.pop()) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public String getName() {
            return "Stack Strategy";
        }
    }

    private static class DequePalindromeStrategy implements PalindromeStrategy {
        @Override
        public boolean isPalindrome(String input) {
            Deque<Character> deque = new ArrayDeque<>();

            for (char character : input.toCharArray()) {
                deque.addLast(character);
            }

            while (deque.size() > 1) {
                if (!deque.removeFirst().equals(deque.removeLast())) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public String getName() {
            return "Deque Strategy";
        }
    }

    private static class PalindromeContext {
        private final PalindromeStrategy strategy;

        private PalindromeContext(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        private boolean checkPalindrome(String input) {
            return strategy.isPalindrome(input);
        }

        private String getStrategyName() {
            return strategy.getName();
        }
    }
}
