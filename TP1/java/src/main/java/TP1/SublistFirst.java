package TP1;

import java.util.ArrayList;

public class SublistFirst {
    public static void main(String[] args) {
        // Generate an ArrayList with some data
        ArrayList<Object> list = new ArrayList<>();
        list.add(42);           //0
        list.add("Java");       //1
        list.add(true);         //2
        list.add(3.14);         //3
        list.add("\\");         //4

        // Print the original list
        System.out.println(list);

        // Remove the first element of the list
        list.remove(0);

        // Print the resulting list
        System.out.println(list);
    }
}
