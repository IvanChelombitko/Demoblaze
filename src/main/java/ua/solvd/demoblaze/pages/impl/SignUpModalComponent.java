package ua.solvd.demoblaze.pages.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

public class SignUpModalComponent extends BasePage {

    @FindBy(css = "#sign-username")
    private WebElement usernameInput;

    @FindBy(css = "#sign-password")
    private WebElement passwordInput;

    @FindBy(css = "button[onclick='register()']")
    private WebElement signUpButton;

    @FindBy(css = "#signInModal")
    private WebElement modalContainer;

    public SignUpModalComponent(WebDriver driver) {
        super(driver);
    }

    public SignUpModalComponent fillSignUpForm(String username, String password) {
        typeText(usernameInput, username, "Sign Up Username");
        typeText(passwordInput, password, "Sign Up Password");
        return this;
    }

    public void clickSignUpButton() {
        clickElement(signUpButton, "Sign Up Button");
    }

    public String acceptSignUpAlert() {
        return getAlertTextAndAccept();
    }

    public boolean isModalClosed() {
        return waitForElementToDisappear(modalContainer, "Sign Up Modal Container");
    }
}