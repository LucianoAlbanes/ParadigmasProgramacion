package CAP14;

/*
Form:  (555) 555-5555
*/

import java.util.Scanner;

public class E8_TokenTelNumb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input
        System.out.print("Insert a phone number to check (Format: (555) 555-5555): ");
        String userInput = scanner.nextLine();

        // Transform number
        userInput = userInput.trim(); // Just in case
        String[] numbParts = userInput.split(" ");
        String[] phoneParts = numbParts[1].split("-");

        String area = numbParts[0].replace("(", "").replace(")", "");
        String phone = phoneParts[0] + phoneParts[1];

        // Print results
        System.out.printf("Area code: %s%nPhone number: %s%n", area, phone);
    }

}
