package ua.solvd.demoblaze.pages.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

public class LoginModalComponent extends BasePage {

    @FindBy(css = "#loginusername")
    private WebElement usernameInput;

    @FindBy(css = "#loginpassword")
    private WebElement passwordInput;

    @FindBy(css = "button[onclick='logIn()']")
    private WebElement logInButton;

    @FindBy(css = "#logInModal")
    private WebElement modalContainer;

    public LoginModalComponent(WebDriver driver) {
        super(driver);
    }

    public LoginModalComponent fillLoginForm(String username, String password) {
        typeText(usernameInput, username, "Login Username");
        typeText(passwordInput, password, "Login Password");
        return this;
    }

    public void clickLogInButton() {
        clickElement(logInButton, "Log In Button");
    }

    public boolean isModalClosed() {
        return waitForElementToDisappear(modalContainer, "Log In Modal Container");
    }

    public String acceptLoginAlert() {
        return getAlertTextAndAccept();
    }
}