package CAP5;

/*
 A positive integer is prime if it’s divisible by only 1 and itself.
 For example, 2, 3, 5 and 7 are prime, but 4, 6, 8 and 9 are not. The number 1, by definition, is not prime.
    a) Write a method that determines whether a number is prime.
    b) Use this method in an application that determines and displays all the prime numbers less than 10,000.
 */

import java.util.Scanner;

public class E25_Primes {
    public static void main(String[] args) {
        // Print a list of primes from 1 to 10000.
        System.out.print("[");
        for (int i = 1; i < 10000; i++) {
            if (isPrime(i)) {
                System.out.printf("%d, ", i);
            }
        }
        System.out.printf("\b\b]%n");

        // Verify user input
        Scanner input = new Scanner(System.in);
        System.out.print("Insert an integer to check: ");
        long userInput = input.nextLong();

        if (isPrime(userInput)) {
            System.out.printf("Is prime.%n");
        } else {
            System.out.printf("Isn't prime.%n");
        }
    }

    public static boolean isPrime(long n) {
        long nSquare = (long) Math.sqrt(n);
        boolean isPrimeFlag = false;

        // Case 1 (not prime by definition)
        if (n != 1) {
            isPrimeFlag = true;
            // Check if is exists a divisor (1, sqrt(n)]
            for (int i = 2; i <= nSquare; i++) {
                if (n % i == 0) {
                    isPrimeFlag = false;
                    break;
                }
            }
        }
        // Return result
        return isPrimeFlag;
    }
}
