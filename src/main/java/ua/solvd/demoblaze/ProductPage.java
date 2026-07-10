package ua.solvd.demoblaze;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "a.btn.btn-success")
    private WebElement addToCartButton;

    @FindBy(css = "#cartur")
    private WebElement cartNavLink;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).perform();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public String getAlertTextAndAccept() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public void clickCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartNavLink)).click();
    }
}