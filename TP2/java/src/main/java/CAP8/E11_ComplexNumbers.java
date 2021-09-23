package CAP8;

/*
(Complex Numbers) Create a class called Complex for performing arithmetic with complex
numbers. Complex numbers have the form
    realPart + imaginaryPart * i
where i is = sqrt(-1)
Write a program to test your class. Use floating-point variables to represent the private data of the
class. Provide a constructor that enables an object of this class to be initialized when it’s declared.
Provide a no-argument constructor with default values in case no initializers are provided. Provide
public methods that perform the following operations:
    a) Add two Complex numbers: The real parts are added together and the imaginary parts
    are added together.
    b) Subtract two Complex numbers: The real part of the right operand is subtracted from
    the real part of the left operand, and the imaginary part of the right operand is subtracted
    from the imaginary part of the left operand.
    c) Print Complex numbers in the form (realPart, imaginaryPart).
*/

public class E11_ComplexNumbers {
    public static void main(String[] args) {
        Complex z1 = new Complex(1,2);
        Complex z2 = new Complex(3,5);
        Complex z3 = new Complex(3);
        System.out.printf("z1: %s%nz2: %s%nz3: %s%n", z1, z2, z3);

        // Some ops
        System.out.printf("%nz1 + z2 = %s%n", z1.add(z2).toString());
        System.out.printf("z2 - z1 = %s%n", z2.subtract(z1).toString());
        System.out.printf("z2 - z3 = %s%n", z2.subtract(z3).toString());
    }
}

class Complex {
    // Attributes
    private double realPart;
    private double imaginaryPart;

    // Constructor
    public Complex() {
        this(0,0);
    }

    public Complex(double realPart) {
        this(realPart,0);
    }

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    // Methods
    public Complex add(Complex augend) {
        double newRealPart = this.realPart + augend.realPart;
        double newImaginaryPart = this.imaginaryPart + augend.imaginaryPart;
        return new Complex(newRealPart, newImaginaryPart);
    }

    public Complex subtract(Complex subtrahend) {
        double newRealPart = this.realPart - subtrahend.realPart;
        double newImaginaryPart = this.imaginaryPart - subtrahend.imaginaryPart;
        return new Complex(newRealPart, newImaginaryPart);
    }

    @Override
    public String toString() {
        return "(" + realPart + ", " + imaginaryPart +')';
    }
}