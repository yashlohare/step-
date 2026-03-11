import java.util.Scanner;
import java.util.Stack;

public class UseCase5PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            boolean palindrome = isPalindrome(input);

            System.out.println("UC5: Stack-Based Palindrome Checker");
            System.out.println("Input: " + input);
            System.out.println("Result: " + (palindrome ? "Palindrome" : "Not a palindrome"));
        }
    }

    private static boolean isPalindrome(String input) {
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
}
