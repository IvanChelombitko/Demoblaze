package ua.solvd.demoblaze;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.solvd.demoblaze.util.DriverPool;

public abstract class BaseTest {
    public WebDriver getDriver() {
        return DriverPool.getDriver();
    }

    @BeforeMethod
    public void setUp() {
        WebDriver driver = DriverPool.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverPool.quitDriver();
    }
}