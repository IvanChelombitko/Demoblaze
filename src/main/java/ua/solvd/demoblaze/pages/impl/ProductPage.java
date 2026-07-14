package ua.solvd.demoblaze.pages.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

public class ProductPage extends BasePage {

    @FindBy(css = "a.btn.btn-success")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {
        hoverOverElement(addToCartButton, "Add to cart button");
        clickElement(addToCartButton, "Add to cart button");
    }
}