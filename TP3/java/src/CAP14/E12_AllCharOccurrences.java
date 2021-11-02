package CAP14;

import java.util.Scanner;

public class E12_AllCharOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input
        System.out.print("Insert a line: ");
        String userLine = scanner.nextLine();
        userLine = userLine.toUpperCase();

        // Define an array to store the times that each letter appears.
        int[] alphabet = new int[26];

        // Count times that each letter appears.
        for (int i = 0; i < 26; i++) {
            char letter = (char) (i + 'A'); // Downcast code point to char
            alphabet[i] = timesCharacter(userLine, letter);
        }

        // Print results in tabular form.
        System.out.printf("%7s |%6s%n", "Letter", "Times");
        for (int i = 0; i < 26; i++) {
            char letter = (char) (i + 'A'); // Downcast code point to char
            if (alphabet[i] > 0) {
                System.out.printf("%7s |%6s%n", letter, alphabet[i]);
            }
        }
    }

    public static int timesCharacter(String str, char character) {
        // Count the times that a given character appears in a string.
        int timesThatAppears = 0;
        int prevIndex = -1;

        while ((prevIndex = str.indexOf(character, prevIndex + 1)) != -1) {
            timesThatAppears += 1;
        }
        return timesThatAppears;
    }
}
