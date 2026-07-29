package ua.solvd.demoblaze;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ua.solvd.demoblaze.util.DriverPool;

@Listeners(ScreenshotListener.class)
public abstract class BaseTest {
    public WebDriver getDriver() {
        return DriverPool.getDriver();
    }

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        DriverPool.initDriver(browser);
    }

    @AfterMethod
    public void tearDown() {
        DriverPool.quitDriver();
    }
}