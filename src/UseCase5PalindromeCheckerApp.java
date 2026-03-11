import java.util.Scanner;

public class UseCase5PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = ConsoleSupport.readInput(scanner);
            boolean palindrome = PalindromeAlgorithms.isStackPalindrome(input);
            ConsoleSupport.printResult("UC5: Stack-Based Palindrome Checker", input, palindrome);
        }
    }
}
