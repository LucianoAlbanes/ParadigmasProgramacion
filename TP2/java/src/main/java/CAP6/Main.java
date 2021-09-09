package CAP6;
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
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s",
                "Insert the exercise number...",
                "   1 - Exercise 6.8 (Array 1D)",
                "   2 - Exercise 6.9 (Array 2D)",
                "   3 - Exercise 6.12 (Duplicate Elimination)",
                "   4 - Exercise 6.14 (Variable-Length Argument List)",
                "   5 - Exercise 6.15 (Command-Line Arguments)",
                "   6 - Exercise 6.15 (Command-Line Enhanced for)",
                "   7 - Exercise 6.17 (Dice Rolling)",
                "   8 - Exercise 6.20 (Archery Game)",
                "Your choice: "
        );
        Scanner input = new Scanner(System.in);
        int userChoice = input.nextInt();

        // Switch between possibles options. If exists, call the main fn. of the exercise.
        switch (userChoice) {
            case 1 -> E8_ArraysOps.main(null);
            case 2 -> E9_2DArray.main(null);
            case 3 -> E12_DuplicateElimination.main(null);
            case 4 -> E14_AverageValue.main(null);
            case 5 -> System.out.print("That exercise can't be accessed using this CLI, there's another .jar called \"TP2_CAP6_E15.jar\".");
            case 6 -> System.out.print("That exercise can't be accessed using this CLI, there's another .jar called \"TP2_CAP6_E16.jar\".");
            case 7 -> E17_DiceRolling.main(null);
            case 8 -> E20_ArcheryGame.main(null);
            default -> System.out.printf("'%d' isn't a valid option. Try again please.", userChoice);
        }
    }
}
