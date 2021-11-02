package CAP14;

import java.util.Scanner;

public class E10_LongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input
        System.out.print("Insert a line: ");
        String userInput = scanner.nextLine();

        // Tokenize, and store largest
        userInput = userInput.trim(); // Just in case
        String[] tokens = userInput.split(" ");

        int indexLargestWord = 0;
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i].length() > tokens[indexLargestWord].length()) {
                indexLargestWord = i;
            }
        }

        // Print largest word
        System.out.printf("The largest word that appears first is: \"%s\"%n", tokens[indexLargestWord]);
    }
}
