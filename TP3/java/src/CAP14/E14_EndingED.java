package CAP14;

import java.util.Scanner;

public class E14_EndingED {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input
        System.out.print("Insert a line: ");
        String userInput = scanner.nextLine();

        // Tokenize.
        userInput = userInput.trim(); // Just in case
        String[] tokens = userInput.split(" ");

        // Print words that end with "ED" (upperCase)
        System.out.print("Words that end with \"ED\": ");
        for (String token : tokens) {
            if (token.endsWith("ED")) {
                System.out.printf("%s, ", token);
            }
        }
        System.out.print("\b\b. ");
    }
}
