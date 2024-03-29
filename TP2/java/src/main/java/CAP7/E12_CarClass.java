package CAP7;

/*
(Car Class) Create a class called Car that includes three instance variables—a model (type String),
a year (type String), and a price (double). Provide a constructor that initializes the three
instance variables. Provide a set and a get method for each instance variable. If the price is not positive,
do not set its value. Write a test application named CarApplication that demonstrates class Car’s
capabilities. Create two Car objects and display each object’s price. Then apply a 5% discount on the
price of the first car and a 7% discount on the price of the second. Display each Car’s price again.
*/

public class E12_CarClass {
    public static void main(String[] args) {
        // Create two cars and print attributes.
        Car car1 = new Car("Gol", "2021", 15000);
        System.out.printf("Car 1:%n\tmodel: %s%n\tyear: %s%n\tprice: %.2f%n",
                car1.getModel(), car1.getYear(), car1.getPrice());

        Car car2 = new Car("Corolla", "2019", 13250);
        System.out.printf("Car 2:%n\tmodel: %s%n\tyear: %s%n\tprice: %.2f%n",
                car2.getModel(), car2.getYear(), car2.getPrice());

        // Apply discounts
        car1.setPrice(car1.getPrice()*0.95);
        car2.setPrice(car2.getPrice()*0.93);
        System.out.printf("%nPrices after discounts:%n\tCar 1 (5%% Discount): %.2f%n\tCar 2 (7%% Discount): %.2f%n", car1.getPrice(), car2.getPrice());
    }
}

class Car {
    // Attributes
    private String model;
    private String year;
    private double price;

    // Constructor
    public Car(String model, String year, double price) {
        this.model = model;
        this.year = year;
        setPrice(price);
    }

    // Getters and Setters
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // Price must be positive.
        if (price > 0) {
            this.price = price;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}