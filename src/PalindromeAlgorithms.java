import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public final class PalindromeAlgorithms {
    private PalindromeAlgorithms() {
    }

    public static boolean isCharArrayPalindrome(String input) {
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

    public static boolean isStackPalindrome(String input) {
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

    public static boolean isQueueStackPalindrome(String input) {
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

    public static boolean isDequePalindrome(String input) {
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

    public static boolean isLinkedListPalindrome(String input) {
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

        Node reversedSecondHalf = reverse(slow);
        Node firstHalfCursor = head;
        Node secondHalfCursor = reversedSecondHalf;

        while (secondHalfCursor != null) {
            if (firstHalfCursor.value != secondHalfCursor.value) {
                return false;
            }
            firstHalfCursor = firstHalfCursor.next;
            secondHalfCursor = secondHalfCursor.next;
        }
        return true;
    }

    public static boolean isRecursivePalindrome(String input) {
        return isRecursivePalindrome(input.toCharArray(), 0, input.length() - 1);
    }

    public static String normalizeIgnoringCaseAndSpaces(String input) {
        return input.replaceAll("\\s+", "").toLowerCase();
    }

    public static List<PerformanceResult> benchmarkAll(String input) {
        List<PerformanceResult> results = new ArrayList<>();
        results.add(measure("Character Array", () -> isCharArrayPalindrome(input)));
        results.add(measure("Stack", () -> isStackPalindrome(input)));
        results.add(measure("Queue + Stack", () -> isQueueStackPalindrome(input)));
        results.add(measure("Deque", () -> isDequePalindrome(input)));
        results.add(measure("Linked List", () -> isLinkedListPalindrome(input)));
        results.add(measure("Recursive", () -> isRecursivePalindrome(input)));
        return results;
    }

    private static boolean isRecursivePalindrome(char[] characters, int left, int right) {
        if (left >= right) {
            return true;
        }
        return characters[left] == characters[right] && isRecursivePalindrome(characters, left + 1, right - 1);
    }

    private static PerformanceResult measure(String algorithmName, BooleanSupplier supplier) {
        long start = System.nanoTime();
        boolean palindrome = supplier.getAsBoolean();
        long elapsed = System.nanoTime() - start;
        return new PerformanceResult(algorithmName, palindrome, elapsed);
    }

    private static Node buildLinkedList(String input) {
        Node head = new Node(input.charAt(0));
        Node tail = head;

        for (int index = 1; index < input.length(); index++) {
            tail.next = new Node(input.charAt(index));
            tail = tail.next;
        }
        return head;
    }

    private static Node reverse(Node node) {
        Node previous = null;
        Node current = node;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private interface BooleanSupplier {
        boolean getAsBoolean();
    }

    private static final class Node {
        private final char value;
        private Node next;

        private Node(char value) {
            this.value = value;
        }
    }
}
