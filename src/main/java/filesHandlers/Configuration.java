package filesHandlers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * A class that implements the application properties
 */
public class Configuration {

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
            e.printStackTrace();
        }
        try {
            properties.load(propertyFile);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return Integer.parseInt(properties.getProperty("columnNumber"));
    }


}
