package CAP5;

/*
(Displaying a Square of Asterisks) Write a method squareOfAsterisks that displays a solid
square (the same number of rows and columns) of asterisks whose side is specified in integer
parameter side . For example, if side is 4, the method should display:
        ****
        ****
        ****
        ****
Incorporate this method into an application that reads an integer value for side from the user and
outputs the asterisks with the squareOfAsterisks method.

*/

import java.util.Scanner;

public class E18_SquareAsterisks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read user input size and print
        System.out.print("Insert size: ");
        int userSize = input.nextInt();

        // Print using method
        squareOfAsterisks(userSize);
    }

    public static void squareOfAsterisks(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*");
            }
            System.out.printf("%n");
        }
    }
}
