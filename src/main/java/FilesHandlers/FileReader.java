package FilesHandlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

/**
 * A class that implements the logic of reading from a file
 */
public class FileReader {

    /**
     * Field for reading a file
     */
    private final BufferedReader reader;

    /**
     * Constructor that implements the logic of reading from the file to the stream.
     */
    public FileReader() {

        InputStream in = getClass().getResourceAsStream("/airports.dat");

        reader = new BufferedReader(new InputStreamReader(in));
    }

    /**
     * A method that reads the entered data from the console
     *
     * @return Entered data from the console
     */
    public String readFromConsole() {
        System.out.println("Введите строку");
        return new Scanner(System.in).nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
    }

    /**
     * Method for reading from file to string
     *
     * @return Another line from the file
     */
    public String getLine() {
        String line = null;

        try {
            line = reader.readLine();
            if (line != null) {
                line = line.toLowerCase(Locale.ROOT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }
}
