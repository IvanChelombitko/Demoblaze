package ua.solvd.demoblaze.pages.impl;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

public class HeaderComponent extends BasePage {

    @Name("Cart Navigation Link")
    @FindBy(css = "#cartur")
    private ExtendedWebElement cartNavLink;

    @Name("Contact Link")
    @FindBy(css = "a[data-target='#exampleModal']")
    private ExtendedWebElement contactLink;

    @Name("Sign Up Link")
    @FindBy(css = "#signin2")
    private ExtendedWebElement signUpLink;

    @Name("Log In Link")
    @FindBy(css = "#login2")
    private ExtendedWebElement logInLink;

    @Name("Log Out Link")
    @FindBy(css = "#logout2")
    private ExtendedWebElement logOutLink;

    @Name("Welcome Message")
    @FindBy(css = "#nameofuser")
    private ExtendedWebElement welcomeMessage;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public CartPage clickCart() {
        cartNavLink.click();
        return new CartPage(getDriver());
    }

    public ContactModalComponent clickContact() {
        contactLink.click();
        return new ContactModalComponent(getDriver());
    }

    public SignUpModalComponent clickSignUp() {
        signUpLink.click();
        return new SignUpModalComponent(getDriver());
    }

    public LoginModalComponent clickLogIn() {
        logInLink.click();
        return new LoginModalComponent(getDriver());
    }

    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isElementPresent();
    }

    public String getWelcomeMessageText() {
        return welcomeMessage.getText();
    }

    public boolean isLogOutLinkDisplayed() {
        return logOutLink.isElementPresent();
    }

    public boolean isLogInLinkInvisible() {
        return logInLink.waitUntilElementDisappear(DEFAULT_TIMEOUT);
    }

    public boolean isSignUpLinkInvisible() {
        return signUpLink.waitUntilElementDisappear(DEFAULT_TIMEOUT);
    }
}