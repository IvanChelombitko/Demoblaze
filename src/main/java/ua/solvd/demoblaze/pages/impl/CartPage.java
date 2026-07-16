package ua.solvd.demoblaze.pages.impl;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "#tbodyid tr")
    private List<WebElement> cartItemRows;

    @FindBy(css = "#tbodyid tr td:nth-child(2)")
    private List<WebElement> cartItemNames;

    @FindBy(css = "#tbodyid tr td:nth-child(3)")
    private List<WebElement> cartItemPrices;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemsCount() {
        try {
            waitForListToLoad(cartItemRows, "Cart Rows");
            return cartItemRows.size();
        } catch (TimeoutException e) {
            return 0;
        }
    }

    public String getFirstCartItemName() {
        return cartItemNames.get(0).getText();
    }

    public String getFirstCartItemPrice() {
        return cartItemPrices.get(0).getText();
    }
}