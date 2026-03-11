import java.util.List;
import java.util.Scanner;

public class UseCase13PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = ConsoleSupport.readInput(scanner);
            List<PerformanceResult> results = PalindromeAlgorithms.benchmarkAll(input);

            System.out.println("UC13: Performance Comparison");
            System.out.println("Input: " + input);
            System.out.printf("%-18s %-15s %s%n", "Algorithm", "Palindrome", "Time (ns)");
            for (PerformanceResult result : results) {
                System.out.printf(
                        "%-18s %-15s %d%n",
                        result.getAlgorithmName(),
                        result.isPalindrome(),
                        result.getElapsedNanos()
                );
            }
        }
    }
}
