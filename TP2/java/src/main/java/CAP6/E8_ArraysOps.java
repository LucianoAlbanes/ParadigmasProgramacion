package CAP6;
/*
Write Java statements to accomplish each of the following tasks:
    a) Display the value of the tenth element of array 'r'.
    b) Initialize each of the six elements of one-dimensional integer array 'g' to -1.
    c) Find the maximum of the first one-hundred elements of floating-point array 'c'.
    d) Copy a hundred-element array 'a' into a hundred-element array 'b', but in reverse order.
    e) Compute the product of the third to the tenth elements, both inclusive, in a hundred-element integer array 'w'.
 */


import java.util.Arrays;
import java.util.Random;

public class E8_ArraysOps {
    public static void main(String[] args) {
        // Exercise A
        int[] r = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        System.out.println("Tenth element of r: " + r[9]);

        // Exercise B
        int[] g = new int[6];
        Arrays.fill(g, -1);
        System.out.println("Array g: " + Arrays.toString(g));

        // Exercise C
        Random rand = new Random();
        float[] c = new float[100];
        for (int i = 0; i < 100; i++) {c[i] = rand.nextFloat();}

        float maxValue = c[0];
        for (int i = 1; i < c.length; i++) {
            if (c[i] > maxValue) {
                maxValue = c[i];
            }
        }
        System.out.println("Max value of c: " + maxValue);

        // Exercise D
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {a[i] = i;}

        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++) {b[i] = a[a.length-i-1];}

        System.out.printf("Array a: %s%nArray b: %s%n", Arrays.toString(a), Arrays.toString(b));

        // Exercise E
        int[] w = new int[100];
        for (int i = 0; i < w.length; i++) {w[i] = i;}

        int prod = 1;
        for (int i = 2; i <= 9; i++) {
            prod *= w[i];
        }

        System.out.println("Prod of w third to tenth: " + prod);
    }
}
