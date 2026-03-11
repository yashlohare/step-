import java.util.Scanner;

public final class ConsoleSupport {
    private ConsoleSupport() {
    }

    public static String readInput(Scanner scanner) {
        System.out.print("Enter a string: ");
        return scanner.hasNextLine() ? scanner.nextLine() : "";
    }

    public static void printResult(String label, String input, boolean palindrome) {
        System.out.println(label);
        System.out.println("Input: " + input);
        System.out.println("Result: " + (palindrome ? "Palindrome" : "Not a palindrome"));
    }
}
