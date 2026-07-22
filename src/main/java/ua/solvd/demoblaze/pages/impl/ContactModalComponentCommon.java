package ua.solvd.demoblaze.pages.impl;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

public class ContactModalComponentCommon extends BasePage {

    @Name("Contact Email Input")
    @FindBy(css = "#recipient-email")
    protected ExtendedWebElement emailInput;

    @Name("Contact Name")
    @FindBy(css = "#recipient-name")
    protected ExtendedWebElement nameInput;

    @Name("Contact Message")
    @FindBy(css = "#message-text")
    protected ExtendedWebElement messageInput;

    @FindBy(css = "button[onclick='send()']")
    protected ExtendedWebElement sendMessageButton;

    @FindBy(css = "#exampleModal")
    protected ExtendedWebElement modalContainer;

    public ContactModalComponentCommon(WebDriver driver) {
        super(driver);
    }

    public ContactModalComponentCommon fillContactForm(String email, String name, String message) {
        emailInput.type(email);
        nameInput.type(name);
        messageInput.type(message);
        return this;
    }

    public void clickSendMessage() {
        sendMessageButton.clickByJs();
    }

    public String acceptMessageSentAlert() {
        return getAlertTextAndAccept();
    }

    public boolean isModalClosed() {
        return modalContainer.waitUntilElementDisappear(DEFAULT_TIMEOUT);
    }
}