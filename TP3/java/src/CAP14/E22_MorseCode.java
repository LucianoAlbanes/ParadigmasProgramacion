package CAP14;

import java.util.HashMap;
import java.util.Scanner;

public class E22_MorseCode {
    public static void main(String[] args) {
        // Init MorseCode Translator
        MorseCode.init();
        // Test Code
        System.out.println("To morse: \"The quick brown fox jumps over the lazy dog 1234567890\"");
        String morsePhrase = MorseCode.translateToMorse("The quick brown fox jumps over the lazy dog 1234567890");
        System.out.println(morsePhrase);

        System.out.printf("Now, reverse:%n");
        System.out.println(MorseCode.translateToEng(morsePhrase));

        // User test
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%nInsert a line in english to translate to morse: ");
        System.out.println(MorseCode.translateToMorse(scanner.nextLine()));
        System.out.print("Insert a line in morse to translate to english: ");
        System.out.println(MorseCode.translateToEng(scanner.nextLine()));
    }

}

class MorseCode {
    // Hashmaps
    private static final HashMap<Character, String> engToMorse = new HashMap<>(35);
    private static final HashMap<String, Character> morseToEng = new HashMap<>(35);

    public static void init() {
        // EngToMorse
        engToMorse.put('A', ".-");
        engToMorse.put('B', "-...");
        engToMorse.put('C', "-.-.");
        engToMorse.put('D', "-..");
        engToMorse.put('E', ".");
        engToMorse.put('F', "..-.");
        engToMorse.put('G', "--.");
        engToMorse.put('H', "....");
        engToMorse.put('I', "..");
        engToMorse.put('J', ".---");
        engToMorse.put('K', "-.-");
        engToMorse.put('L', ".-..");
        engToMorse.put('M', "--");
        engToMorse.put('N', "-.");
        engToMorse.put('O', "---");
        engToMorse.put('P', ".--.");
        engToMorse.put('Q', "--.-");
        engToMorse.put('R', ".-.");
        engToMorse.put('S', "...");
        engToMorse.put('T', "-");
        engToMorse.put('U', "..-");
        engToMorse.put('V', "...-");
        engToMorse.put('W', ".--");
        engToMorse.put('X', "-..-");
        engToMorse.put('Y', "-.--");
        engToMorse.put('Z', "--..");
        engToMorse.put('1', ".----");
        engToMorse.put('2', "..---");
        engToMorse.put('3', "...--");
        engToMorse.put('4', "....-");
        engToMorse.put('5', ".....");
        engToMorse.put('6', "-....");
        engToMorse.put('7', "--...");
        engToMorse.put('8', "---..");
        engToMorse.put('9', "----.");
        engToMorse.put('0', "-----");

        // MorseToEng
        morseToEng.put(".-", 'A');
        morseToEng.put("-...", 'B');
        morseToEng.put("-.-.", 'C');
        morseToEng.put("-..", 'D');
        morseToEng.put(".", 'E');
        morseToEng.put("..-.", 'F');
        morseToEng.put("--.", 'G');
        morseToEng.put("....", 'H');
        morseToEng.put("..", 'I');
        morseToEng.put(".---", 'J');
        morseToEng.put("-.-", 'K');
        morseToEng.put(".-..", 'L');
        morseToEng.put("--", 'M');
        morseToEng.put("-.", 'N');
        morseToEng.put("---", 'O');
        morseToEng.put(".--.", 'P');
        morseToEng.put("--.-", 'Q');
        morseToEng.put(".-.", 'R');
        morseToEng.put("...", 'S');
        morseToEng.put("-", 'T');
        morseToEng.put("..-", 'U');
        morseToEng.put("...-", 'V');
        morseToEng.put(".--", 'W');
        morseToEng.put("-..-", 'X');
        morseToEng.put("-.--", 'Y');
        morseToEng.put("--..", 'Z');
        morseToEng.put(".----", '1');
        morseToEng.put("..---", '2');
        morseToEng.put("...--", '3');
        morseToEng.put("....-", '4');
        morseToEng.put(".....", '5');
        morseToEng.put("-....", '6');
        morseToEng.put("--...", '7');
        morseToEng.put("---..", '8');
        morseToEng.put("----.", '9');
        morseToEng.put("-----", '0');
    }

    public static String translateToMorse(String input) {
        // Translation
        StringBuilder str = new StringBuilder();
        for (char c : input.toCharArray()) {
            c = Character.toUpperCase(c);
            String morse = engToMorse.get(c);
            if (morse != null) {
                str.append(morse).append(" ");
            }
        }
        // Return
        return str.toString();
    }

    public static String translateToEng(String input) {
        // Translation
        StringBuilder str = new StringBuilder();
        input = input.trim();
        String[] tokens = input.split(" ");
        for (String morse : tokens) {

            Character eng = morseToEng.get(morse);
            if (eng != null) {
                str.append(eng);
            }
        }
        // Return
        return str.toString();
    }
}

