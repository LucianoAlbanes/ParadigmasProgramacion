package CAP7;

/*
(Invoice Class) Create a class called Invoice that a hardware store might use to represent
an invoice for an item sold at the store. An Invoice should include four pieces of information as
instance variables—a part number (type String), a part description (type String ), a quantity of the
item being purchased (type int) and a price per item (double). Your class should have a constructor
that initializes the four instance variables. Provide a set and a get method for each instance variable.
In addition, provide a method named getInvoiceAmount that calculates the invoice amount (i.e.,
multiplies the quantity by the price per item), then returns the amount as a double value. If the
quantity is not positive, it should be set to 0. If the price per item is not positive,
it should be set to 0.0. Write a test app that demonstrates class Invoice’s capabilities.
*/

public class E11_InvoiceClass {
    public static void main(String[] args) {
        // Case positive values
        Invoice inv1 = new Invoice("WASD2323", "Cheesecake", 2, 256);
        System.out.printf("Invoice 1:%n\tpartN: %s%n\tpartD: %s%n\tQnt: %d%n\tPrice: %s%n\tInv. Amnt.: %s%n",
                inv1.getPartNumber(), inv1.getPartDescription(), inv1.getQuantity(), inv1.getPricePerItem(),
                inv1.getInvoiceAmount());

        // Case negative quantity
        Invoice inv2 = new Invoice("QWERTY42", "Lemon Pie", -1, 128);
        System.out.printf("Invoice 2:%n\tpartN: %s%n\tpartD: %s%n\tQnt: %d%n\tPrice: %s%n\tInv. Amnt.: %s%n",
                inv2.getPartNumber(), inv2.getPartDescription(), inv2.getQuantity(), inv2.getPricePerItem(),
                inv2.getInvoiceAmount());

        // Case negative price
        Invoice inv3 = new Invoice("Foo65536", "Black Forest", 3, -273.15);
        System.out.printf("Invoice 3:%n\tpartN: %s%n\tpartD: %s%n\tQnt: %d%n\tPrice: %s%n\tInv. Amnt.: %s%n",
                inv3.getPartNumber(), inv3.getPartDescription(), inv3.getQuantity(), inv3.getPricePerItem(),
                inv3.getInvoiceAmount());

    }
}

class Invoice {
    // Attributes
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    // Constructor
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    // Getters and Setters
    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    // Methods
    public double getInvoiceAmount() {
        return (quantity < 0 || pricePerItem < 0) ? 0 : quantity * pricePerItem;
    }
}