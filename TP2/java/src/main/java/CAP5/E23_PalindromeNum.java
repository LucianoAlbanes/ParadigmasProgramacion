package CAP5;

/*
A positive integer is a palindrome if its value is the same after re-
versing the order of the digits in the number. For example, 12321 is a palindrome, but 12563 is not.
Write a method that determines whether a number is a palindrome. Use this method in an application
that determines whether a number entered by the user is a palindrome or not and prints the
result to the console.
*/

import java.util.Scanner;

public class E23_PalindromeNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read user input int
        System.out.print("Insert an integer to check: ");
        long userInt = input.nextLong();

        // Check and print result
        if (isPalindrome(userInt)) {
            System.out.printf("Is palindrome.%n");
        } else {
            System.out.printf("Isn't palindrome.%n");
        }
    }

    public static boolean isPalindrome(long n) {
        String numAsString = Long.toString(n);
        long halfSize = (long) Math.floor(numAsString.length() / 2);

        // Is palindrome until proven otherwise
        boolean isPalindromeFlag = true;
        for (int i = 0; i < halfSize; i++) {
            if (numAsString.charAt(i) != numAsString.charAt(numAsString.length() - i - 1)) {
                isPalindromeFlag = false;
                break;
            }
        }
        return isPalindromeFlag;
    }
}
