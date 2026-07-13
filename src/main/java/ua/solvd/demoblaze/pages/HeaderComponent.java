package ua.solvd.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends BasePage {

    @FindBy(css = "#cartur")
    private WebElement cartNavLink;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void clickCart() {
        clickElement(cartNavLink, "Cart Navigation Link");
    }
}