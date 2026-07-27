package ua.solvd.demoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

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

    public HomePageCommon clickLogInButton() {
        logInButton.click();
        return initPage(getDriver(), HomePageCommon.class);
    }

    public String acceptLoginAlert() {
        return getAlertTextAndAccept();
    }
}