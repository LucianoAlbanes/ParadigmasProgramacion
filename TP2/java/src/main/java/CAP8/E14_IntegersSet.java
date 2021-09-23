package CAP8;

/*
Provide the following methods:
The static method union creates a set that’s the set-theoretic union of two existing sets
(i.e., an element of the new set’s array is set to true if that element is true in either or
both of the existing sets—otherwise, the new set’s element is set to false).
The static method intersection creates a set which is the set-theoretic intersection of two existing sets
(i.e., an element of the new set’s array is set to false if that element is false in either or both of the
existing sets—otherwise, the new set’s element is set to true).
Method insertElement inserts a new integer k into a set (by setting a[k] to true).
Method deleteElement deletes integer m (by setting a[m] to false).
Method toString returns a String containing a set as a list of numbers separated by spaces. Include only
those elements that are present in the set. Use --- to represent an empty set.
Method isEqualTo determines whether two sets are equal. Write a program to test class IntegerSet.
Instantiate several IntegerSet objects. Test that all your methods work properly.
*/

public class E14_IntegersSet {
    public static void main(String[] args) {
        // Initialize three sets
        IntegerSet set1 = new IntegerSet(5);
        IntegerSet set2 = new IntegerSet(3);
        IntegerSet set3 = new IntegerSet(3);
        IntegerSet set4 = new IntegerSet(0);

        set1.insertElement(0);
        set1.insertElement(2);
        set1.insertElement(4);

        set2.insertElement(0);
        set2.insertElement(1);
        set2.insertElement(2);

        set3.insertElement(0);
        set3.insertElement(1);
        set3.insertElement(2);

        // Print sets
        System.out.printf("set1 = %s%n", set1);
        System.out.printf("set2 = %s%n", set2);
        System.out.printf("set3 = %s%n", set3);
        System.out.printf("set4 = %s%n", set4);

        // Show union, intersection, equals and removeElement.
        System.out.printf("Union set1-set2: %s%n", IntegerSet.union(set1, set2));
        System.out.printf("Intersection set1-set2: %s%n", IntegerSet.intersection(set1, set2));
        System.out.printf("Intersection set1-set4: %s%n", IntegerSet.intersection(set1, set4));
        System.out.printf("Are set1-set3 equal: %s%n", set1.isEqualTo(set3));
        System.out.printf("Are set2-set3 equal: %s%n", set2.isEqualTo(set3));
        System.out.printf("Removing element set3[0]...%n");
        set3.deleteElement(0);
        System.out.printf("Are set2-set3 equal: %s%n", set2.isEqualTo(set3));

    }

}

class IntegerSet {
    // Attributes
    private final boolean[] data;

    // Constructor
    public IntegerSet(int size) {
        data = new boolean[size];
    }

    // Union
    public IntegerSet union(IntegerSet setB) {
        return union(this, setB);
    }

    public static IntegerSet union(IntegerSet setA, IntegerSet setB) {
        // Find bigger set
        IntegerSet high;
        IntegerSet low;
        if (setA.data.length > setB.data.length) {
            high = setA;
            low = setB;
        } else {
            high = setB;
            low = setA;
        }

        // Create the new set with the size of the bigger parameter set.
        IntegerSet setUnion = new IntegerSet(high.data.length);

        // Find the union and fill
        // Both
        for (int i = 0; i < low.data.length; i++) {
            if (setA.data[i] || setB.data[i]) {
                setUnion.data[i] = true;
            }
        }
        // Remaining from bigger set
        for (int i = low.data.length; i < high.data.length; i++) {
            if (high.data[i]) {
                setUnion.data[i] = true;
            }
        }

        // Return resultant setUnion
        return setUnion;
    }

    // Intersection
    public IntegerSet intersection(IntegerSet setB) {
        return intersection(this, setB);
    }

    public static IntegerSet intersection(IntegerSet setA, IntegerSet setB) {
        // Find bigger set
        IntegerSet high;
        IntegerSet low;
        if (setA.data.length > setB.data.length) {
            high = setA;
            low = setB;
        } else {
            high = setB;
            low = setA;
        }

        // Create the new set with the size of the bigger parameter set.
        IntegerSet setIntersection = new IntegerSet(high.data.length);

        // Find the intersection and fill
        // Both
        for (int i = 0; i < low.data.length; i++) {
            if (setA.data[i] && setB.data[i]) {
                setIntersection.data[i] = true;
            }
        }
        // Remaining from bigger set
        for (int i = low.data.length; i < high.data.length; i++) {
            setIntersection.data[i] = false;
        }

        // Return resultant setIntersection
        return setIntersection;
    }

    // Manipulation methods
    public void insertElement(int k) {
        try {
            data[k] = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteElement(int k) {
        try {
            data[k] = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Overridden and others methods
    public String toString() {
        // Initialize String txt
        String txt = "";

        // Find values
        for (int i = 0; i < data.length; i++) {
            if (data[i]) {
                txt = txt.concat(i + " ");
            }
        }

        // Final string formatting
        if (txt.length() == 0) {
            // Empty set
            txt = txt.concat("-");
        } else {
            // Remove extra space
            txt = txt.concat("\b");
        }

        // Return the final txt
        return txt;
    }

    public boolean isEqualTo(IntegerSet setB) {
        // Both sets are equals until proven otherwise
        boolean isEqualTo = true;

        // Find bigger set
        IntegerSet high;
        IntegerSet low;
        if (this.data.length > setB.data.length) {
            high = this;
            low = setB;
        } else {
            high = setB;
            low = this;
        }

        // Check equality
        // Both
        for (int i = 0; i < low.data.length; i++) {
            if (this.data[i] != setB.data[i]) {
                isEqualTo = false;
                break;
            }
        }
        // Remaining from bigger set can't contain a true value
        if (isEqualTo) {
            for (int i = low.data.length; i < high.data.length; i++) {
                if (high.data[i]) {
                    isEqualTo = false;
                    break;
                }
            }
        }

        // Return if both are equal.
        return isEqualTo;
    }
}
