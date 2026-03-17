import java.util.*;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PalindromeStrategy strategy = new StackStrategy();

        System.out.println("Enter a word: ");
        String wrd = sc.nextLine();

        boolean isPalindrome = strategy.check(wrd);

        System.out.println("Input: " + wrd);
        if (isPalindrome) {
            System.out.println("Result: Word is a Palindrome");
        } else {
            System.out.println("Result: Word is not a Palindrome");
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