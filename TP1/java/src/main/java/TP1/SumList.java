package TP1;

import java.util.Arrays;

public class SumList {
    public static void main(String[] args) {
        int[] someInts = {1,2,3,4,5,6,7,8,9,10};
        System.out.printf("List: %s%nSum: %s%n", Arrays.toString(someInts), summation(someInts));

    }

    public static int summation(int[] list) {
        int sum = 0;

        for (int summand: list) {
            sum += summand;
        }

        return sum;
    }
}
