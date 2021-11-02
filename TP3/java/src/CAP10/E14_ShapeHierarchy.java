package CAP10;

public class E14_ShapeHierarchy {
    public static void main(String[] args) {
        // Creating and array of Shapes
        Shape[] shapes = new Shape[6];
        shapes[0] = new Circle(10);
        shapes[1] = new Square(4);
        shapes[2] = new Triangle(4, 5, 6);
        shapes[3] = new Sphere(1);
        shapes[4] = new Cube(3);
        shapes[5] = new Tetrahedron(3);

        // Printing using instanceof
        for (Shape shape : shapes) {
            if (shape instanceof TwoDimensionalShape) {
                // Downcast Shape to TwoDimensionalShape
                System.out.printf("(TwoDimensionalShape) %s. Area: %.2f u²%n",
                        shape.getClass().getSimpleName(), ((TwoDimensionalShape) shape).getArea());
            } else if (shape instanceof ThreeDimensionalShape) {
                System.out.printf("(ThreeDimensionalShape) %s. Area: %.2f u², Volume: %.2f u³%n",
                        shape.getClass().getSimpleName(), ((ThreeDimensionalShape) shape).getArea(),
                        ((ThreeDimensionalShape) shape).getVolume());
            }
        }
    }
}


// Abstract classes
abstract class Shape {
}

abstract class TwoDimensionalShape extends Shape {
    public abstract double getArea();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":\n"
                + "\tArea: " + String.format("%.2f", getArea());
    }
}

abstract class ThreeDimensionalShape extends Shape {
    public abstract double getArea();

    public abstract double getVolume();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":\n"
                + "\tArea: " + getArea() + "\n"
                + "\tVolume: " + getVolume();
    }
}

// Concrete classes implementation
// TwoDimensionalShape
class Circle extends TwoDimensionalShape {
    // Attributes
    private double radius;

    // Constructor
    public Circle(double radius) throws IllegalArgumentException {
        setRadius(radius); // Throws
    }

    // Methods
    public void setRadius(double radius) throws IllegalArgumentException {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Radius must be grater than 0");
        }
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "\tRadius: " + String.format("%.2f", radius);
    }
}

class Square extends TwoDimensionalShape {
    // Attributes
    private double sideLength;

    // Constructor
    public Square(double sideLength) throws IllegalArgumentException {
        setSideLength(sideLength); // Throws
    }

    // Methods
    public void setSideLength(double sideLength) throws IllegalArgumentException {
        if (sideLength > 0) {
            this.sideLength = sideLength;
        } else {
            throw new IllegalArgumentException("Side length must be grater than 0");
        }
    }

    @Override
    public double getArea() {
        return Math.pow(sideLength, 2);
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "\tSide length: " + String.format("%.2f", sideLength);
    }
}

class Triangle extends TwoDimensionalShape {
    // Attributes
    private final double[] sidesLength = new double[3];

    // Constructor
    public Triangle(double sideA, double sideB, double sideC)
            throws IllegalArgumentException, ArithmeticException {
        setSideLength(sideA, sideB, sideC); // Throws
    }

    // Methods
    public void setSideLength(double sideA, double sideB, double sideC)
            throws IllegalArgumentException, ArithmeticException {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("Sides must be greater than 0.");
        } else if (!(sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA)) {
            // Triangle Inequality Theorem
            throw new ArithmeticException("Sides can't make a valid triangle.");
        } else {
            sidesLength[0] = sideA;
            sidesLength[1] = sideB;
            sidesLength[2] = sideC;
        }
    }

    @Override
    public double getArea() {
        // Uses Heron's Formula
        double s = (sidesLength[0] + sidesLength[1] + sidesLength[2]) / 2;
        double residing = s * (s - sidesLength[0]) * (s - sidesLength[1]) * (s - sidesLength[2]);
        return Math.sqrt(residing);
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "\tSides length: " + String.format("%.2f, %.2f, %.2f", sidesLength[0],
                sidesLength[1], sidesLength[2]);
    }
}

// ThreeDimensionalShape
class Sphere extends ThreeDimensionalShape {
    // Attributes
    private double radius;

    // Constructor
    public Sphere(double radius) throws IllegalArgumentException {
        setRadius(radius); // Throws
    }

    // Methods
    public void setRadius(double radius) throws IllegalArgumentException {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Radius must be grater than 0");
        }
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getVolume() {
        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "\tRadius: " + String.format("%.2f", radius);
    }
}

class Cube extends ThreeDimensionalShape {
    // Attributes
    private double sideLength;

    // Constructor
    public Cube(double sideLength) throws IllegalArgumentException {
        setSideLength(sideLength); // Throws
    }

    // Methods
    public void setSideLength(double sideLength) throws IllegalArgumentException {
        if (sideLength > 0) {
            this.sideLength = sideLength;
        } else {
            throw new IllegalArgumentException("Side length must be grater than 0");
        }
    }

    @Override
    public double getArea() {
        return 6 * Math.pow(sideLength, 2);
    }

    @Override
    public double getVolume() {
        return Math.pow(sideLength, 3);
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "\tSide length: " + String.format("%.2f", sideLength);
    }
}

class Tetrahedron extends ThreeDimensionalShape {
    // Attributes
    private double sideLength;

    // Constructor
    public Tetrahedron(double sideLength) throws IllegalArgumentException {
        setSideLength(sideLength); // Throws
    }

    // Methods
    public void setSideLength(double sideLength) throws IllegalArgumentException {
        if (sideLength > 0) {
            this.sideLength = sideLength;
        } else {
            throw new IllegalArgumentException("Side length must be grater than 0");
        }
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) * Math.pow(sideLength, 2);
    }

    @Override
    public double getVolume() {
        return Math.pow(sideLength, 3) / (6 * Math.sqrt(2));
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "\tSide length: " + String.format("%.2f", sideLength);
    }
}
