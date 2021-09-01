package CAP5;

/*
An integer number is said to be a perfect number if its factors, including
1 (but not the number itself), sum to the number. For example, 6 is a perfect number, because 6 =
1 + 2 + 3. Write a method isPerfect that determines whether parameter number is a perfect number.
Use this method in an application that displays all the perfect numbers between 1 and 1000. Display
the factors of each perfect number to confirm that the number is indeed perfect. Challenge the
computing power of your computer by testing numbers much larger than 1000. Display the results.
*/

import java.util.ArrayList;

public class E24_PerfectNum {
    public static void main(String[] args) {
        // Show prefect numbers [1, 1000]
        for (int i = 1; i <= 1000; i++) {
            ArrayList<Object> result = isPerfect(i);
            boolean resultBool = (boolean) result.get(0);

            if (resultBool) {
                System.out.printf("%3d  %-20s  %n", i, result.get(1).toString());
            }

        }
    }

    public static ArrayList<Object> isPerfect(int n) {
        int actualSum = 0;
        ArrayList<Integer> factors = new ArrayList<>();

        // Test all numbers between 0 and n
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                // Found, add to actualSum and verify if not is bigger than n.
                actualSum += i;
                if (actualSum > n) {
                    // Can't be perfect, break
                    break;
                } else {
                    // Add the found factor to the list
                    factors.add(i);
                }
            }
        }

        // Return the result as an ArrayList of length 2. [bolean, ArrayList]
        ArrayList<Object> result = new ArrayList<>();
        result.add(actualSum == n);
        result.add(factors);

        return result;
    }
}
