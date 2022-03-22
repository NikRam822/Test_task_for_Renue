package filesHandlers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * A class that implements the application properties
 */
public class Configuration {
    private int userNumberColumn = -1;

    /**
     * Constructor for initializing user-entered data
     *
     * @param userNumberColumn user's data
     */
    public Configuration(int userNumberColumn) {

        this.userNumberColumn = userNumberColumn;
    }

    /**
     * Default constructor
     */
    public Configuration() {
    }

    /**
     * Application Properties
     */
    private final Properties properties = new Properties();

    /**
     * Method for processing application properties
     *
     * @return Column number
     */
    public int getProperties() {
        FileInputStream propertyFile = null;
        try {
            propertyFile = new FileInputStream("src/main/resources/application.properties");

        } catch (FileNotFoundException e) {
            try {
                propertyFile = new FileInputStream("classes/application.properties");
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        try {
            properties.load(propertyFile);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        if (userNumberColumn == -1) {
            return Integer.parseInt(properties.getProperty("columnNumber"));
        } else {
            return userNumberColumn;
        }

    }


}
