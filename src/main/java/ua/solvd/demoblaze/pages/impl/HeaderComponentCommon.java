package ua.solvd.demoblaze.pages.impl;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

public class HeaderComponentCommon extends BasePage {

    @Name("Cart Navigation Link")
    @FindBy(css = "#cartur")
    protected ExtendedWebElement cartNavLink;

    @Name("Contact Link")
    @FindBy(css = "a[data-target='#exampleModal']")
    protected ExtendedWebElement contactLink;

    @Name("Sign Up Link")
    @FindBy(css = "#signin2")
    protected ExtendedWebElement signUpLink;

    @Name("Log In Link")
    @FindBy(css = "#login2")
    protected ExtendedWebElement logInLink;

    @Name("Log Out Link")
    @FindBy(css = "#logout2")
    protected ExtendedWebElement logOutLink;

    @Name("Welcome Message")
    @FindBy(css = "#nameofuser")
    protected ExtendedWebElement welcomeMessage;

    public HeaderComponentCommon(WebDriver driver) {
        super(driver);
    }

    public CartPageCommon clickCart() {
        cartNavLink.click();
        return initPage(getDriver(), CartPageCommon.class);
    }

    public ContactModalComponentCommon clickContact() {
        contactLink.click();
        return initPage(getDriver(), ContactModalComponentCommon.class);
    }

    public SignUpModalComponentCommon clickSignUp() {
        signUpLink.click();
        return initPage(getDriver(), SignUpModalComponentCommon.class);
    }

    public LoginModalComponentCommon clickLogIn() {
        logInLink.click();
        return initPage(getDriver(), LoginModalComponentCommon.class);
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