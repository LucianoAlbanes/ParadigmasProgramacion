package CAP7;
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
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s",
                "Insert the exercise number...",
                "   1 - Exercise 7.11 (Invoice Class)",
                "   2 - Exercise 7.12 (Car Class)",
                "   3 - Exercise 7.13 (Clock Class)",
                "   4 - Exercise 7.22 (Target-Heart-Rate Calculator)",
                "Your choice: "
        );
        Scanner input = new Scanner(System.in);
        int userChoice = input.nextInt();

        // Switch between possibles options. If exists, call the main fn. of the exercise.
        switch (userChoice) {
            case 1 -> E11_InvoiceClass.main(null);
            case 2 -> E12_CarClass.main(null);
            case 3 -> E13_ClockClass.main(null);
            case 4 -> E22_THRCalculator.main(null);
            default -> System.out.printf("'%d' isn't a valid option. Try again please.", userChoice);
        }
    }
}
