package ua.solvd.demoblaze.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver createDriver() {
        String gridUrl = ConfigReader.getProperty("grid.url");
        ChromeOptions options = new ChromeOptions();
        try {
            WebDriver driver = new RemoteWebDriver(new URL(gridUrl), options);
            driver.manage().window().maximize();
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Grid URL: " + gridUrl, e);
        }
    }
}