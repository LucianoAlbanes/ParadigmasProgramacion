package CAP14;

import java.util.Scanner;

public class E19_DateFormat {
    public static void main(String[] args) {
        // Create an array with the names of the months
        final String[] MONTHS = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };

        // Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert a date in format (Format: MM/DD/YYYY): ");
        String userInput = scanner.next();

        // Tokenize.
        userInput = userInput.trim(); // Just in case
        String[] tokens = userInput.split("/");

        // Print date
        try {
            System.out.printf("%s %s, %s", MONTHS[Integer.parseInt(tokens[0]) - 1], tokens[1], tokens[2]);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid month", e);
        }
    }
}
