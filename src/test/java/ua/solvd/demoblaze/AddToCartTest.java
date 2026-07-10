package ua.solvd.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AddToCartTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Grid URL.", e);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void verifyAddingProductToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.selectCategory("Phones");
        homePage.selectProduct("Samsung galaxy s6");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        String alertMessage = productPage.getAlertTextAndAccept();
        Assert.assertEquals(alertMessage, "Product added", "Alert text has wrong content.");
    }

    @Test(dependsOnMethods = "verifyAddingProductToCart")
    public void verifyAddedProductIsVisibleInCart() {
        ProductPage productPage = new ProductPage(driver);
        productPage.clickCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart("Samsung galaxy s6"), "Product is absent in the cart.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}