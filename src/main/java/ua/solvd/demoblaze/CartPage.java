package ua.solvd.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "#tbodyid tr td:nth-child(2)")
    private List<WebElement> cartItemTitles;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductInCart(String productName) {
        waitForElementsVisibility(cartItemTitles, "Cart Items Table");
        return cartItemTitles.stream()
                .anyMatch(item -> item.getText().trim().equalsIgnoreCase(productName));
    }
}