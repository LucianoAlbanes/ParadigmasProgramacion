package TP1;

import java.util.Scanner;

public class MathOps {
    // CLI
    public static void main(String[] args) {
        // Print different options and get user choice.
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%n%s",
                "Insert the operation to be performed...",
                "   1- Addition",
                "   2- Subtraction",
                "   3- Product",
                "   4- Division",
                "Your choice: "
        );
        Scanner input = new Scanner(System.in);
        int operation = input.nextInt();

        // Get values (a and b)
        System.out.printf("%s%n%s",
                "(A `operation` B = Result)",
                "A = "
        );
        double a = input.nextDouble();

        System.out.printf("%s",
                "B = "
        );
        double b = input.nextDouble();

        // Define a variable to store the result to be printed
        double result = 0.0;
        boolean executed = false;

        // Switch and call the corresponding operation
        switch (operation) {
            case 1:
                result = add(a, b);
                executed = true;
                break;
            case 2:
                result = diff(a, b);
                executed = true;
                break;
            case 3:
                result = product(a, b);
                executed = true;
                break;
            case 4:
                result = division(a, b);
                executed = true;
                break;
            default:
                System.out.printf("'%d' isn't a valid operation. Try again please.", operation);
        }

        // Print the result iff exists.
        if (executed) {
            System.out.printf("The result is: %.2f%n", result);
        }
    }


    // Addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Subtraction
    public static double diff(double a, double b) {
        return a - b;
    }

    // Product
    public static double product(double a, double b) {
        return a * b;
    }

    // Division
    public static double division(double a, double b) {
        return a / b;
    }
}
