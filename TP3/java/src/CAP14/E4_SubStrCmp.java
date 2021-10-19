package CAP14;

import java.util.Scanner;

public class E4_SubStrCmp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input
        System.out.print("Insert a first string to check: ");
        String str1 = scanner.next();
        System.out.print("Insert a second string to check: ");
        String str2 = scanner.next();

        System.out.print("Insert number of characters to be compared: ");
        int len = scanner.nextInt();
        System.out.print("Insert starting index: ");
        int offset = scanner.nextInt();

        // Matcher
        System.out.printf("%n%s%n", str1.regionMatches(true, offset, str2, offset, len) ? "Regions do match!" : "Regions don't match.");
    }
}
