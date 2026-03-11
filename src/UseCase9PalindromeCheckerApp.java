import java.util.Scanner;

public class UseCase9PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            boolean palindrome = isPalindrome(input, 0, input.length() - 1);

            System.out.println("UC9: Recursive Palindrome Checker");
            System.out.println("Input: " + input);
            System.out.println("Result: " + (palindrome ? "Palindrome" : "Not a palindrome"));
        }
    }

    private static boolean isPalindrome(String input, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (input.charAt(left) != input.charAt(right)) {
            return false;
        }

        return isPalindrome(input, left + 1, right - 1);
    }
}
