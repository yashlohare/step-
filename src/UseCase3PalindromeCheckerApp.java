import java.util.Scanner;

public class UseCase3PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Palindrome Checker App - UC3");
            System.out.print("Enter a string: ");
            String original = scanner.nextLine();

            String reversed = reverse(original);

            System.out.println("Original String: " + original);
            System.out.println("Reversed String: " + reversed);
            System.out.println(
                    "Result: " + (original.equals(reversed)
                            ? "The given string is a palindrome."
                            : "The given string is not a palindrome.")
            );
        }
    }

    private static String reverse(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }
        return reversed;
    }
}
