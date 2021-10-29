package Veterinary;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author lwittgenstein
 */

public class Veterinary {
    public static void main(String[] args) {
        // Create pets
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();

        // Create a vet, and set listeners to each pet.
        Vet vet1 = new Vet();
        cat1.addPropertyChangeListener(new PetPropertyChangeListener(vet1));
        cat2.addPropertyChangeListener(new PetPropertyChangeListener(vet1));
        dog1.addPropertyChangeListener(new PetPropertyChangeListener(vet1));
        dog2.addPropertyChangeListener(new PetPropertyChangeListener(vet1));
        dog3.addPropertyChangeListener(new PetPropertyChangeListener(vet1));

        // Change some proprieties to fire listeners
        cat1.setEnergyLevel(10);
        cat1.setEnergyLevel(20);
        cat1.setState(Pet.STATES.AWAKE);
        cat1.setState(Pet.STATES.PLAYING);
        cat1.setEnergyLevel(-5);
        cat1.setState(Pet.STATES.SLEEP);

        dog1.setEnergyLevel(10);
        dog1.setEnergyLevel(20);
        dog1.setState(Pet.STATES.AWAKE);
        dog1.setState(Pet.STATES.PLAYING);
        dog1.setEnergyLevel(-5);
        dog1.setState(Pet.STATES.SLEEP);

        cat2.setState(Pet.STATES.AWAKE);
        cat2.setEnergyLevel(12);
        cat2.setState(Pet.STATES.SLEEP);

        dog2.setState(Pet.STATES.PLAYING);
        dog2.setEnergyLevel(16);
        dog2.setState(Pet.STATES.AWAKE);
        dog2.setEnergyLevel(10);
        dog2.setState(Pet.STATES.SLEEP);

        dog3.setState(Pet.STATES.AWAKE);
        dog3.setEnergyLevel(10);
        dog3.setEnergyLevel(15);
        dog3.setState(Pet.STATES.PLAYING);
        dog3.setEnergyLevel(-2);
        dog3.setState(Pet.STATES.SLEEP);

        // Print the report of the vet. Includes all pets.
        vet1.printReport();
    }
}

abstract class Pet {
    private final PropertyChangeSupport support;
    // Attributes
    private STATES state;
    private int energyLevel;
    // Constructors (Overloaded)
    public Pet() {
        this(STATES.SLEEP, 0);
    }

    public Pet(STATES state) {
        this(state, 0);
    }

    public Pet(int energyLevel) {
        this(STATES.SLEEP, energyLevel);
    }

    public Pet(STATES state, int energyLevel) {
        this.state = state;
        this.energyLevel = energyLevel;
        support = new PropertyChangeSupport(this);
    }

    // Methods
    public void setEnergyLevel(int energyLevel) {
        support.firePropertyChange(String.valueOf(PetPropertyChangeListener.PET_ENERGY_LEVEL_CHANGE), this.energyLevel, energyLevel);
        this.energyLevel = energyLevel;
    }

    public void setState(STATES state) {
        support.firePropertyChange(String.valueOf(PetPropertyChangeListener.PET_STATUS_CHANGE), this.state, state);
        this.state = state;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    // Enum of states
    enum STATES {
        AWAKE,
        SLEEP,
        PLAYING
    }
}

class Dog extends Pet {
}

class Cat extends Pet {
}

class Vet {
    // Here will store all events for each pet
    private final HashMap<Pet, ArrayList<String>> journal;

    // Constructor
    public Vet() {
        journal = new HashMap<>();
    }

    // Record a change of a pet onto vet's journal
    public void recordChange(Pet pet, String change) {
        // Retrieve pet's journal
        ArrayList<String> petsJournal = journal.get(pet);
        if (petsJournal == null) { // .computeIfAbsent could be used here.
            petsJournal = new ArrayList<>();
            journal.put(pet, petsJournal);
        }

        // Add the change
        petsJournal.add(change);
    }

    // Generate a String with all the changes of a specific pet
    public String getPetJournal(Pet pet) {
        // Retrieve pet's journal
        ArrayList<String> petsJournal = journal.get(pet);

        // Dump all changes entries into a string
        StringBuilder str = new StringBuilder();
        if (petsJournal != null) {
            for (String change : petsJournal) {
                str.append(change).append(String.format("%n"));
            }
        }

        // Return as string
        return str.toString();
    }

    // Prints the changes of all pets
    public void printReport() {
        // Print the journal of each pet
        for (Pet pet : journal.keySet()) {
            System.out.printf(" -%s: %s%n", pet.getClass().getSimpleName(), pet.hashCode());
            System.out.println(getPetJournal(pet));
        }
    }

}

class PetPropertyChangeListener implements PropertyChangeListener {
    public static final int PET_STATUS_CHANGE = 0;
    public static final int PET_ENERGY_LEVEL_CHANGE = 1;
    private final Vet vet;

    public PetPropertyChangeListener(Vet vet) {
        this.vet = vet;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() instanceof Pet) {
            int evtCode = Integer.parseInt(evt.getPropertyName());
            switch (evtCode) {
                case PET_STATUS_CHANGE -> vet.recordChange((Pet) evt.getSource(), "New Status: " + evt.getNewValue());
                case PET_ENERGY_LEVEL_CHANGE -> vet.recordChange((Pet) evt.getSource(), "New Energy: " + evt.getNewValue());
            }
        }
    }
}