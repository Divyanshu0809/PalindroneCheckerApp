import java.util.*;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word: ");

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