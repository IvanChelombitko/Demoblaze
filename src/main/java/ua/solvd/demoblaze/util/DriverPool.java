package ua.solvd.demoblaze.util;

import org.openqa.selenium.WebDriver;

public class DriverPool {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverPool() {
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(DriverFactory.createDriver());
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}