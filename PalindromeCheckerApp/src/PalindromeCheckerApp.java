import java.util.*;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PalindromeStrategy strategy = new StackStrategy();

        System.out.println("Enter a word: ");
        String wrd = sc.nextLine();

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy twoPointerStrategy = new TwoPointerStrategy();

        System.out.println("\n--- Performance Comparison ---");

        // Stack Strategy Execution
        long startTimeStack = System.nanoTime();
        boolean res1 = stackStrategy.check(wrd);
        long endTimeStack = System.nanoTime();
        long durationStack = endTimeStack - startTimeStack;

        // Two-Pointer Strategy Execution
        long startTimeTP = System.nanoTime();
        boolean res2 = twoPointerStrategy.check(wrd);
        long endTimeTP = System.nanoTime();
        long durationTP = endTimeTP - startTimeTP;

        System.out.println("1. Stack Strategy       | Result: " + res1 + " | Time: " + durationStack + " ns");
        System.out.println("2. Two-Pointer Strategy | Result: " + res2 + " | Time: " + durationTP + " ns");

        System.out.println("\nPerformance Difference (Stack - TP): " + (durationStack - durationTP) + " ns");

        boolean isPalindrome = strategy.check(wrd);

        System.out.println("Input: " + wrd);
        if (isPalindrome) {
            System.out.println("Result: Word is a Palindrome");
        } else {
            System.out.println("Result: Word is not a Palindrome");
        // Read input once
        String wrd = sc.nextLine();

        // Initialize the service and call the method
        PalindromeService ps = new PalindromeService();
        boolean isPalindrome = ps.checkPalindrome(wrd);

        if (isPalindrome) {
            System.out.println("word is Palindrome");
        } else {
            System.out.println("word is not Palindrome");
        }

        sc.close();
    }
}

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        if (input == null) return false;
        String str = input.toLowerCase().replaceAll("\\s+", "");
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
        if (input == null || input.isEmpty()) return false;

        // Normalize: remove spaces and ignore case
        String cleanedInput = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char c : cleanedInput.toCharArray()) {
            stack.push(c);
        }

        // Pop and compare
        for (char c : cleanedInput.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        if (input == null) return false;
        String str = input.toLowerCase().replaceAll("\\s+", "");

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }

class PalindromeService {
    public boolean checkPalindrome(String input) {
        // Normalize the string (remove spaces and ignore case)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}