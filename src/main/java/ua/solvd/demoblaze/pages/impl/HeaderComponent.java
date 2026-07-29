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

    @FindBy(css = "#login2")
    private WebElement logInLink;

    @FindBy(css = "#logout2")
    private WebElement logOutLink;

    @FindBy(css = "#nameofuser")
    private WebElement welcomeMessage;

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

    public LoginModalComponent clickLogIn() {
        clickElement(logInLink, "Log In Link");
        return new LoginModalComponent(driver);
    }

    public boolean isWelcomeMessageDisplayed() {
        return isElementVisible(welcomeMessage, "Welcome Message");
    }

    public String getWelcomeMessageText() {
        isElementVisible(welcomeMessage, "Welcome Message");
        return welcomeMessage.getText();
    }

    public boolean isLogOutLinkDisplayed() {
        return isElementVisible(logOutLink, "Log Out Link");
    }

    public boolean isLogInLinkInvisible() {
        return waitForElementToDisappear(logInLink, "Log In Link");
    }

    public boolean isSignUpLinkInvisible() {
        return waitForElementToDisappear(signUpLink, "Sign Up Link");
    }
}