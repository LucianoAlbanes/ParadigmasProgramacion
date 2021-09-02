package CAP5;

/*
The greatest common divisor (GCD) of two integers is the largest
integer that evenly divides each of the two numbers. Write a method gcd that returns the greatest
common divisor of two integers. [Hint: You might want to use Euclid’s algorithm. You can find
information about it at en.wikipedia.org/wiki/Euclidean_algorithm.] Incorporate the method
into an application that reads two values from the user and displays the result.
*/

import java.util.Scanner;

public class E27_GCDivisor {
    public static void main(String[] args) {
        // Ask user for two values and calc GCD
        Scanner input = new Scanner(System.in);

        System.out.print("n1: ");
        int n1 = input.nextInt();
        System.out.print("n2: ");
        int n2 = input.nextInt();

        System.out.printf("The greatest common divisor of these numbers is: %d%n", gcd(n1, n2));
    }

    public static int gcd(int a, int b) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
