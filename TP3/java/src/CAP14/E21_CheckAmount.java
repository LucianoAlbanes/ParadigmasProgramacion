package CAP14;

import java.util.Scanner;

public class E21_CheckAmount {
    public static void main(String[] args) {
        // Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert an amount: ");
        System.out.println(Amount.toString(scanner.nextDouble()));
    }
}

class Amount {
    private static final String[] tensStr = {
            "",
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    private static final String[] unitsStr = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    public static String toString(double amount) throws IllegalArgumentException {
        // Check condition
        if (amount < 0 || amount >= 1000) {
            throw new IllegalArgumentException("Amount must be between 0 and 1000.");
        }

        // Create the StringBuilder and obtain parts.
        StringBuilder str = new StringBuilder();
        int hundreds = (int) (amount / 100);
        int tens = (int) ((amount - hundreds * 100) / 10);
        int units = (int) (amount - hundreds * 100 - tens * 10);
        int cents = (int) ((amount - hundreds * 100 - tens * 10 - units) * 100);

        // Hundreds
        if (hundreds > 0) {
            str.append(unitsStr[hundreds]).append(" hundred ");
        }

        // Tens and units
        if (tens >= 2) {
            str.append(tensStr[tens]).append(" ");
            str.append(unitsStr[units]);
        } else {
            str.append(unitsStr[tens * 10 + units]);
        }

        // Cents
        if (cents > 0) {
            str.append(" and ").append(cents).append("/100");
        }

        // Change first character to uppercase and return as String.
        return str.replace(0, 1, String.valueOf(Character.toUpperCase(str.charAt(0)))).toString();
    }
}

