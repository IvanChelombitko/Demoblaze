package ua.solvd.demoblaze.pages.impl;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

public class ContactModalComponent extends BasePage {

    @Name("Contact Email Input")
    @FindBy(css = "#recipient-email")
    private ExtendedWebElement emailInput;

    @Name("Contact Name")
    @FindBy(css = "#recipient-name")
    private ExtendedWebElement nameInput;

    @Name("Contact Message")
    @FindBy(css = "#message-text")
    private ExtendedWebElement messageInput;

    @FindBy(css = "button[onclick='send()']")
    private ExtendedWebElement sendMessageButton;

    @FindBy(css = "#exampleModal")
    private ExtendedWebElement modalContainer;

    public ContactModalComponent(WebDriver driver) {
        super(driver);
    }

    public ContactModalComponent fillContactForm(String email, String name, String message) {
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