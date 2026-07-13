package ua.solvd.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void initDriver() {
        ChromeOptions options = new ChromeOptions();
        try {
            WebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
            webDriver.manage().window().maximize();
            driver.set(webDriver);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Grid URL.", e);
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}