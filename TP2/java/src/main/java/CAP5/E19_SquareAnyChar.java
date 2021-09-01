package CAP5;

/*
(Displaying a Square of Any Character) Modify the method created in Exercise 5.18 to
receive a second parameter of type char called fillCharacter. Form the square using the char
provided as an argument. Thus, if side is 5 and fillCharacter is #, the method should display
        #####
        #####
        #####
        #####
        #####
*/

import java.util.Scanner;

public class E19_SquareAnyChar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read user input size
        System.out.print("Insert size: ");
        int userSize = input.nextInt();

        // Read user input size and print
        System.out.print("Insert character to use: ");
        char userChar = input.next().charAt(0); // Take only the first given character


        // Print using method
        squareOfCharacters(userSize, userChar);
    }

    public static void squareOfCharacters(int size, char character) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(character);
            }
            System.out.printf("%n");
        }
    }
}
