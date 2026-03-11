import java.util.Scanner;

public class UseCase6PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = ConsoleSupport.readInput(scanner);
            boolean palindrome = PalindromeAlgorithms.isQueueStackPalindrome(input);
            ConsoleSupport.printResult("UC6: Queue + Stack Based Palindrome Check", input, palindrome);
        }
    }
}
