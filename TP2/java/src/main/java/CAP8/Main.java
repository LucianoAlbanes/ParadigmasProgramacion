package CAP8;
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
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s",
                "Insert the exercise number...",
                "   1 - Exercise 8.4 (Cylinder class)",
                "   2 - Exercise 8.5 (Time2 modified)",
                "   3 - Exercise 8.6 (Savings account)",
                "   4 - Exercise 8.7 (Time2 tick)",
                "   5 - Exercise 8.11 (Complex numbers)",
                "   6 - Exercise 8.14 (Integers set)",
                "   7 - Exercise 8.18 ()",
                "Your choice: "
        );
        Scanner input = new Scanner(System.in);
        int userChoice = input.nextInt();

        // Switch between possibles options. If exists, call the main fn. of the exercise.
        switch (userChoice) {
            case 1 -> E4_Cylinder.main(null);
            case 2 -> E5_Time2Mod.main(null);
            case 3 -> E6_SavingsAccount.main(null);
            case 4 -> E7_Time2Tick.main(null);
            case 5 -> E11_ComplexNumbers.main(null);
            case 6 -> E14_IntegersSet.main(null);
            case 7 -> main(null);
            default -> System.out.printf("'%d' isn't a valid option. Try again please.", userChoice);
        }
    }
}
