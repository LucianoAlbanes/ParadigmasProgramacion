package TP1;

import java.util.Arrays;

public class FirstAndLastCharacter {
    public static void main(String[] args) {
        // Get the sting with the characters in order ![Hardcoded]
        String text = "Hola mundo";

        // Create an array of characters with each character of 'text'
        char[] characterList = text.toCharArray(); //{"H", "o", "l", "a", " ", "m", "u", "n", "d", "o", "!"} as collection

        // Do the prints
        System.out.printf("~~~ %s ~~~%n", Arrays.toString(characterList));
        System.out.printf("The first character of the list is: %s%n", characterList[0]);
        System.out.printf("The last character of the list is: %s%n", characterList[characterList.length - 1]);

    }
}
