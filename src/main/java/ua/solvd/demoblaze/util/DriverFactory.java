package ua.solvd.demoblaze.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import ua.solvd.demoblaze.config.Constants;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver createDriver(String browser) {
        try {
            WebDriver driver;
            if ("firefox".equalsIgnoreCase(browser)) {
                String gridUrl = "http://localhost:4445/wd/hub";
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--width=1920", "--height=1080");
                driver = new RemoteWebDriver(new URL(gridUrl), options);
            } else {
                String gridUrl = "http://localhost:4444/wd/hub";
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--window-size=1920,1080");
                driver = new RemoteWebDriver(new URL(gridUrl), options);
            }
            driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(Constants.LOAD_TIMEOUT_DURATION));
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Grid URL", e);
        }
    }
}