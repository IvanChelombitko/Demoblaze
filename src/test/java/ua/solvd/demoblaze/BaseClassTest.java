package ua.solvd.demoblaze;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseClassTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        initDriver();
    }

    @AfterClass
    public void tearDown() {
        quitDriver();
    }
}