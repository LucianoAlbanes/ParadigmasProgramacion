package CAP14;

import java.util.HashMap;
import java.util.Scanner;

public class E18B_TextAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input
        System.out.print("Insert a line: ");
        String userInput = scanner.nextLine();

        // Prepare string and tokenize
        userInput = userInput.trim().replaceAll("[^a-zA-Z0-9 ']", ""); // Regex is keeping "'"
        String[] tokens = userInput.split(" ");

        // Create a HashMap for storing <WordLength, Times>
        HashMap<Integer, Integer> map = new HashMap<>();

        // Analyze userInput and store results in map
        for (String token : tokens) {
            int actualLength = token.length();
            // Set Hash to 1 or update
            // IDE suggest: map.merge(actualLength, 1, Integer::sum);
            Integer count = map.get(actualLength);
            if (count == null) {
                map.put(actualLength, 1);
            } else {
                map.put(actualLength, count + 1);
            }
        }

        // Print results in tabular form.
        System.out.printf("%n%5s |%6s%n", "Size", "Times");
        for (Integer key : map.keySet()) {
            System.out.printf("%5s |%6s%n", key, map.get(key));
        }
    }
}
