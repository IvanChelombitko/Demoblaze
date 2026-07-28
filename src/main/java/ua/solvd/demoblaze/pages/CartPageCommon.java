package ua.solvd.demoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.constant.Constants;

import java.util.List;

public class CartPageCommon extends BasePage {

    @FindBy(css = "#tbodyid tr")
    protected List<ExtendedWebElement> cartItemRows;

    @FindBy(css = "#tbodyid tr")
    protected ExtendedWebElement firstCartItemRow;

    @FindBy(css = "#tbodyid tr td:nth-child(2)")
    protected List<ExtendedWebElement> cartItemNames;

    @FindBy(css = "#tbodyid tr td:nth-child(3)")
    protected List<ExtendedWebElement> cartItemPrices;

    public CartPageCommon(WebDriver driver) {
        super(driver);
    }

    public int getCartItemsCount() {
        if (firstCartItemRow.isElementPresent(Constants.MINIMUM_TIMEOUT)) {
            return cartItemRows.size();
        }
        return 0;
    }

    public String getFirstCartItemName() {
        return cartItemNames.getFirst().getText();
    }

    public String getFirstCartItemPrice() {
        return cartItemPrices.getFirst().getText();
    }
}