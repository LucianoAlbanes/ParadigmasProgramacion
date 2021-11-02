package CAP14;

/*
between 8 and 15 characters [both inclusive]
starts with an alphabet
contains at least one uppercase letter
contains at least one number
*/

import java.util.Scanner;

public class E6_PassValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert a password to check: ");
        String input = scanner.next();
        System.out.printf("%s%n", isValidPassword(input) ? "Is a valid password." : "Isn't a valid password.");
    }

    public static boolean isValidPassword(String pwd) {
        boolean isValidPassword = true; // Until proven otherwise.

        // Checks
        // Length and starts with alphabet
        if (pwd.length() < 8 || pwd.length() > 15 || !Character.isAlphabetic(pwd.charAt(0))) {
            isValidPassword = false;
        } else {
            // Contains at least one uppercase and digit
            boolean upper = false;
            boolean digit = false;

            for (int i = 0; i < pwd.length(); i++) {
                if (!upper && Character.isUpperCase(pwd.charAt(i))) {
                    upper = true;
                }
                if (!digit && Character.isDigit(pwd.charAt(i))) {
                    digit = true;
                }
                if (upper && digit) {
                    break;
                }
            }
            if (!(upper && digit)) {
                isValidPassword = false;
            }
        }

        // Return
        return isValidPassword;
    }
}
