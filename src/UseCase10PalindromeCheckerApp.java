import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = ConsoleSupport.readInput(scanner);
            String normalized = PalindromeAlgorithms.normalizeIgnoringCaseAndSpaces(input);
            boolean palindrome = PalindromeAlgorithms.isCharArrayPalindrome(normalized);
            System.out.println("UC10: Case-Insensitive & Space-Ignored Palindrome");
            System.out.println("Original Input: " + input);
            System.out.println("Normalized Input: " + normalized);
            System.out.println("Result: " + (palindrome ? "Palindrome" : "Not a palindrome"));
        }
    }
}
