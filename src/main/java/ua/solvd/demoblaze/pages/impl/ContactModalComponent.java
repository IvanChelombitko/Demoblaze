package ua.solvd.demoblaze.pages.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

public class ContactModalComponent extends BasePage {

    @FindBy(css = "#recipient-email")
    private WebElement emailInput;

    @FindBy(css = "#recipient-name")
    private WebElement nameInput;

    @FindBy(css = "#message-text")
    private WebElement messageInput;

    @FindBy(css = "button[onclick='send()']")
    private WebElement sendMessageButton;

    @FindBy(css = "#exampleModal")
    private WebElement modalContainer;

    public ContactModalComponent(WebDriver driver) {
        super(driver);
    }

    public ContactModalComponent fillContactForm(String email, String name, String message) {
        typeText(emailInput, email, "Contact Email");
        typeText(nameInput, name, "Contact Name");
        typeText(messageInput, message, "Contact Message");
        return this;
    }

    public void clickSendMessage() {
        clickElement(sendMessageButton, "Send message button");
    }

    public String acceptMessageSentAlert() {
        return getAlertTextAndAccept();
    }

    public boolean isModalClosed() {
        return waitForElementToDisappear(modalContainer, "Contact Modal Container");
    }
}