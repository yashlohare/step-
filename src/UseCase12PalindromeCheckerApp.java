import java.util.Scanner;

public class UseCase12PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = ConsoleSupport.readInput(scanner);

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
}
