import java.util.Scanner;

public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            boolean palindrome = checker.checkPalindrome(input);

            System.out.println("UC11: Object-Oriented Palindrome Service");
            System.out.println("Input: " + input);
            System.out.println("Result: " + (palindrome ? "Palindrome" : "Not a palindrome"));
        }
    }

    private static class PalindromeChecker {
        private boolean checkPalindrome(String input) {
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
}
