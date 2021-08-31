package TP1;
/*
Paradigmas de Programación 2021 - F. Ingeniería - UNCUYO
ALBANES Luciano Joaquín
 */

import java.util.Scanner;

/**
 * CLI to access different exercises of TP1
 */

public class Main {
    public static void main(String[] args) {
        // Print different options and get user choice.
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%n%s",
                "Insert the exercise number...",
                "   1 - Addition, subtraction, product and division.",
                "   2 - First and last element of a characters list.",
                "   3 - Sublist containing all the elements except the first element.",
                "   4 - Sublist containing all the elements except the last element.",
                "   5 - Invert a list of integers.",
                "   6 - Sum a list of integers.",
                "   7 - Calculate the factorial of a number.",
                "   8 - Calculate the n-th fibonacci number.",
                "   9 - Generate and ask queries on a family tree.",
                "Your choice: "
        );
        Scanner input = new Scanner(System.in);
        int userChoice = input.nextInt();

        // Switch between possibles options. If exists, call the main fn. of the exercise.
        switch (userChoice) {
            case 1:
                MathOps.main(null);
                break;
            case 2:
                FirstAndLastCharacter.main(null);
                break;
            case 3:
                SublistFirst.main(null);
                break;
            case 4:
                SublistLast.main(null);
                break;
            case 5:
                InvertList.main(null);
                break;
            case 6:
                SumList.main(null);
                break;
            case 7:
                Factorial.main(null);
                break;
            case 8:
                Fibonacci.main(null);
                break;
            case 9:
                FamilyTree.main(null);
                break;
            default:
                System.out.printf("'%d' isn't a valid option. Try again please.", userChoice);
        }
    }
}
