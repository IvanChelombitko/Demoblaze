package ua.solvd.demoblaze.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigReader.class);
    private static final Properties properties;

    static {
        try (FileInputStream input = new FileInputStream("src/test/resources/config.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            LOGGER.error("Failed to load config.properties. Check if the file exists in src/test/resources/", e);
            throw new RuntimeException("Configuration file loading failed.", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}