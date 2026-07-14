package ua.solvd.demoblaze.pages.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

public class HeaderComponent extends BasePage {

    @FindBy(css = "#cartur")
    private WebElement cartNavLink;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public CartPage clickCart() {
        clickElement(cartNavLink, "Cart Navigation Link");
        return new CartPage(driver);
    }
}