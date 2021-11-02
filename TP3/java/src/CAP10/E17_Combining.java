package CAP10;

interface CompensationModel {
    double earnings();
}

public class E17_Combining {
    public static void main(String[] args) {
        // Create employees
        Employee e1 = new Employee("Luciano", "Albanes", "12123434",
                new CommissionCompensationModel(200, 0.15));
        Employee e2 = new Employee("Juan", "Carlos", "98987676",
                new BasePlusCommissionCompensationModel(16, 150, 0.1));
        Employee e3 = new Employee("Lucas", "Alonso", "12345678",
                new SalariedCompensationModel(25.5));
        Employee e4 = new Employee("Pedro", "Rodriguez", "69402420",
                new HourlyCompensationModel(0.45, 60));

        // Print earnings
        System.out.printf("E1 (Sales: 200, Rate: 0.15): %.2f%nE2 (Base: 16, Sales: 150, Rate: 0.1): %.2f%n" +
                        "E3 (WeeklySalary: 25.5): %.2f%nE4 (Wage: 0.45, Hours: 60): %.2f%n",
                e1.earnings(), e2.earnings(), e3.earnings(), e4.earnings());

        // Change Compensation model
        System.out.printf("%nChanging Compensation Models for Employees%n");

        e1.setCompensationModel(new BasePlusCommissionCompensationModel(5, 50, 0.1));
        e2.setCompensationModel(new CommissionCompensationModel(70, 0.16));
        e3.setCompensationModel(new HourlyCompensationModel(0.45, 60));
        e4.setCompensationModel(new SalariedCompensationModel(25.5));

        // Print both earnings
        System.out.printf("E1 (Base: 5, Sales: 50, Rate: 0.1): %.2f%nE2 (Sales: 70, Rate: 0.16): %.2f%n" +
                        "E3 (Wage: 0.45, Hours: 60): %.2f%nE4 (WeeklySalary: 25.5): %.2f%n",
                e1.earnings(), e2.earnings(), e3.earnings(), e4.earnings());
    }
}

// Compensation models

class Employee {
    // Attributes
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private CompensationModel compensationModel;

    // Constructor
    public Employee(String firstName, String lastName, String socialSecurityNumber, CompensationModel compensationModel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        setCompensationModel(compensationModel);
    }

    // Methods
    public void setCompensationModel(CompensationModel compensationModel) {
        this.compensationModel = compensationModel;
    }

    public double earnings() {
        return compensationModel.earnings();
    }
}

class SalariedCompensationModel implements CompensationModel {
    // Attributes
    private double weeklySalary;

    // Constructor
    public SalariedCompensationModel(double weeklySalary) throws IllegalArgumentException {
        setWeeklySalary(weeklySalary);
    }

    // Methods
    public void setWeeklySalary(double weeklySalary) throws IllegalArgumentException {
        if (weeklySalary > 0) {
            this.weeklySalary = weeklySalary;
        } else {
            throw new IllegalArgumentException("Weekly must be greater than 0.");
        }
    }

    public double earnings() {
        return weeklySalary;
    }
}

class HourlyCompensationModel implements CompensationModel {
    // Attributes
    private double wage;
    private double hours;

    // Constructor
    public HourlyCompensationModel(double wage, double hours) throws IllegalArgumentException {
        setWage(wage);
        setHours(hours);
    }

    // Methods
    public void setWage(double wage) throws IllegalArgumentException {
        if (wage > 0) {
            this.wage = wage;
        } else {
            throw new IllegalArgumentException("Wage must be greater than 0.");
        }
    }

    public void setHours(double hours) throws IllegalArgumentException {
        if (hours < 0) {
            throw new IllegalArgumentException("Hours must be greater than 0.");
        } else if (hours > 168) {
            throw new IllegalArgumentException("Hours must be <= 168");
        } else {
            this.hours = hours;
        }
    }

    public double earnings() {
        if (hours <= 40) { // no overtime
            return wage * hours;
        } else {
            return 40 * wage + (hours - 40) * wage * 1.5;
        }
    }
}

class CommissionCompensationModel implements CompensationModel {
    // Attributes
    private int grossSales;
    private double commissionRate;

    // Constructor
    public CommissionCompensationModel(int grossSales, double commissionRate) throws IllegalArgumentException {
        setGrossSales(grossSales);
        setCommissionRate(commissionRate);
    }

    // Methods
    public void setGrossSales(int grossSales) throws IllegalArgumentException {
        if (grossSales >= 0) {
            this.grossSales = grossSales;
        } else {
            throw new IllegalArgumentException("Gross sales can't be negative.");
        }
    }

    public void setCommissionRate(double commissionRate) throws IllegalArgumentException {
        if (commissionRate > 0) {
            this.commissionRate = commissionRate;
        } else {
            throw new IllegalArgumentException("Commission rate must be greater than 0.");
        }
    }

    public double earnings() {
        return grossSales * commissionRate;
    }
}

class BasePlusCommissionCompensationModel implements CompensationModel {
    // Attributes
    private double baseSalary;
    private int grossSales;
    private double commissionRate;

    // Constructor
    public BasePlusCommissionCompensationModel(double baseSalary, int grossSales, double commissionRate)
            throws IllegalArgumentException {
        setBaseSalary(baseSalary);
        setGrossSales(grossSales);
        setCommissionRate(commissionRate);
    }

    // Methods
    public void setBaseSalary(double baseSalary) throws IllegalArgumentException {
        if (baseSalary > 0) {
            this.baseSalary = baseSalary;
        } else {
            throw new IllegalArgumentException("Base salary must be greater than 0.");
        }
    }

    public void setGrossSales(int grossSales) throws IllegalArgumentException {
        if (grossSales >= 0) {
            this.grossSales = grossSales;
        } else {
            throw new IllegalArgumentException("Gross sales can't be negative.");
        }
    }

    public void setCommissionRate(double commissionRate) throws IllegalArgumentException {
        if (commissionRate > 0) {
            this.commissionRate = commissionRate;
        } else {
            throw new IllegalArgumentException("Commission rate must be greater than 0.");
        }
    }

    public double earnings() {
        return baseSalary + grossSales * commissionRate;
    }
}