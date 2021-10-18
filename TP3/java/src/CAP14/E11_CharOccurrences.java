package CAP14;

import java.util.Scanner;

public class E11_CharOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input
        System.out.print("Insert a line: ");
        String userLine = scanner.nextLine();
        System.out.print("Insert a character to search: ");
        char userChar = scanner.next().charAt(0);

        // Count times that appears
        int timesThatAppears = 0;
        int prevIndex = -1;

        while ((prevIndex = userLine.indexOf(userChar, prevIndex + 1)) != -1) {
            timesThatAppears += 1;
        }

        // Print result
        System.out.printf("The character \"%s\" appears %d times.%n", userChar, timesThatAppears);
    }
}
