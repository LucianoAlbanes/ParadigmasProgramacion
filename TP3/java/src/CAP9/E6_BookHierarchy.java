package CAP9;

/*
Books can come in various formats, like paper books, audiobooks, ebooks, etc.
Create a generic class Book that has as common attributes the title, the year of publication, and the author.
The constructor of this class should instantiate all three attributes. Override the toString method of class Book
that returns a string that contains the values of its attributes. Create a subclass PrintBook that extends Book
with attributes Publisher and ISBN. Create another subclass AudioBook which has the book’s size (in MB),
its play length and the playback artist’s name as attributes. Both PrintBook and AudioBook classes override
the toString method inherited from Book. Write a Java application to demonstrate the usage of this hierarchy.
*/

import java.time.Duration;
import java.time.Year;

public class E6_BookHierarchy {
    public static void main(String[] args) {
        // Making test books
        System.out.println("Creating books...");
        Book b1 = new Book("It Ends With Us", 2016, "Colleen Hoover");
        PrintBook b2 = new PrintBook("The Midnight Library", Year.of(2021), "Matt Haig",
                             "Canongate Books Ltd", 9781786892737L);
        AudioBook b3 = new AudioBook("Padre Rico, Padre Pobre", 2016, "Robert T. Kiyosaki",
                                 195.1453f, Duration.ofMinutes(6 * 60 + 24), "Jesús Flores Jaimes");

        // Print data about books
        System.out.printf("%s%n%n%s%n%n%s%n", b1, b2, b3);
    }
}

class Book {
    // Attributes
    private final String title;
    private final Year publishYear;
    private final String author;

    // Constructors
    public Book(String title, int publishYear, String author) throws java.time.DateTimeException {
        // java.time.Year takes care of invalid input.
        this(title, Year.of(publishYear), author);
    }

    public Book(String title, Year publishYear, String author) {
        this.title = title;
        this.publishYear = publishYear;
        this.author = author;
    }

    // Methods
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":\n"
                + "\tTitle: " + title + ".\n"
                + "\tPublish Year: " + publishYear + ".\n"
                + "\tAuthor Name: " + author + ".";
    }
}

class PrintBook extends Book {
    private final String publisher;
    private long ISBN;

    // Constructors
    public PrintBook(String title, int publishYear, String authorName, String publisher, long ISBN)
            throws java.time.DateTimeException, IllegalArgumentException {
        this(title, Year.of(publishYear), authorName, publisher, ISBN);
    }

    public PrintBook(String title, Year publishYear, String authorName, String publisher, long ISBN)
            throws IllegalArgumentException {
        super(title, publishYear, authorName);
        this.publisher = publisher;
        setISBN(ISBN); // Can throw IllegalArgumentException. Catch it!.
    }

    // Methods
    private static boolean isValidISBN(long value) {
        /*
            Verifies if a given value of 13 numbers is a valid ISBN,
            according to the International ISBN Agency specification.
        */
        boolean isValid = true; // Until proven otherwise
        if (String.valueOf(value).length() != 13) {
            isValid = false;
        } else {
            // Check verifier number
            int count = 0;
            int sum = 0;
            do {
                sum += count % 2 == 0 ? value % 10 : 3 * (value % 10);
                count++;
                value /= 10;
            } while (value > 0);

            // If sum ended as multiple of 10, is valid.
            if (sum % 10 != 0) {
                isValid = false;
            }
        }
        return isValid;
    }

    private void setISBN(long ISBN) throws IllegalArgumentException {
        if (!isValidISBN(ISBN)) {
            throw new IllegalArgumentException("The provided ISBN isn't valid.");
        } else {
            this.ISBN = ISBN;
        }
    }

    @Override
    public String toString() {
        String ISBN = String.valueOf(this.ISBN);
        return super.toString() + "\n"
                + "\tPublisher: " + publisher + ".\n"
                + "\tISBN: " + ISBN.substring(0, 3) + "-" + ISBN.charAt(3) + "-" + ISBN.substring(4, 7) + "-"
                             + ISBN.substring(7, 12) + "-" + ISBN.charAt(12) + ".";
    }
}

class AudioBook extends Book {
    private float size; // in MB
    private Duration length;
    private final String playbackArtist;

    // Constructors
    public AudioBook(String title, int publishYear, String authorName, float size, Duration length, String playbackArtist)
            throws java.time.DateTimeException, IllegalArgumentException {
        this(title, Year.of(publishYear), authorName, size, length, playbackArtist);
    }

    public AudioBook(String title, Year publishYear, String authorName, float size, Duration length, String playbackArtist)
            throws IllegalArgumentException {
        super(title, publishYear, authorName);
        setSize(size); // Throws exception when size is <= 0
        setLength(length); // Throws exception when length is <= 0
        this.playbackArtist = playbackArtist;
    }

    // Methods
    private void setSize(float size) throws IllegalArgumentException {
        if (size <= 0) {
            throw new IllegalArgumentException("AudioBook size must be greater than 0 MB");
        } else {
            this.size = size;
        }
    }

    private void setLength(Duration length) throws IllegalArgumentException {
        if (length.isZero()) {
            throw new IllegalArgumentException("AudioBook length must be greater than 0.");
        } else if (length.isNegative()) {
            throw new IllegalArgumentException("AudioBook length must be positive.");
        } else {
            this.length = length;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "\tSize: " + String.format("%.2f", size) + " MB.\n"
                + "\tLength: " + String.format("%d:%d:%d", length.toHoursPart(), length.toMinutesPart(),
                                               length.toSecondsPart()) + ".\n"
                + "\tPlayback artist: " + playbackArtist + ".";
    }
}
