package CAP8;

/*
(Cylinder Class) Create a class Cylinder with attributes radius and height, each of
which has a default value of 1. Provide a method that calculates the cylinders’ volume, which
is pi multiplied by the square of the radius multiplied by the height. It has set and get meth-
ods for both radius and height. The set method should verify that radius and height are positive
numbers. Write a program to test class Cylinder.
*/

import java.util.Scanner;

public class E4_Cylinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Cylinder c1 = new Cylinder();

        // Radius
        System.out.print("Insert the radius of the cylinder: ");
        try {
            c1.setRadius(input.nextDouble());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Height
        System.out.print("Insert the height of the cylinder: ");
        try {
            c1.setHeight(input.nextDouble());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Print volume
        System.out.printf("The volume of the cylinder is: %.2f.%n", c1.volume());

    }
}

class Cylinder {
    private double radius = 1;
    private double height = 1;

    // Setters and getters
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException(
                    "The specified height (" + height + ") is negative. Must be a non-negative number.");
        }
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException(
                    "The specified radius (" + radius + ") is negative. Must be a non-negative number.");
        }
        this.radius = radius;
    }

    // Methods
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}

