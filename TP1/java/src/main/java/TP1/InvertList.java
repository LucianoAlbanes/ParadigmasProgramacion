package TP1;

import java.util.Arrays;

public class InvertList {
    public static void main(String[] args) {
        int[] someInts = {1,2,3,4,5,6,7,8,9,10};
        System.out.printf("Original: %s%nInverted: %s%n", Arrays.toString(someInts), Arrays.toString(inverse(someInts)));

    }

    public static int[] inverse(int[] list) {
        int size = list.length;
        int[] invertedList = new int[size];

        for (int i=0; i<size; i++) {
            invertedList[i] = list[size-i-1];
        }

        return invertedList;
    }
}
