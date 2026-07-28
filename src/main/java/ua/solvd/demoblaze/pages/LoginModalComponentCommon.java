package ua.solvd.demoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.constant.Constants;

public class LoginModalComponentCommon extends BasePage {

    @FindBy(css = "#loginusername")
    protected ExtendedWebElement usernameInput;

    @FindBy(css = "#loginpassword")
    protected ExtendedWebElement passwordInput;

    @FindBy(css = "button[onclick='logIn()']")
    protected ExtendedWebElement logInButton;

    @FindBy(css = "#logInModal")
    protected ExtendedWebElement modalContainer;

    public LoginModalComponentCommon(WebDriver driver) {
        super(driver);
    }

    public LoginModalComponentCommon fillLoginForm(String username, String password) {
        usernameInput.isElementPresent(Constants.MINIMUM_TIMEOUT);
        usernameInput.type(username);
        passwordInput.type(password);
        return this;
    }

    public HomePageCommon clickLogInButton() {
        logInButton.click();
        return initPage(getDriver(), HomePageCommon.class);
    }

    public String acceptLoginAlert() {
        return getAlertTextAndAccept();
    }
}