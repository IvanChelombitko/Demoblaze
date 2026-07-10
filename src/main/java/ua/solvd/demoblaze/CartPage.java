package ua.solvd.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#tbodyid tr td:nth-child(2)")
    private List<WebElement> cartItemTitles;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isProductInCart(String productName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(cartItemTitles));
        return cartItemTitles.stream()
                .anyMatch(item -> item.getText().trim().equalsIgnoreCase(productName));
    }
}