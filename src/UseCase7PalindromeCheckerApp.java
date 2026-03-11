import java.util.Scanner;

public class UseCase7PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = ConsoleSupport.readInput(scanner);
            boolean palindrome = PalindromeAlgorithms.isDequePalindrome(input);
            ConsoleSupport.printResult("UC7: Deque-Based Optimized Palindrome Checker", input, palindrome);
        }
    }
}
