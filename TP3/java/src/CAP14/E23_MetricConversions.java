package CAP14;

import java.util.HashMap;
import java.util.Scanner;

public class E23_MetricConversions {
    public static void main(String[] args) {
        // Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert a phrase (Order of values: toUnit fromUnit Qnt): ");
        String userInput = scanner.nextLine();

        // Prepare input
        userInput = userInput.trim().replaceAll("[^a-zA-Z0-9 ']", "");
        String[] words = userInput.split(" ");

        // Analyze each word
        double qnt = 1; // 1 as default
        String[] units = new String[2];

        for (String word : words) {
            // Check if is number
            if (isNumeric(word)) {
                qnt = Double.parseDouble(word);
            } else {
                // Prepare for matches
                word = word.toLowerCase(); // lower case
                if (!word.endsWith("s")) { // make plural
                    word = word + "s";
                }
                // Check if the word is a unit key
                if (Converter.getUnit(word) != null) {
                    if (units[0] == null) {
                        units[0] = word;
                    } else {
                        units[1] = word;
                        break; // All data needed was obtained.
                    }
                }
            }
        }

        // Try to do the conversion
        try {
            double result = Converter.convert(qnt, units[1], units[0]);
            System.out.printf("%n%.4f %s equals %.4f %s.%n", qnt, units[1], result, units[0]);
        } catch (Exception e) {
            System.err.printf("%nError: ");
            e.printStackTrace();
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

class Converter {
    public static Unit getUnit(String key) {
        // Define a HashMap with all units
        HashMap<String, Unit> unitsHashMap = new HashMap<>();

        // Length units
        unitsHashMap.put("millimeters", new LengthUnit(1000.));
        unitsHashMap.put("centimeters", new LengthUnit(100.));
        unitsHashMap.put("decimeters", new LengthUnit(10.));
        unitsHashMap.put("meters", new LengthUnit(1.)); // Main length unit
        unitsHashMap.put("decameters", new LengthUnit(.1));
        unitsHashMap.put("hectometers", new LengthUnit(.01));
        unitsHashMap.put("kilometers", new LengthUnit(.001));

        unitsHashMap.put("inches", new LengthUnit(39.3701));
        unitsHashMap.put("feets", new LengthUnit(3.28084));
        unitsHashMap.put("yards", new LengthUnit(1.09361));
        unitsHashMap.put("miles", new LengthUnit(0.000621371));

        // Capacity units (US)
        unitsHashMap.put("milliliters", new CapacityUnit(1000.));
        unitsHashMap.put("centiliters", new CapacityUnit(100.));
        unitsHashMap.put("deciliters", new CapacityUnit(10.));
        unitsHashMap.put("liters", new CapacityUnit(1.)); // Main capacity unit
        unitsHashMap.put("decaliters", new CapacityUnit(.1));
        unitsHashMap.put("hectoliters", new CapacityUnit(.01));
        unitsHashMap.put("kiloliters", new CapacityUnit(.001));

        unitsHashMap.put("founces", new CapacityUnit(33.814));
        unitsHashMap.put("gills", new CapacityUnit(8.45351));
        unitsHashMap.put("pints", new CapacityUnit(2.11338));
        unitsHashMap.put("quarts", new CapacityUnit(1.05669));
        unitsHashMap.put("gallons", new CapacityUnit(0.264172));

        // Weight units
        unitsHashMap.put("milligrams", new WeightUnit(1000.));
        unitsHashMap.put("centigrams", new WeightUnit(100.));
        unitsHashMap.put("decigrams", new WeightUnit(10.));
        unitsHashMap.put("grams", new WeightUnit(1.)); // Main weight unit
        unitsHashMap.put("decagrams", new WeightUnit(.1));
        unitsHashMap.put("hectograms", new WeightUnit(.01));
        unitsHashMap.put("kilograms", new WeightUnit(.001));

        unitsHashMap.put("tons", new WeightUnit(0.000001));
        unitsHashMap.put("ounces", new WeightUnit(0.035274));
        unitsHashMap.put("pounds", new WeightUnit(0.00220462));

        // Get and return value
        return unitsHashMap.get(key);
    }

    public static double convert(double qnt, String fromUnit, String toUnit)
            throws IllegalArgumentException {
        // Get both units factor
        Unit fromUnitObj = getUnit(fromUnit);
        Unit toUnitObj = getUnit(toUnit);

        // Check for exceptions.
        if (fromUnitObj == null) {
            throw new IllegalArgumentException("fromUnit \"" + fromUnit + "\" wasn't recognized. Retry using plurals.");
        }
        if (toUnitObj == null) {
            throw new IllegalArgumentException("toUnit \"" + toUnit + "\" wasn't recognized. Retry using plurals.");
        }
        if (fromUnitObj.getClass() != toUnitObj.getClass()) {
            throw new IllegalArgumentException("Invalid conversions.");
        }

        // Do and return the conversion
        return (qnt / fromUnitObj.getFactor()) * toUnitObj.getFactor();
    }
}

// Define classes for store different types of units
abstract class Unit {
    private final double factor;

    public Unit(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }
}

class LengthUnit extends Unit {
    public LengthUnit(double factor) {
        super(factor);
    }
}

class CapacityUnit extends Unit {
    public CapacityUnit(double factor) {
        super(factor);
    }
}

class WeightUnit extends Unit {
    public WeightUnit(double factor) {
        super(factor);
    }
}