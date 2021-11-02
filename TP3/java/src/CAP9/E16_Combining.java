package CAP9;

public class E16_Combining {
    public static void main(String[] args) {
        // Create two employees
        Employee e1 = new Employee("Luciano", "Albanes", "12123434",
                new CommissionCompensationModel(200, 0.15));
        Employee e2 = new Employee("Juan", "Carlos", "98987676",
                new BasePlusCommissionCompensationModel(16, 150, 0.1));

        // Print both earnings
        System.out.printf("E1 (Sales: 200, Rate: 0.15): %.2f%nE2 (Base: 16, Sales: 150, Rate: 0.1): %.2f%n",
                e1.earnings(), e2.earnings());

        // Change Compensation model
        System.out.printf("%nChanging Compensation Models for both Employees%n");

        e1.setCompensationModel(new BasePlusCommissionCompensationModel(5, 50, 0.1));
        e2.setCompensationModel(new CommissionCompensationModel(70, 0.16));

        // Print both earnings
        System.out.printf("E1 (Base: 5, Sales: 50, Rate: 0.1): %.2f%nE2 (Sales: 70, Rate: 0.16): %.2f%n",
                e1.earnings(), e2.earnings());
    }
}

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

class CompensationModel {
    public double earnings() {
        return 0;
    }
}

class CommissionCompensationModel extends CompensationModel {
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

class BasePlusCommissionCompensationModel extends CompensationModel {
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