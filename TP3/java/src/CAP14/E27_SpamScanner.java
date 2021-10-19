package CAP14;

import java.util.HashSet;
import java.util.Scanner;

public class E27_SpamScanner {
    public static void main(String[] args) {
        // Create a spamDetector with these words
        SpamDetector spamDetector = new SpamDetector(
                "Now",
                "Apply",
                "Buy",
                "Call",
                "Here",
                "Clearance",
                "Expire",
                "Get",
                "Important",
                "Limited",
                "Only",
                "Offer",
                "Special",
                "Promo",
                "Promotion",
                "Urgent",
                "Winner",
                "Join",
                "Bonus",
                "Discount",
                "Price",
                "Best",
                "Free",
                "Incredible",
                "Deal",
                "Prize",
                "Guaranteed",
                "Credit",
                "CC",
                "Dear",
                "Membership",
                "Won");

        // User input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert a line to scan: ");
        String userInput = scanner.nextLine();
        System.out.printf("That line has a Spam Score of %d points.%n", spamDetector.getSpamScore(userInput));
    }
}

class SpamDetector {
    // Instance variables.
    // HashSet used, will be initiated in constructor
    private final HashSet<String> bannedKeywords = new HashSet<>();

    // Constructor
    public SpamDetector(String... keywords) {
        for (String keyword : keywords) {
            keyword = keyword.trim().toLowerCase();
            bannedKeywords.add(keyword);
        }
    }

    // Methods
    public boolean isBannedKeyword(String keyword) {
        return bannedKeywords.contains(keyword.trim().toLowerCase());
    }

    public int getSpamScore(String str) {
        int spamScore = 0;

        // Prepare words
        str = str.trim().replaceAll("[^a-zA-Z0-9 ']", ""); // Regex is keeping
        String[] words = str.split(" ");

        // Analyze
        for (String word : words) {
            if ((isBannedKeyword(word.trim()))) {
                ++spamScore;
            }
        }

        // Return spam words count
        return spamScore;
    }

}