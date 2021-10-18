package CAP14;

import java.util.Arrays;
import java.util.Scanner;

public class E18A_TextAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Insert a line: ");
        String userLine = scanner.nextLine();
        userLine = userLine.toUpperCase();

        // Define an array to store the times that each letter appears.
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, 0);

        // Analyze each character and store a count into alphabet array
        for (int i = 0; i < userLine.length(); i++) {
            if (Character.isLetter(userLine.charAt(i))) {
                int index = userLine.charAt(i) - 'A';
                alphabet[index]++;
            }
        }

        // Print results in tabular form.
        System.out.printf("%n%7s |%6s%n", "Letter", "Times");
        for (int i = 0; i < 26; i++) {
            char letter = (char) (i + 'A'); // Downcast code point to char
            if (alphabet[i] > 0) {
                System.out.printf("%7s |%6s%n", letter, alphabet[i]);
            }
        }
    }
}
