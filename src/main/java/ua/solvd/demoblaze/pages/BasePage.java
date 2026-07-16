package ua.solvd.demoblaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.solvd.demoblaze.config.Constants;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.E_WAIT_DURATION));
        PageFactory.initElements(driver, this);
    }

    protected void clickElement(WebElement element, String elementName) {
        LOGGER.info("Clicking on element: '{}'. Locator: '{}'.", elementName, element.toString());
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void typeText(WebElement element, String text, String elementName) {
        LOGGER.info("Typing text '{}' into element: '{}'. Locator: '{}'", text, elementName, element.toString());
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    protected String getElementText(WebElement element, String elementName) {
        LOGGER.info("Getting text from element: '{}'. Locator: '{}'", elementName, element.toString());
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    protected String getAlertTextAndAccept() {
        LOGGER.info("Waiting for alert to be present.");
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        LOGGER.info("Alert text retrieved: '{}'. Accepting alert.", alertText);
        alert.accept();
        return alertText;
    }

    protected void hoverOverElement(WebElement element, String elementName) {
        LOGGER.info("Hovering over element: '{}'. Locator: '{}'", elementName, element.toString());
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    protected void waitForListToLoad(List<WebElement> elements, String listName) {
        LOGGER.info("Waiting for list '{}' to be populated. Locator: '{}'", listName, elements.toString());
        wait.until(d -> !elements.isEmpty());
    }

    protected boolean waitForElementToDisappear(WebElement element, String elementName) {
        LOGGER.info("Waiting for element '{}' to disappear. Locator: '{}'", elementName, element.toString());
        try {
            return wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected boolean isElementVisible(WebElement element, String elementName) {
        LOGGER.info("Checking visibility of element '{}'. Locator: '{}'", elementName, element.toString());
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}