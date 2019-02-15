package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    private Properties properties = new Properties();
    private static PropertiesUtils instance;

    private PropertiesUtils() throws IOException {
        InputStream inputStream = null;
        inputStream = getClass().getClassLoader()
                .getResourceAsStream("config\\config.properties");
        properties.load(inputStream);
    }

    public synchronized static PropertiesUtils getInstance() throws IOException {
        if (instance == null) {
            instance = new PropertiesUtils();
        }
        return instance;
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

}