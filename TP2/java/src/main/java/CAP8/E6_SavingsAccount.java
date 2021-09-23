package CAP8;

/*
(Savings Account Class) Create class SavingsAccount. Use a static variable annualInterestRate
to store the annual interest rate for all account holders. Each object of the class contains a
private instance variable savingsBalance indicating the amount the saver currently has on deposit.
Provide method calculateMonthlyInterest to calculate the monthly interest by multiplying the
savingsBalance by annualInterestRate divided by 12 —this interest should be added to savingsBalance.
Provide a static method modifyInterestRate that sets the annualInterestRate to a new
value. Write a program to test class SavingsAccount. Instantiate two savingsAccount objects, saver1
and saver2, with balances of $2000.00 and $3000.00, respectively. Set annualInterestRate to 4%,
then calculate the monthly interest for each of 12 months and print the new balances for both
savers. Next, set the annualInterestRate to 5%, calculate the next month’s interest and print the
new balances for both savers.
*/


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class E6_SavingsAccount {
    public static void main(String[] args) {
        // Initialize both savers
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);

        // Change annualInterestRate
        SavingsAccount.modifyInterestRate(0.04); // 4%

        // Calc interest for 12 months
        for (int i = 0; i < 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }

        // Show balances
        System.out.printf("Balance after 12 months @ 4%% APR:%n\tsaver1: %s%n\tsaver2: %s%n",
                NumberFormat.getCurrencyInstance().format(saver1.getSavingsBalance()),
                NumberFormat.getCurrencyInstance().format(saver2.getSavingsBalance()));

        // Change annualInterestRate
        SavingsAccount.modifyInterestRate(0.05); // 5%

        // Calc interest for one month
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        // Show balances
        System.out.printf("%nBalance after 1 month @ 5%% APR:%n\tsaver1: %s%n\tsaver2: %s%n",
                NumberFormat.getCurrencyInstance().format(saver1.getSavingsBalance()),
                NumberFormat.getCurrencyInstance().format(saver2.getSavingsBalance()));
    }
}

class SavingsAccount {
    // Static attributes and methods
    public static BigDecimal annualInterestRate;

    public static void modifyInterestRate(double n) {
        annualInterestRate = BigDecimal.valueOf(n);
    }

    // Non-Static attributes and methods
    private BigDecimal savingsBalance;

    // Constructor
    public SavingsAccount() {
        savingsBalance = BigDecimal.ZERO;
    }

    public SavingsAccount(double balance) {
        savingsBalance = BigDecimal.valueOf(balance);
    }

    public SavingsAccount(BigDecimal balance) {
        savingsBalance = balance;
    }

    public void calculateMonthlyInterest() {
        if (annualInterestRate == null) {
            throw new NullPointerException("annualBalance was not initialized yet.");
        }
        savingsBalance = savingsBalance.add(savingsBalance.multiply(annualInterestRate.divide(
                BigDecimal.valueOf(12),6 , RoundingMode.HALF_EVEN)));
    }

    // Getter
    public BigDecimal getSavingsBalance() {
        return savingsBalance;
    }
}

