package ua.solvd.demoblaze;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseMethodTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        initDriver();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}