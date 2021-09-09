package CAP6_E16;
/*
(Using the Enhanced for Statement) Write an application that uses an enhanced for
statement to find the absolute values of int numbers passed by command-line arguments.
*/

public class Main {
    public static void main(String... args) {
        if (args.length == 0) {
            System.out.println("Please insert values, separated by spaces.");
        } else {
            // Print as an array
            System.out.print("[");
            for (String value : args) {
                System.out.printf("%d, ", Math.abs(Integer.parseInt(value)));
            }
            System.out.printf("\b\b]%n");
        }
    }
}