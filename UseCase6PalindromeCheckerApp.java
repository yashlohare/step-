import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UseCase6PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            boolean palindrome = isPalindrome(input);

            System.out.println("UC6: Queue + Stack Based Palindrome Check");
            System.out.println("Input: " + input);
            System.out.println("Result: " + (palindrome ? "Palindrome" : "Not a palindrome"));
        }
    }

    private static boolean isPalindrome(String input) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char character : input.toCharArray()) {
            queue.offer(character);
            stack.push(character);
        }

        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }
}
