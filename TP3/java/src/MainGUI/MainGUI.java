package MainGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MainGUI {
    // Attributes / GUI elements
    private JTabbedPane tabbedPane;
    private JPanel panel;

    // CSV tab
    private JButton btn_csvSelectFile;
    private JLabel txt_csvFilePath;
    private JTable table_csv;
    private JLabel txt_csvAnalyzeResults;

    // Text tab

    // Constructor
    public MainGUI() {
        // Listeners CSV tab
        btn_csvSelectFile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                csvMain();
            }
        });
    }

    // Main
    public static void main(String[] args) {
        // Create a frame, and set panel and visibility.
        JFrame frame = new defaultFrame("PDP-TP3-Albanes");
        frame.setContentPane(new MainGUI().panel);
        frame.setVisible(true);
    }

    // CSV Main
    public void csvMain() {
        // Get file with FileChooser
        File file = getFileWithFileChooser();

        // Show file path
        txt_csvFilePath.setText(file.getAbsolutePath());

        // Initialize counters
        int n_Words = 0;
        int n_Chars = 0;
        int n_PMarks = 0;
        int n_Upper = 0;
        int n_Lower = 0;

        // Open file (try with resources, implicit call finally (.close))
        try (BufferedReader csv = new BufferedReader(new FileReader(file))) {
            // Defining to check for punctuation marks later!
            char[] punctuationMarks = {'.', ',', ':', ';', '\'', '"', '(', ')', '!', '?'};
            Arrays.sort(punctuationMarks); // Will perform a binarySearch

            // Define a new TableModel and useful variables
            DefaultTableModel table = new DefaultTableModel();
            String line;
            String delimiter = null;

            // Analyze
            while ((line = csv.readLine()) != null) {
                // Only enters at first row
                if (delimiter == null) {
                    // Get delimiter
                    try {
                        delimiter = getCSVDelimiter(line);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break; // Terminates
                    }

                    // Add Columns
                    String[] columns = line.split(delimiter);
                    for (String column : columns) {
                        table.addColumn(column);
                    }
                }

                // Add row to TableModel
                String[] dataColumns = line.split(delimiter);
                table.addRow(dataColumns);

                // Analyze for numbers of *
                for (String data : dataColumns) {
                    String[] words = data.split("");
                    n_Words += words.length; // N of words

                    for (String word : words) {
                        if (word.isEmpty()) {
                            continue;
                        }
                        char first = word.charAt(0);
                        if (Character.isUpperCase(first)) {
                            n_Upper++; // n uppercase
                        } else if (Character.isLowerCase(first)) {
                            n_Lower++; // n lowercase
                        }

                        n_Chars += word.length(); // n of chars

                        for (char c : word.toCharArray()) {
                            if (Arrays.binarySearch(punctuationMarks, c) >= 0) {
                                n_PMarks++; // n of punctuation marks
                            }
                        }

                    }
                }
            }
            // Only updates if a delimiter was found, that means that the file was a valid csv.
            if (delimiter != null) {
                // Update the GUI table model to the new.
                table_csv.setModel(table);
                // Update analysis of txt
                txt_csvAnalyzeResults.setText(htmlFormatterAnalysisResume(n_Words, n_Chars, n_PMarks, n_Upper, n_Lower));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // Methods
    public File getFileWithFileChooser() {
        // Create and show a FileChooser, returns a File Object.
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this.panel);
        return fileChooser.getSelectedFile();
    }

    private String getCSVDelimiter(String txt) throws Exception {
        // Check for the first occurrence of a possible defined delimiter, return as String
        // Define possibles delimiters.
        final String[] DELIMITERS = {",", ";", "\t"};
        String found = null;
        for (String delimiter : DELIMITERS) {
            if (txt.contains(delimiter)) {
                found = delimiter;
                break;
            }
        }
        // Check if some delimiter was found, if not, throws a generic new Exception and creates a ErrorFrame.
        if (found == null) {
            String txtError = "No delimiter found in file.";
            new ErrorFrame(txtError);
            throw new Exception(txtError);
        } else {
            return found;
        }
    }

    private String htmlFormatterAnalysisResume(int n_Words, int n_Chars, int n_PMarks, int n_Upper, int n_Lower) {
        // Format the result of the counters as html, to be printed in a JLabel.
        return "<html>" +
                "N' of words: " + n_Words + "<br/>" +
                "N' of characters: " + n_Chars + "<br/>" +
                "N' of punt. marks: " + n_PMarks + "<br/>" +
                "N' of uppercase chars: " + n_Upper + "<br/>" +
                "N' of lowercase chars: " + n_Lower + "<br/>" +
                "</html>";
    }

}

/**
 * Own defined JFrames with basic predefined settings
 */
class defaultFrame extends JFrame {
    defaultFrame(String title) {
        this.setTitle(title);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class ErrorFrame extends JFrame {
    ErrorFrame(String txtError) {
        this.setTitle("Error");
        this.setSize(250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel txt_Label = new JLabel(txtError);
        JFrame frame = new JFrame();
        frame.setSize(250, 100);
        frame.add(txt_Label);
        frame.setVisible(true);
    }
}