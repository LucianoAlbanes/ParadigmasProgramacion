package CAP14;

import java.util.HashMap;
import java.util.Scanner;

public class E18C_TextAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input
        System.out.print("Insert a line: ");
        String userInput = scanner.nextLine();

        // Prepare string and tokenize
        userInput = userInput.trim().replaceAll("[^a-zA-Z0-9 ']", "");
        userInput = userInput.toUpperCase();
        String[] tokens = userInput.split(" ");

        // Create a HashMap for storing <Word, Times>
        HashMap<String, Integer> map = new HashMap<>();

        // Analyze userInput and store results in map
        for (String token : tokens) {
            // Set Hash to 1 or update
            // IDE suggest: map.merge(token, 1, Integer::sum);
            Integer count = map.get(token);
            if (count == null) {
                map.put(token, 1);
            } else {
                map.put(token, count + 1);
            }
        }

        // Print results in tabular form.
        System.out.printf("%n%15s |%6s%n", "Word", "Times");
        for (String word : map.keySet()) {
            System.out.printf("%15s |%6s%n", word, map.get(word));
        }
    }
}
