package CAP6;
/*
(Dice Rolling) Write an application to simulate the rolling of two dice. The application
should use an object of class Random once to roll the first die and again to roll the second die. The
sum of the two values should then be calculated. Each die can show an integer value from 1 to 6, so
the sum of the values will vary from 2 to 12, with 7 being the most frequent sum, and 2 and 12 the
least frequent. Figure 6.18 shows the 36 possible combinations of the two dice. Your application
should roll the dice 36,000,000 times. Use a one-dimensional array to tally the number of times
each possible sum appears. Display the results in tabular format.
*/

import java.util.Arrays;
import java.util.Random;

public class E17_DiceRolling {
    public static void main(String[] args) {
        // Define an array to store results
        int[] results = new int[11];
        Arrays.fill(results, 0);

        // Roll both dices 36M times
        for (int i = 0; i < 36_000_000; i++) {
            int round = roll() + roll();
            results[round-2]++;
        }

        // Print table of results
        System.out.printf("%4s |%8s%n", "Sum", "Times");
        for (int i = 0; i < results.length; i++) {
            System.out.printf("%4d |%8d%n", i+2, results[i]);
        }
    }

    public static int roll() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
