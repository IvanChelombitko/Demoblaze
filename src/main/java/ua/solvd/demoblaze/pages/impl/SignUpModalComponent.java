package ua.solvd.demoblaze.pages.impl;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

public class SignUpModalComponent extends BasePage {

    @Name("Sign Up Username")
    @FindBy(css = "#sign-username")
    private ExtendedWebElement usernameInput;

    @Name("Sign Up Password")
    @FindBy(css = "#sign-password")
    private ExtendedWebElement passwordInput;

    @Name("Sign Up Button")
    @FindBy(css = "button[onclick='register()']")
    private ExtendedWebElement signUpButton;

    @Name("Sign Up Modal Container")
    @FindBy(css = "#signInModal")
    private ExtendedWebElement modalContainer;

    public SignUpModalComponent(WebDriver driver) {
        super(driver);
    }

    public SignUpModalComponent fillSignUpForm(String username, String password) {
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
        return modalContainer.waitUntilElementDisappear(DEFAULT_TIMEOUT);
    }
}