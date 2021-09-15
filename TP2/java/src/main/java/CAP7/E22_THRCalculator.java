package CAP7;

/*
(Target-Heart-Rate Calculator) While exercising, you can use a heart-rate monitor to see
that your heart rate stays within a safe range suggested by your trainers and doctors. According to
the American Heart Association (AHA) (http://bit.ly/TargetHeartRates), the formula for calculating
your maximum heart rate in beats per minute is 220 minus your age in years. Your target
heart rate is a range that’s 50–85% of your maximum heart rate. [Note: These formulas are estimates
provided by the AHA. Maximum and target heart rates may vary based on the health, fitness and
gender of the individual. Always consult a physician or qualified health-care professional before
beginning or modifying an exercise program.] Create a class called HeartRates. The class attributes
should include the person’s first name, last name and date of birth (consisting of separate attributes
for the month, day and year of birth). Your class should have a constructor that receives this data as
parameters. For each attribute provide set and get methods. The class also should include a method
that calculates and returns the person’s age (in years), a method that calculates and returns the per-
son’s maximum heart rate and a method that calculates and returns the person’s target heart rate.
Write a Java app that prompts for the person’s information, instantiates an object of class Heart-
Rates and prints the information from that object—including the person’s first name, last name and
date of birth—then calculates and prints the person’s age in (years), maximum heart rate and target-
heart-rate range.
*/

import java.util.Scanner;

public class E22_THRCalculator {
    public static void main(String[] args) {
        // CLI
        // Ask data
        Scanner input = new Scanner(System.in);

        System.out.printf("Insert the following data:%nFirst name: ");
        String firstName = input.nextLine();
        System.out.print("Last name: ");
        String lastName = input.nextLine();
        System.out.print("Birth day (DD): ");
        int birthDay = input.nextInt();
        System.out.print("Birth month (MM): ");
        int birthMonth = input.nextInt();
        System.out.print("Birth year (YYYY): ");
        int birthYear = input.nextInt();

        // Make the heartRate object and display required data.
        HeartRates person1 = new HeartRates(firstName, lastName, birthDay, birthMonth, birthYear);
        int[] targetHRValues = person1.targetHR(); // [MIN, MAX].
        System.out.printf("%n%s %s:%n\tBirthdate: %d-%d-%d%n\tAge: %d.%n\tMax HR: %d.%n\tTarget HR: %d-%d.",
                person1.getFirstName(), person1.getLastName(),
                person1.getBirthDay(), person1.getBirthMonth(), person1.getBirthYear(), person1.getAge(),
                person1.maxHR(), targetHRValues[0], targetHRValues[1]);
    }
}

class HeartRates {
    // Attributes
    private String firstName;
    private String lastName;
    private int birthDay;
    private int birthMonth;
    private int birthYear;

    // Constructor
    public HeartRates(String firstName, String lastName, int birthDay, int birthMonth, int birthYear) {
        // Assumes valid input
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }

    // Setters and Getters
    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Methods
    public int getAge() {
        // Actual date
        int DAY = 1;
        int MONTH = 9;
        int YEAR = 2021;

        // Calc and return
        boolean addYear = ((birthMonth < MONTH) || ((birthMonth == MONTH) && (birthDay <= DAY)));
        int age = YEAR - birthYear;
        return (addYear) ? age : age - 1;
    }

    public int maxHR() {
        // Get the age.
        int age = getAge();

        // Switch-like ifs.
        int maxHR = 150; // +65 Years
        if      (age > 60 && age <= 65) {maxHR = 155;}
        else if (age > 55 && age <= 60) {maxHR = 160;}
        else if (age > 50 && age <= 55) {maxHR = 165;}
        else if (age > 45 && age <= 50) {maxHR = 170;}
        else if (age > 40 && age <= 45) {maxHR = 175;}
        else if (age > 35 && age <= 40) {maxHR = 180;}
        else if (age > 30 && age <= 35) {maxHR = 185;}
        else if (age > 20 && age <= 30) {maxHR = 190;}
        else if (age >= 0 && age <= 20) {maxHR = 200;}

        // Return final maxHR.
        return maxHR;
    }

    public int[] targetHR() {
        // Returns the target heart rate as an array of 2 elements [MIN, MAX].
        // Get the age.
        int age = getAge();

        // Switch-like ifs.
        int[] targetHR = {75, 128}; // +65 Years
        if      (age > 60 && age <= 65) {targetHR[0] = 78 ; targetHR[1] = 132;}
        else if (age > 55 && age <= 60) {targetHR[0] = 80 ; targetHR[1] = 136;}
        else if (age > 50 && age <= 55) {targetHR[0] = 83 ; targetHR[1] = 140;}
        else if (age > 45 && age <= 50) {targetHR[0] = 85 ; targetHR[1] = 145;}
        else if (age > 40 && age <= 45) {targetHR[0] = 88 ; targetHR[1] = 149;}
        else if (age > 35 && age <= 40) {targetHR[0] = 90 ; targetHR[1] = 153;}
        else if (age > 30 && age <= 35) {targetHR[0] = 93 ; targetHR[1] = 157;}
        else if (age > 20 && age <= 30) {targetHR[0] = 95 ; targetHR[1] = 162;}
        else if (age >= 0 && age <= 20) {targetHR[0] = 100; targetHR[1] = 170;}

        // Return final targetHR.
        return targetHR;
    }
}