package CAP6;
/*
Consider a two-by-three integer array t.
    a) Write a statement that declares and creates t.
    b) How many rows does t have?
    c) How many columns does t have?
    d) How many elements does t have?
    e) Write access expressions for all the elements in row 1 of t.
    f) Write access expressions for all the elements in column 2 of t.
    g) Write a single statement that sets the element of t in row 0 and column 1 to zero.
    h) Write individual statements to initialize each element of t to zero.
    i) Write a nested for statement that initializes each element of t to zero.
    j) Write a nested for statement that inputs the values for the elements of t from the user.
    k) Write a series of statements that determines and displays the smallest value in t.
    l) Write a single printf statement that displays the elements of the first row of t.
    m) Write a statement that totals the elements of the third column of t. Do not use iteration.
    n) Write a series of statements that displays the contents of t in tabular format. List the
    column indices as headings across the top, and list the row indices at the left of each row.
*/

import java.util.Arrays;
import java.util.Scanner;

public class E9_2DArray {
    public static void main(String[] args) {
        // a)
        int[][] t = new int[2][3];

        // b) 2.

        // c) 3.

        // d) 6.

        // e) t[1][0], t[1][1], t[1][2].

        // f) t[0][2], t[1][2].

        // g)
        t[0][1] = 0;

        // h)
        t[0][0] = 0;
        t[0][1] = 0;
        t[0][2] = 0;
        t[1][0] = 0;
        t[1][1] = 0;
        t[1][2] = 0;

        // i)
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = 0;
            }
        }

        // j)
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.printf("?  t[%d, %d] = ", i, j);
                t[i][j] = input.nextInt();
            }
        }

        // k)
        int minValue = t[0][0];
        for (int[] ints : t) {
            for (int anInt : ints) {
                if (anInt < minValue) {
                    minValue = anInt;
                }
            }
        }
        System.out.printf("Min value of t: %d%n", minValue);

        // l)
        System.out.printf("First row elements: %s%n", Arrays.toString(t[0]));

        // m)
        int sumThirdColumn = t[0][2] + t[1][2];

        // n)
        System.out.printf("%2s|%4d%4d%4d%n", "", 0, 1, 2);
        System.out.printf("____________________%n");
        System.out.printf("%2d|%4d%4d%4d%n", 0, t[0][0], t[0][1], t[0][2]);
        System.out.printf("%2d|%4d%4d%4d%n", 1, t[1][0], t[1][1], t[1][2]);
    }
}
