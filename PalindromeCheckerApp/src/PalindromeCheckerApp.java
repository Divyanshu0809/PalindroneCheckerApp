import java.util.*;

public class PalindromeCheckerApp {
    private static boolean check(String s, int start, int end) {
        if (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            else
                return check(s, start + 1, end - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word: ");

        String input = sc.nextLine();
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome = check(normalized, 0, normalized.length() - 1);

        if (isPalindrome)
            System.out.println("The word is a Palindrome");
        else
            System.out.println("The word is not a Palindrome");

        sc.close();
    }
}