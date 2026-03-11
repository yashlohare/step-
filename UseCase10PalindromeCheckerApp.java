import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            String normalized = input.replaceAll("\\s+", "").toLowerCase();
            boolean palindrome = isPalindrome(normalized);

            System.out.println("UC10: Case-Insensitive & Space-Ignored Palindrome");
            System.out.println("Original Input: " + input);
            System.out.println("Normalized Input: " + normalized);
            System.out.println("Result: " + (palindrome ? "Palindrome" : "Not a palindrome"));
        }
    }

    private static boolean isPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
