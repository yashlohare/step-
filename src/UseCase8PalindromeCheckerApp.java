import java.util.Scanner;

public class UseCase8PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = ConsoleSupport.readInput(scanner);
            boolean palindrome = PalindromeAlgorithms.isLinkedListPalindrome(input);
            ConsoleSupport.printResult("UC8: Linked List Based Palindrome Checker", input, palindrome);
        }
    }
}
