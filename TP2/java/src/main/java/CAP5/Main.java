package CAP5;
/*
Paradigmas de Programación 2021 - F. Ingeniería - UNCUYO
ALBANES Luciano Joaquín
 */

import java.util.Scanner;

/**
 * CLI
 */

public class Main {
    public static void main(String[] args) {
        // Print different options and get user choice.
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s",
                "Insert the exercise number...",
                "   1 - Exercise 5.8 (Parking slot)",
                "   2 - Exercise 5.18 (Square of asterisks)",
                "   3 - Exercise 5.19 (Square of characters)",
                "   4 - Exercise 5.23 (Palindrome numbers)",
                "   5 - Exercise 5.24 (Perfect numbers)",
                "   6 - Exercise 5.25 (Prime numbers)",
                "Your choice: "
        );
        Scanner input = new Scanner(System.in);
        int userChoice = input.nextInt();

        // Switch between possibles options. If exists, call the main fn. of the exercise.
        switch (userChoice) {
            case 1 -> E8_Parking.main(null);
            case 2 -> E18_SquareAsterisks.main(null);
            case 3 -> E19_SquareAnyChar.main(null);
            case 4 -> E23_PalindromeNum.main(null);
            case 5 -> E24_PerfectNum.main(null);
            case 6 -> E25_Primes.main(null);
            default -> System.out.printf("'%d' isn't a valid option. Try again please.", userChoice);
        }
    }
}
