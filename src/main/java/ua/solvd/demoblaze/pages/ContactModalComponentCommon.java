package ua.solvd.demoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.constant.Constants;

public class ContactModalComponentCommon extends BasePage {

    @FindBy(css = "#recipient-email")
    protected ExtendedWebElement emailInput;

    @FindBy(css = "#recipient-name")
    protected ExtendedWebElement nameInput;

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
        return modalContainer.waitUntilElementDisappear(Constants.DEFAULT_TIMEOUT);
    }
}