package TP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class FamilyTree {
    public static void main(String[] args) {
        //// HARDCODED FAMILY TREE (as in haskell and prolog)
        Person[] family = new Person[20];
        family[0] = new Person("alice", "woman");
        family[1] = new Person("sara", "woman");
        family[2] = new Person("danna", "woman");
        family[3] = new Person("anne", "woman");
        family[4] = new Person("child2W", "woman");
        family[5] = new Person("child5W", "woman");
        family[6] = new Person("child8W", "woman");
        family[7] = new Person("child10W", "woman");


        family[8] = new Person("bob", "male");
        family[9] = new Person("cristian", "male");
        family[10] = new Person("donald", "male");
        family[11] = new Person("andrew", "male");
        family[12] = new Person("george", "male");
        family[13] = new Person("child1M", "male");
        family[14] = new Person("child4M", "male");
        family[15] = new Person("child7M", "male");
        family[16] = new Person("child9M", "male");
        family[17] = new Person("child3M", "male");
        family[18] = new Person("child6M", "male");
        family[19] = new Person("child11M", "male");

        //// Make Child-Parent relations
        // Family root
        makeRelationParentChild(family[0], family[9]);
        makeRelationParentChild(family[0], family[1]);
        makeRelationParentChild(family[8], family[9]);
        makeRelationParentChild(family[8], family[1]);

        // Family 0
        makeRelationParentChild(family[9], family[13]);
        makeRelationParentChild(family[9], family[4]);
        makeRelationParentChild(family[9], family[17]);
        makeRelationParentChild(family[2], family[13]);
        makeRelationParentChild(family[2], family[4]);
        makeRelationParentChild(family[2], family[17]);

        // Family 1
        makeRelationParentChild(family[10], family[14]);
        makeRelationParentChild(family[10], family[5]);
        makeRelationParentChild(family[10], family[18]);
        makeRelationParentChild(family[1], family[14]);
        makeRelationParentChild(family[1], family[5]);
        makeRelationParentChild(family[1], family[18]);

        // Family 2
        makeRelationParentChild(family[12], family[15]);
        makeRelationParentChild(family[12], family[6]);
        makeRelationParentChild(family[11], family[15]);
        makeRelationParentChild(family[11], family[6]);

        // Family 3
        makeRelationParentChild(family[3], family[16]);
        makeRelationParentChild(family[3], family[7]);
        makeRelationParentChild(family[3], family[19]);

        //// Precalculate all siblings and cousins
        for (Person person : family) {
            person.updateSiblings();
        }
        for (Person person : family) {
            person.updateCousins();
        }


        //// SOME HARDCODED QUERIES
        System.out.println("Sara's Parents: " + Arrays.toString(namesList(family[1].getParents())));
        System.out.println("Sara's Mother: " + Arrays.toString(namesList(filterByGender(family[1].getParents(), "woman"))));
        System.out.println("Sara's Father: " + Arrays.toString(namesList(filterByGender(family[1].getParents(), "male"))));
        System.out.println("Sara's Siblings: " + Arrays.toString(namesList(family[1].getSiblings())));
        System.out.println("Sara's Children: " + Arrays.toString(namesList(family[1].getChildren())));
        System.out.printf("%n");

        System.out.println("child1W's Parents: " + Arrays.toString(namesList(family[13].getParents())));
        System.out.println("child1W's Siblings: " + Arrays.toString(namesList(family[13].getSiblings())));
        System.out.println("child1W's Sisters: " + Arrays.toString(namesList(filterByGender(family[13].getSiblings(), "woman"))));
        System.out.println("child1W's Brothers: " + Arrays.toString(namesList(filterByGender(family[13].getSiblings(), "male"))));
        System.out.println("child1W's Cousins: " + Arrays.toString(namesList(family[13].getCousins())));
    }


    //// Useful functions
    // Make a Parent-Child relation.
    public static void makeRelationParentChild(Person parent, Person child) {
        /*
         * @parent The person object to be assigned as a parent of a child
         * @child The child object to be assigned as a child of a parent
         * !! This function doesn't verify if the persons are already related as Parent-Child
         */
        parent.addChild(child);
        child.addParent(parent);
    }

    // Gender filter.
    public static ArrayList<Person> filterByGender(ArrayList<Person> peopleArray, String gender) {
        ArrayList<Person> filteredArray = new ArrayList<>();
        for (Person person : peopleArray) {
            if (Objects.equals(person.getGender(), gender)) {
                filteredArray.add(person);
            }
        }
        return filteredArray;
    }

    // Create a list of names from an ArrayList of Persons.
    public static String[] namesList(ArrayList<Person> peopleArray) {
        String[] names = new String[peopleArray.size()];
        for (int i = 0; i < peopleArray.size(); i++) {
            names[i] = peopleArray.get(i).getName();
        }
        return names;
    }

}

class Person {
    //// Private variables
    private String name;
    private String gender;
    private ArrayList<Person> parents = new ArrayList<>();
    private ArrayList<Person> children = new ArrayList<>();
    private ArrayList<Person> siblings = new ArrayList<>();
    private ArrayList<Person> cousins = new ArrayList<>();

    // Constructor
    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    //// Gets and sets
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<Person> getParents() {
        return parents;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public ArrayList<Person> getSiblings() {
        return siblings;
    }

    public ArrayList<Person> getCousins() {
        return cousins;
    }

    //// Relationship functions
    public void addChild(Person newChild) {
        children.add(newChild);
    }

    public void addParent(Person newParent) {
        parents.add(newParent);
    }

    //// Find and update relationships
    public void updateSiblings() {
        /*
         * This method will find all the siblings of the person, reading all the children of his parents.
         */
        for (Person actualParent : parents) {
            for (Person actualChild : actualParent.getChildren()) {
                if (actualChild != this && !siblings.contains(actualChild)) {
                    siblings.add(actualChild);
                }
            }
        }
    }

    public void updateCousins() {
        /*
         * This method will find all the person's cousins, reading all the children of their parents' siblings.
         */
        for (Person actualParent : parents) {
            for (Person actualUncle : actualParent.getSiblings()) {
                for (Person actualCousin : actualUncle.getChildren()) {
                    if (!cousins.contains(actualCousin)) {
                        cousins.add(actualCousin);
                    }
                }
            }
        }
    }
}