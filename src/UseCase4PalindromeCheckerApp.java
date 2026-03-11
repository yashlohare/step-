import java.util.Scanner;

public class UseCase4PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = ConsoleSupport.readInput(scanner);
            boolean palindrome = PalindromeAlgorithms.isCharArrayPalindrome(input);
            ConsoleSupport.printResult("UC4: Character Array Based Palindrome Check", input, palindrome);
        }
    }
}
