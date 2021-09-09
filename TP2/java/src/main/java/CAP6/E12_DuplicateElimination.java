package CAP6;

/*
(Duplicate Elimination) Use a one-dimensional array to solve the following problem:
Write an application that inputs ten numbers, each between 10 and 100, both inclusive.
Save each number that was read in an array that was initialized to a value of –1 for all elements.
Assume a value of –1 indicates an array element is empty. You are then to process the array, and
remove duplicate elements from the array containing the numbers you input. Display the contents
of the array to demonstrate that the duplicate input values were actually removed. [Note: do not
display the array elements where the value is –1.]
*/

import java.util.Arrays;
import java.util.Scanner;

public class E12_DuplicateElimination {
    public static void main(String[] args) {
        // Define and initialize array
        double[] numbers = new double[10];
        Arrays.fill(numbers, -1);

        // Read user inputs
        Scanner inputScanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            boolean validInput = false;
            double input;

            do {
                System.out.printf("Insert the %d-th value: ", i+1);
                input = inputScanner.nextDouble();
                if (input <= 100 && input >= 10) {
                    validInput = true;
                    numbers[i] = input;
                }
            } while (!validInput);
        }

        // Process the array
        for (int i = 0; i < numbers.length; i++) {
            double actual = numbers[i];
            if (actual != -1) {
                for (int j = i+1; j < numbers.length; j++) {
                    if (actual == numbers[j]) {
                        numbers[j] = -1;
                    }
                }
            }
        }

        // Print the array
        System.out.print("[");
        for (double number : numbers) {
            if (number != -1) {
                System.out.printf("%.2f, ", number);
            }
        }
        System.out.printf("\b\b]%n");
    }
}
