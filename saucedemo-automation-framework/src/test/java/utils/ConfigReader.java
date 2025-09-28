package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    
    static {
        try {
            String configPath = "src/test/resources/config.properties";
            properties = new Properties();
            properties.load(new FileInputStream(configPath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }
    
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public static String getBrowser() {
        return getProperty("browser");
    }
    
    public static String getBaseUrl() {
        return getProperty("base.url");
    }
    
    public static String getApiBaseUrl() {
        return getProperty("api.base.url");
    }
    
    public static long getTimeout() {
        return Long.parseLong(getProperty("timeout"));
    }
}