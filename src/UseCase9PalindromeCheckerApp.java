import java.util.Scanner;

public class UseCase9PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = ConsoleSupport.readInput(scanner);
            boolean palindrome = PalindromeAlgorithms.isRecursivePalindrome(input);
            ConsoleSupport.printResult("UC9: Recursive Palindrome Checker", input, palindrome);
        }
    }
}
