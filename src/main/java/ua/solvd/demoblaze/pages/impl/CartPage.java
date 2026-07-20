package ua.solvd.demoblaze.pages.impl;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "#tbodyid tr")
    private List<ExtendedWebElement> cartItemRows;

    @FindBy(css = "#tbodyid tr")
    private ExtendedWebElement firstCartItemRow;

    @FindBy(css = "#tbodyid tr td:nth-child(2)")
    private List<ExtendedWebElement> cartItemNames;

    @FindBy(css = "#tbodyid tr td:nth-child(3)")
    private List<ExtendedWebElement> cartItemPrices;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemsCount() {
        firstCartItemRow.isElementPresent(MINIMUM_TIMEOUT);
        return cartItemRows.size();
    }

    public String getFirstCartItemName() {
        return cartItemNames.getFirst().getText();
    }

    public String getFirstCartItemPrice() {
        return cartItemPrices.getFirst().getText();
    }
}