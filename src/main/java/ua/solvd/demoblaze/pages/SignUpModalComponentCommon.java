package ua.solvd.demoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.constant.Constants;

public class SignUpModalComponentCommon extends BasePage {

    @FindBy(css = "#sign-username")
    protected ExtendedWebElement usernameInput;

    @FindBy(css = "#sign-password")
    protected ExtendedWebElement passwordInput;

    @FindBy(css = "button[onclick='register()']")
    protected ExtendedWebElement signUpButton;

    @FindBy(css = "#signInModal")
    protected ExtendedWebElement modalContainer;

    public SignUpModalComponentCommon(WebDriver driver) {
        super(driver);
    }

    public SignUpModalComponentCommon fillSignUpForm(String username, String password) {
        usernameInput.type(username);
        passwordInput.type(password);
        return this;
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public String acceptSignUpAlert() {
        return getAlertTextAndAccept();
    }

    public boolean isModalClosed() {
        return modalContainer.waitUntilElementDisappear(Constants.DEFAULT_TIMEOUT);
    }
}