package ua.solvd.demoblaze.pages.impl;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

public abstract class ProductPageCommon extends BasePage {

    @Name("Add to cart button")
    @FindBy(css = "a.btn.btn-success")
    protected ExtendedWebElement addToCartButton;

    public ProductPageCommon(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {
        addToCartButton.hover();
        addToCartButton.click();
    }

    public String acceptProductAddedAlert() {
        return getAlertTextAndAccept();
    }
}