package CAP15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class E9_PhishingScanner {
    public static void main(String[] args) {
        // Create the PhishingDetector and add some keywords
        PhishingDetector pd = new PhishingDetector();
        pd.addKeyword("Apply", PhishingDetector.LIKELY.LOW);
        pd.addKeyword("Best", PhishingDetector.LIKELY.MEDIUM);
        pd.addKeyword("Bonus", PhishingDetector.LIKELY.MEDIUM);
        pd.addKeyword("Buy", PhishingDetector.LIKELY.MEDIUM);
        pd.addKeyword("CC", PhishingDetector.LIKELY.HIGH);
        pd.addKeyword("Call", PhishingDetector.LIKELY.LOW);
        pd.addKeyword("Clearance", PhishingDetector.LIKELY.LOW);
        pd.addKeyword("Credit", PhishingDetector.LIKELY.MEDIUM);
        pd.addKeyword("Deal", PhishingDetector.LIKELY.MEDIUM);
        pd.addKeyword("Dear", PhishingDetector.LIKELY.LOW);
        pd.addKeyword("Discount", PhishingDetector.LIKELY.MEDIUM);
        pd.addKeyword("Expire", PhishingDetector.LIKELY.MEDIUM);
        pd.addKeyword("Free", PhishingDetector.LIKELY.HIGH);
        pd.addKeyword("Get", PhishingDetector.LIKELY.LOW);
        pd.addKeyword("Guaranteed", PhishingDetector.LIKELY.MEDIUM);
        pd.addKeyword("Here", PhishingDetector.LIKELY.LOW);
        pd.addKeyword("Important", PhishingDetector.LIKELY.MEDIUM);
        pd.addKeyword("Incredible", PhishingDetector.LIKELY.MEDIUM);
        pd.addKeyword("Join", PhishingDetector.LIKELY.LOW);
        pd.addKeyword("Limited", PhishingDetector.LIKELY.HIGH);
        pd.addKeyword("Membership", PhishingDetector.LIKELY.LOW);
        pd.addKeyword("Now", PhishingDetector.LIKELY.MEDIUM);
        pd.addKeyword("Offer", PhishingDetector.LIKELY.HIGH);
        pd.addKeyword("Only", PhishingDetector.LIKELY.HIGH);
        pd.addKeyword("Price", PhishingDetector.LIKELY.LOW);
        pd.addKeyword("Prize", PhishingDetector.LIKELY.HIGH);
        pd.addKeyword("Promo", PhishingDetector.LIKELY.HIGH);
        pd.addKeyword("Promotion", PhishingDetector.LIKELY.HIGH);
        pd.addKeyword("Special", PhishingDetector.LIKELY.HIGH);
        pd.addKeyword("Urgent", PhishingDetector.LIKELY.MEDIUM);
        pd.addKeyword("Winner", PhishingDetector.LIKELY.HIGH);
        pd.addKeyword("Won", PhishingDetector.LIKELY.HIGH);

        // User input
        Scanner input = new Scanner(System.in);
        System.out.print("Insert the path of the file to scan: ");
        Path path = Paths.get(input.nextLine());

        // Check path and analyze
        if (Files.exists(path)) {
            if (!Files.isDirectory(path)) {
                // Entry point, path is a valid file.
                HashMap<String, Integer> words = analyzeFile(path, pd);
                System.out.printf("%s%n", phishingResumeToString(words, pd));
            } else {
                System.err.printf("Path is a directory: %s", path);
            }
        } else {
            System.err.printf("File don't exists: %s", path);
        }

    }

    private static String phishingResumeToString(HashMap<String, Integer> words, PhishingDetector pd) {
        // Create a String builder with all required data.
        StringBuilder str = new StringBuilder();
        int totalPoints = 0;

        // Append results in tabular form.
        str.append(String.format("%15s |%6s |%16s |%6s", "Word", "Times", "Ph. Likelihood", "Score"));
        for (String word : words.keySet()) {
            PhishingDetector.LIKELY likely = pd.getLikely(word);
            int times = words.get(word);
            totalPoints += likely.toInt() * times;
            str.append(String.format("%n%15s |%6s |%16s |%6s", word, times, likely, likely.toInt() * times));
        }
        // Append totalizator
        str.append(String.format("%nTotal points of file: %d", totalPoints));

        // Return
        return str.toString();
    }

    private static HashMap<String, Integer> analyzeFile(Path path, PhishingDetector pd) {
        // Create a HashMap for storing <Word, Times>
        HashMap<String, Integer> wordsCount = null;

        // Process each word.
        try (Scanner file = new Scanner(path)) {
            wordsCount = new HashMap<>();

            while (file.hasNext()) {
                // Get and prepare word
                String word = file.next().replaceAll("[^a-zA-Z0-9 ']", "");

                // Check if is a phishing keyword
                word = word.toLowerCase();
                PhishingDetector.LIKELY likely = pd.getLikely(word);
                if (likely != null) {
                    // Word it's a phishing keyword. Increase occurrences in hashmap
                    Integer count = wordsCount.get(word);
                    if (count == null) {
                        wordsCount.put(word, 1);
                    } else {
                        wordsCount.put(word, count + 1);
                    }
                }

            }
        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
        }

        // Return (null or valid HashMap)
        return wordsCount;
    }

}

class PhishingDetector {
    // HashMap used, will be initiated in constructor
    private final HashMap<String, LIKELY> bannedKeywords = new HashMap<>();

    // Methods
    public void addKeyword(String keyword, LIKELY likely) {
        keyword = keyword.trim().toLowerCase();
        bannedKeywords.put(keyword, likely);
    }

    public LIKELY getLikely(String keyword) {
        return bannedKeywords.get(keyword.trim().toLowerCase());
    }

    // Instance variables.
    // Enum to indicate how likely is a keyword to be part of phishing. Offers a method to return ints that increase with likelihood.
    public enum LIKELY {
        LOW,
        MEDIUM,
        HIGH;

        public int toInt() {
            int x;
            switch (this) {
                case LOW -> x = 1;
                case MEDIUM -> x = 2;
                case HIGH -> x = 3;
                default -> throw new IllegalStateException("Unexpected value: " + this);
            }
            return x;
        }
    }
}