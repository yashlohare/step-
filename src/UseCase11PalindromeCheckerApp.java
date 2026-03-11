import java.util.Scanner;

public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();

        try (Scanner scanner = new Scanner(System.in)) {
            String input = ConsoleSupport.readInput(scanner);
            boolean palindrome = checker.checkPalindrome(input);
            ConsoleSupport.printResult("UC11: Object-Oriented Palindrome Service", input, palindrome);
        }
    }
}
