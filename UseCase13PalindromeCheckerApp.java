import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UseCase13PalindromeCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            List<PerformanceResult> results = benchmarkAll(input);

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

    private static List<PerformanceResult> benchmarkAll(String input) {
        List<PerformanceResult> results = new ArrayList<>();
        results.add(measure("Character Array", () -> isCharArrayPalindrome(input)));
        results.add(measure("Stack", () -> isStackPalindrome(input)));
        results.add(measure("Queue + Stack", () -> isQueueStackPalindrome(input)));
        results.add(measure("Deque", () -> isDequePalindrome(input)));
        results.add(measure("Linked List", () -> isLinkedListPalindrome(input)));
        results.add(measure("Recursive", () -> isRecursivePalindrome(input, 0, input.length() - 1)));
        return results;
    }

    private static PerformanceResult measure(String name, BooleanSupplier supplier) {
        long startTime = System.nanoTime();
        boolean palindrome = supplier.getAsBoolean();
        long elapsedTime = System.nanoTime() - startTime;
        return new PerformanceResult(name, palindrome, elapsedTime);
    }

    private static boolean isCharArrayPalindrome(String input) {
        char[] characters = input.toCharArray();
        int left = 0;
        int right = characters.length - 1;

        while (left < right) {
            if (characters[left] != characters[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isStackPalindrome(String input) {
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

    private static boolean isQueueStackPalindrome(String input) {
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

    private static boolean isDequePalindrome(String input) {
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

    private static boolean isLinkedListPalindrome(String input) {
        if (input.length() < 2) {
            return true;
        }

        Node head = buildLinkedList(input);
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.value != secondHalf.value) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private static Node buildLinkedList(String input) {
        Node head = new Node(input.charAt(0));
        Node current = head;

        for (int i = 1; i < input.length(); i++) {
            current.next = new Node(input.charAt(i));
            current = current.next;
        }
        return head;
    }

    private static Node reverse(Node head) {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private static boolean isRecursivePalindrome(String input, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (input.charAt(left) != input.charAt(right)) {
            return false;
        }

        return isRecursivePalindrome(input, left + 1, right - 1);
    }

    private interface BooleanSupplier {
        boolean getAsBoolean();
    }

    private static class PerformanceResult {
        private final String algorithmName;
        private final boolean palindrome;
        private final long elapsedNanos;

        private PerformanceResult(String algorithmName, boolean palindrome, long elapsedNanos) {
            this.algorithmName = algorithmName;
            this.palindrome = palindrome;
            this.elapsedNanos = elapsedNanos;
        }

        private String getAlgorithmName() {
            return algorithmName;
        }

        private boolean isPalindrome() {
            return palindrome;
        }

        private long getElapsedNanos() {
            return elapsedNanos;
        }
    }

    private static class Node {
        private final char value;
        private Node next;

        private Node(char value) {
            this.value = value;
        }
    }
}
