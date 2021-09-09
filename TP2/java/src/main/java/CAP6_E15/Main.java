package CAP6_E15;
/*
(Command-Line Arguments) Write a program that takes command-line arguments and
computes the average of their maximum and minimum. Make sure there are command-line
arguments being passed before you attempt to compute anything.
*/

public class Main {
    public static void main(String... args) {
        if (args.length == 0) {
            System.out.println("Please insert values, separated by spaces.");
        } else {
            double total = 0;
            for (String value:args) {
                total += Double.parseDouble(value);
            }
            System.out.printf("Average: %f%n", total / args.length);
        }
    }
}
