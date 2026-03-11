import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class UseCase7PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            boolean palindrome = isPalindrome(input);

            System.out.println("UC7: Deque-Based Optimized Palindrome Checker");
            System.out.println("Input: " + input);
            System.out.println("Result: " + (palindrome ? "Palindrome" : "Not a palindrome"));
        }
    }

    private static boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char character : input.toCharArray()) {
            deque.addLast(character);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
