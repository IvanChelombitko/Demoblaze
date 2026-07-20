package ua.solvd.demoblaze.pages.impl;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

public class LoginModalComponent extends BasePage {

    @Name("Login Username")
    @FindBy(css = "#loginusername")
    private ExtendedWebElement usernameInput;

    @Name("Login Password")
    @FindBy(css = "#loginpassword")
    private ExtendedWebElement passwordInput;

    @Name("Log In Button")
    @FindBy(css = "button[onclick='logIn()']")
    private ExtendedWebElement logInButton;

    @Name("Log In Modal Container")
    @FindBy(css = "#logInModal")
    private ExtendedWebElement modalContainer;

    public LoginModalComponent(WebDriver driver) {
        super(driver);
    }

    public LoginModalComponent fillLoginForm(String username, String password) {
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