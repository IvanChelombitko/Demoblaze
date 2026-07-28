package ua.solvd.demoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPageCommon extends BasePage {

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