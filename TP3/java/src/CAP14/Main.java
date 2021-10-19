package CAP14;
/*
Paradigmas de Programación 2021 - F. Ingeniería - UNCUYO
ALBANES Luciano Joaquín
 */

import java.util.Scanner;

/**
 * CLI
 */

public class Main {
    public static void main(String[] args) {
        // Print different options and get user choice.
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s",
                "Insert the exercise number...",
                "   1 - Exercise 14.3   (Palindrome)",
                "   2 - Exercise 14.4   (SubString comparison)",
                "   3 - Exercise 14.6   (Password validator)",
                "   4 - Exercise 14.8   (Tokenize telephone)",
                "   5 - Exercise 14.9   (Reverse sentence)",
                "   6 - Exercise 14.10  (Longest word)",
                "   7 - Exercise 14.11  (Character occurrences)",
                "   8 - Exercise 14.12  (All character occurrences)",
                "   9 - Exercise 14.14  (Ending with 'ED')",
                "  10 - Exercise 14.18A (Text analysis: Occurrences each letter)",
                "  11 - Exercise 14.18B (Text analysis: Occurrences per word size)",
                "  12 - Exercise 14.18C (Text analysis: Occurrences per word)",
                "  13 - Exercise 14.19  (Date format parser)",
                "  14 - Exercise 14.21  (Check amount to words)",
                "  15 - Exercise 14.22  (Morse code translator)",
                "  16 - Exercise 14.23  (Unit conversions)",
                "  17 - Exercise 14.27  (Spam scanner)",
                "Your choice: "
        );
        Scanner input = new Scanner(System.in);
        int userChoice = input.nextInt();

        // Switch between possibles options. If exists, call the main fn. of the exercise.
        switch (userChoice) {
            case 1 ->  E3_Palindrome.main(null);
            case 2 ->  E4_SubStrCmp.main(null);
            case 3 ->  E6_PassValidator.main(null);
            case 4 ->  E8_TokenTelNumb.main(null);
            case 5 ->  E9_ReverseSentence.main(null);
            case 6 ->  E10_LongestWord.main(null);
            case 7 ->  E11_CharOccurrences.main(null);
            case 8 ->  E12_AllCharOccurrences.main(null);
            case 9 ->  E14_EndingED.main(null);
            case 10 -> E18A_TextAnalysis.main(null);
            case 11 -> E18B_TextAnalysis.main(null);
            case 12 -> E18C_TextAnalysis.main(null);
            case 13 -> E19_DateFormat.main(null);
            case 14 -> E21_CheckAmount.main(null);
            case 15 -> E22_MorseCode.main(null);
            case 16 -> E23_MetricConversions.main(null);
            case 17 -> E27_SpamScanner.main(null);
            default -> System.out.printf("'%d' isn't a valid option. Try again please.", userChoice);
        }
    }
}
