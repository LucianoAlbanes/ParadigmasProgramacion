package TP1;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get value to calc his factorial.
        System.out.print("Insert a number to calculate the factorial: ");
        int n = input.nextInt();

        // Calc and print the factorial of f
        Factorial obj = new Factorial();

        System.out.printf("The factorial of %d is: %d%n", n, obj.factorial(n));

    }

    public BigInteger factorial(int n) {
        BigInteger result = new BigInteger("1");

        BigInteger factor = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            result = result.multiply(factor);
            factor = factor.add(BigInteger.ONE);
        }

        return result;
    }
}