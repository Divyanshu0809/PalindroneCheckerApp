import java.util.*;

public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word : ");
        String wrd = sc.nextLine();

        // Using Deque
        String temp = "";
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : wrd.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            if (deque.removeLast() != deque.removeFirst()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome)
            System.out.println("Palindrome (using Deque)");
        else
            System.out.println("Not Palindrome (using Deque)");

        // Using LinkedList
        LinkedList<Character> list = new LinkedList<>();

        for (char c : wrd.toCharArray()) {
            list.add(c);
        }

        boolean isPalindromeList = true;

        while (list.size() > 1) {
            if (list.removeFirst() != list.removeLast()) {
                isPalindromeList = false;
                break;
            }
        }

        if (isPalindromeList)
            System.out.println("Word is Palindrome (using LinkedList)");
        else
            System.out.println("Word is not Palindrome (using LinkedList)");

        sc.close();
    }
}