package TP1;

import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get value to calc his fibonacci.
        System.out.print("Insert the n-th fibonacci number to calc: ");
        int n = input.nextInt();

        // Calc and print the result
        Fibonacci obj = new Fibonacci();

        System.out.printf("The %d-th fibonacci is: %d%n", n, obj.fibonacci(n));

    }

    public BigInteger fibonacci(int n) {
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        BigInteger c = new BigInteger("0");
        for (int i=1; i < n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return c;
    }
}