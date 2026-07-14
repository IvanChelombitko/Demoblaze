package ua.solvd.demoblaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.solvd.demoblaze.pages.impl.HeaderComponent;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public HeaderComponent getHeader() {
        return new HeaderComponent(driver);
    }

    protected void clickElement(WebElement element, String elementName) {
        LOGGER.info("Clicking on element: {}.", elementName);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void typeText(WebElement element, String text, String elementName) {
        LOGGER.info("Typing text '{}' into element: {}.", text, elementName);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    protected String getElementText(WebElement element, String elementName) {
        LOGGER.info("Getting text from element: {}.", elementName);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    protected void waitForElementsVisibility(List<WebElement> elements, String elementsName) {
        LOGGER.info("Waiting for visibility of elements list: {}.", elementsName);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public String getAlertTextAndAccept() {
        LOGGER.info("Waiting for alert to be present.");
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        LOGGER.info("Alert text retrieved: '{}'. Accepting alert.", alertText);
        alert.accept();
        return alertText;
    }

    protected void hoverOverElement(WebElement element, String elementName) {
        LOGGER.info("Hovering over element: {}.", elementName);
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    protected List<WebElement> waitForElementsPresenceByLocator(By locator, String elementsName) {
        LOGGER.info("Waiting for presence of elements by locator: {}.", elementsName);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}