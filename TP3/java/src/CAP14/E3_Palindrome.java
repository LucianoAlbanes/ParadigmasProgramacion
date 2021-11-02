package CAP14;

import java.util.Scanner;

public class E3_Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert a string to check: ");
        String input = scanner.next();
        System.out.printf("%s%n", isPalindrome(input) ? "Is Palindrome" : "Isn't Palindrome");
    }
    public static boolean isPalindrome(String s) {
        return s.equals(String.valueOf(new StringBuilder(s).reverse()));
    }
}
