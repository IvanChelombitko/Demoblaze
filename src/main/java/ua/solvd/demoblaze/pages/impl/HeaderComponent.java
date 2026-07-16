package ua.solvd.demoblaze.pages.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

public class HeaderComponent extends BasePage {

    @FindBy(css = "#cartur")
    private WebElement cartNavLink;

    @FindBy(css = "a[data-target='#exampleModal']")
    private WebElement contactLink;

    @FindBy(css = "#signin2")
    private WebElement signUpLink;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public CartPage clickCart() {
        clickElement(cartNavLink, "Cart Navigation Link");
        return new CartPage(driver);
    }

    public ContactModalComponent clickContact() {
        clickElement(contactLink, "Contact Link");
        return new ContactModalComponent(driver);
    }

    public SignUpModalComponent clickSignUp() {
        clickElement(signUpLink, "Sign Up Link");
        return new SignUpModalComponent(driver);
    }
}