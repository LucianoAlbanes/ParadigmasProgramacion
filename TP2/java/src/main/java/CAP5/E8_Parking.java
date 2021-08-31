package CAP5;

/* 5.8
(Parking Charges) A parking garage charges a $2.00 minimum fee to park for up to three
hours. The garage charges an additional $0.50 per hour for each hour or part thereof in excess of three
hours. The maximum charge for any given 24-hour period is $10.00. Assume that no car parks for
longer than 24 hours at a time. Write an application that calculates and displays the parking charges
for each customer who parked in the garage yesterday. You should enter the hours parked for each
customer. The program should display the charge for the current customer and should calculate and
display the running total of yesterday’s receipts. It should use the method calculateCharges to de-
termine the charge for each customer.
 */


public class E8_Parking {
    // Parking fee and hours parameters
    static final double MIN_FEE = 2.00;
    static final double MAX_FEE = 10.00;
    static final double HOUR_FEE = 0.50;
    static final int THRESHOLD_MIN = 3;

    public static void main(String[] args) {
        int[] hoursPerCar = {1, 3, 4, 17, 18, 20, 23};
        double todayCharges = 0;

        // Print formatted table of some cars
        System.out.printf("%2s%8s%n", "Hours", "Charge");
        for (int hours : hoursPerCar) {
            double charge = calculateCharges(hours);
            System.out.printf("%2d%10.2f%n", hours, charge);
            todayCharges += charge;
        }

        // Print total charged amount
        System.out.printf("%s%.2f%n", "Total charged: ", todayCharges);

    }

    public static double calculateCharges(int hours) {
        double charge = MIN_FEE;
        if (hours > THRESHOLD_MIN) {
            charge += (hours - THRESHOLD_MIN) * HOUR_FEE;
        }
        return Math.min(charge, MAX_FEE);
    }
}
