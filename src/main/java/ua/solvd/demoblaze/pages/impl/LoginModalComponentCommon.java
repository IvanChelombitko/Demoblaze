package ua.solvd.demoblaze.pages.impl;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

public class LoginModalComponentCommon extends BasePage {

    @Name("Login Username")
    @FindBy(css = "#loginusername")
    protected ExtendedWebElement usernameInput;

    @Name("Login Password")
    @FindBy(css = "#loginpassword")
    protected ExtendedWebElement passwordInput;

    @Name("Log In Button")
    @FindBy(css = "button[onclick='logIn()']")
    protected ExtendedWebElement logInButton;

    @Name("Log In Modal Container")
    @FindBy(css = "#logInModal")
    protected ExtendedWebElement modalContainer;

    public LoginModalComponentCommon(WebDriver driver) {
        super(driver);
    }

    public LoginModalComponentCommon fillLoginForm(String username, String password) {
        usernameInput.type(username);
        passwordInput.type(password);
        return this;
    }

    public void clickLogInButton() {
        logInButton.click();
    }

    public boolean isModalClosed() {
        return modalContainer.waitUntilElementDisappear(DEFAULT_TIMEOUT);
    }

    public String acceptLoginAlert() {
        return getAlertTextAndAccept();
    }
}