package dbconnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    public static Properties loadProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("db.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
