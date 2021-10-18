package CAP14;

import java.util.Scanner;

public class E9_ReverseSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input
        System.out.print("Insert a line: ");
        String userInput = scanner.nextLine();

        // Tokenize, reverse, and print
        userInput = userInput.trim(); // Just in case
        String[] tokens = userInput.split(" ");

        System.out.print("Reversed words: ");
        for (String token : tokens) {
            System.out.printf("%s ", new StringBuilder(token).reverse());
        }
        System.out.printf("%n");
    }
}
