package ua.solvd.demoblaze.pages;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.constant.Constants;

public class HeaderComponent extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(css = "#cartur")
    protected ExtendedWebElement cartNavLink;

    @FindBy(css = "a[data-target='#exampleModal']")
    protected ExtendedWebElement contactLink;

    @FindBy(css = "#signin2")
    protected ExtendedWebElement signUpLink;

    @FindBy(css = "#login2")
    protected ExtendedWebElement logInLink;

    @FindBy(css = "#logout2")
    protected ExtendedWebElement logOutLink;

    @FindBy(css = "#nameofuser")
    protected ExtendedWebElement welcomeMessage;

    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
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

    public boolean waitUntilLogInLinkDisappears() {
        return logInLink.waitUntilElementDisappear(Constants.DEFAULT_TIMEOUT);
    }

    public boolean waitUntilSignUpLinkDisappears() {
        return signUpLink.waitUntilElementDisappear(Constants.DEFAULT_TIMEOUT);
    }
}