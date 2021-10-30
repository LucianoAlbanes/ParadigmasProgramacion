package ThreadRace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class ThreadRace {
    // Attributes
    private JComboBox combo_racerType;
    private JComboBox combo_racePath;
    private JButton startRaceButton;
    private JPanel mainPanel;
    private JPanel raceCanvas;

    // Constructor
    public ThreadRace() {
        // Add Listener to Start Race button
        startRaceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Create a new race
                Race race = new Race(raceCanvas, combo_racerType.getSelectedIndex(), new RacePath(combo_racePath.getSelectedIndex()));

                // Print the racePath
                race.printTrack();

                // Add some racers.
                race.addRacer(Color.BLUE, -2);
                race.addRacer(Color.GREEN, 0);
                race.addRacer(Color.RED, 2);
                //race.addRacer(Color.PINK, -1);
                //race.addRacer(Color.YELLOW, 1);

                // Start!
                race.start();
            }
        });
    }

    // Main function
    public static void main(String[] args) {
        // Create a frame, and set panel and visibility.
        JFrame frame = new DefaultFrame("PDP-TP3-ThreadRace-Albanes");
        frame.setContentPane(new ThreadRace().mainPanel);
        frame.setVisible(true);
    }
}

// Default JFrame
class DefaultFrame extends JFrame {
    DefaultFrame(String title) {
        this.setTitle(title);
        this.setSize(700, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Race class
class Race {
    // Attributes
    private final JPanel raceCanvas;
    private final RacePath racePath;
    private final int racerType;
    private final ArrayList<Racer> racers;

    // Constructor
    public Race(JPanel raceCanvas, int racerClass, RacePath racePath) {
        this.raceCanvas = raceCanvas;
        this.racePath = racePath;
        this.racerType = racerClass;
        racers = new ArrayList<>();
    }

    // Print track
    public void printTrack() {
        // Get graphics and coordinates
        Graphics gr = raceCanvas.getGraphics();
        int[][] coordinates = racePath.getCoordinates();

        // Fill track
        gr.setColor(Color.LIGHT_GRAY);
        gr.fillPolygon(coordinates[0], coordinates[1], racePath.getSize());

        // Fill borders
        gr.setColor(Color.BLACK);
        //Alt:   gr.drawPolygon(coordinates[0], coordinates[1], racePath.getSize());
        for (int i = 0; i < racePath.getSize(); i++) {
            gr.drawRoundRect(coordinates[0][i], coordinates[1][i], 5, 5, 2, 2);
        }
    }

    // Add racers
    public void addRacer(Color color, int offset) {
        racers.add(Racer.racerFactory(racerType, color, offset, raceCanvas.getGraphics(), racePath));
    }

    // Start race (racers threads)
    public void start() {
        for (Racer racer : racers) {
            racer.start();
        }
    }
}

// Race Paths Class
class RacePath {
    // Array with the coordinates of the Path / track
    private int size;
    private int[] coordinates_x;
    private int[] coordinates_y;

    // Constructor of RacePath.
    public RacePath(int racePathID) {
        switch (racePathID) {
            case 0 -> setCoordinates("Spa.csv");
            case 1 -> setCoordinates("Nuerburgring.csv");
            case 2 -> setCoordinates("SaoPaulo.csv");
            case 3 -> setCoordinates("Melbourne.csv");
            case 4 -> setCoordinates("Shanghai.csv");
            default -> throw new IllegalArgumentException("racePathID \"" + racePathID + "\" isn't valid.");
        }
    }

    // Getters
    public int getSize() {
        return size;
    }

    public int[][] getCoordinates() {
        return new int[][]{coordinates_x, coordinates_y};
    }

    // Load coordinates from csv
    private void setCoordinates(String path) {
        int[][] csvData;
        csvData = CSV.read(new InputStreamReader(this.getClass().getResourceAsStream(path))); // Open .csv inside .jar
        coordinates_x = csvData[0];
        coordinates_y = csvData[1];
        size = csvData[0].length;
    }
}

// Racers Class (The only difference between classes is the speedFactor)
abstract class Racer extends Thread {
    // Attributes
    private static final Random rdn = new Random();
    private final Color color;
    private final Graphics graphics;
    private final RacePath racePath;
    private final int offset;
    protected float speedFactor;
    private int position;

    // Constructor
    public Racer(Color color, int offset, Graphics graphics, RacePath racePath) {
        this.color = color;
        this.graphics = graphics;
        this.racePath = racePath;
        this.offset = offset;
    }

    // Get corresponding class
    public static Racer racerFactory(int racerID, Color color, int offset, Graphics graphics, RacePath racePath) {
        switch (racerID) {
            case 0 -> {
                return new Car(color, offset, graphics, racePath);
            }
            case 1 -> {
                return new Bike(color, offset, graphics, racePath);
            }
            case 2 -> {
                return new Person(color, offset, graphics, racePath);
            }
            case 3 -> {
                return new Horse(color, offset, graphics, racePath);
            }
            default -> throw new IllegalArgumentException("racerID \"" + racerID + "\" isn't valid.");
        }
    }

    // Thread run
    @Override
    public void run() {
        long time = System.currentTimeMillis();
        int[][] coordinates = racePath.getCoordinates();
        boolean running = true;
        while (running) {
            // increment position (into coordinates array)
            position++;

            // Put to sleep
            try {
                Thread.sleep(rdn.nextInt((int) (100 * speedFactor)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Increment and draw
            graphics.setColor(color);
            graphics.drawRoundRect(coordinates[0][position] + offset, coordinates[1][position] + offset,
                    2, 2, 1, 1);

            // Check if finished
            if (position == racePath.getSize() - 1) {
                running = false;
            }
        }

        // Write time
        graphics.fillOval(5, 350 + offset * 25, 16, 16); // Filled oval with color
        graphics.setColor(Color.BLACK);
        graphics.drawOval(5, 350 + offset * 25, 16, 16); // Draw oval with black
        String completedIn = String.valueOf(System.currentTimeMillis() - time);
        graphics.drawString(String.format("%s:%s sec.", completedIn.substring(0, 2), completedIn.substring(2, 5)), 25, 365 + offset * 25); // Next to it, time
    }
}

class Car extends Racer {
    public Car(Color color, int offset, Graphics graphics, RacePath racePath) {
        super(color, offset, graphics, racePath);
        speedFactor = 0.5f;
    }
}

class Bike extends Racer {
    public Bike(Color color, int offset, Graphics graphics, RacePath racePath) {
        super(color, offset, graphics, racePath);
        speedFactor = 1f;
    }
}

class Person extends Racer {
    public Person(Color color, int offset, Graphics graphics, RacePath racePath) {
        super(color, offset, graphics, racePath);
        speedFactor = 2;
    }
}

class Horse extends Racer {
    public Horse(Color color, int offset, Graphics graphics, RacePath racePath) {
        super(color, offset, graphics, racePath);
        speedFactor = 1.7f;
    }
}


// Aux / CSV reader
class CSV {
    public static int[][] read(InputStreamReader inputStream) {
        int[] x = new int[0];
        int[] y = new int[0];

        try (BufferedReader csv = new BufferedReader(inputStream)) {
            // Initialize arrays
            csv.mark(100000);
            int count = (int) csv.lines().count(); //TODO
            csv.reset(); // reset buffer position.
            x = new int[count];
            y = new int[count];

            // Extract data
            int i = 0;
            String line;
            String[] data;

            while ((line = csv.readLine()) != null) {
                data = line.split(",");
                x[i] = (int) (Float.parseFloat(data[0]) / 4) + 225;
                y[i] = (int) (Float.parseFloat(data[1]) / 4) + 425;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[][]{x, y};
    }
}