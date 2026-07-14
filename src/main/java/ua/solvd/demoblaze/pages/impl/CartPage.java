package ua.solvd.demoblaze.pages.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.solvd.demoblaze.pages.BasePage;

import java.util.List;

public class CartPage extends BasePage {
    private final By cartRows = By.cssSelector("#tbodyid tr");
    private final By cellName = By.cssSelector("td:nth-child(2)");
    private final By cellPrice = By.cssSelector("td:nth-child(3)");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemsCount() {
        try {
            List<WebElement> rows = waitForElementsPresenceByLocator(cartRows, "Cart item rows");
            return rows.size();
        } catch (TimeoutException e) {
            return 0;
        }
    }

    public String getFirstCartItemName() {
        return driver.findElements(cartRows).get(0).findElement(cellName).getText();
    }

    public String getFirstCartItemPrice() {
        return driver.findElements(cartRows).get(0).findElement(cellPrice).getText();
    }
}