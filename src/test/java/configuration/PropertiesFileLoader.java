package configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileLoader {

    public Properties getPropertiesFromFile(String propertiesFile) {

        InputStream input = null;

        Properties properties = new Properties();
        try {
            input = getClass().getClassLoader().getResourceAsStream(propertiesFile);
            if (input != null) {
                properties.load(input);
            } else {
                throw new FileNotFoundException("Property file '" + propertiesFile + "' not found in the classpath");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeStream(input);
        return properties;
    }

    private void closeStream(InputStream stream) {
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
