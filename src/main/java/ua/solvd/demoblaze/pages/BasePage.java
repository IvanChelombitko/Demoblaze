package ua.solvd.demoblaze.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage extends AbstractPage {
    protected static final long DEFAULT_TIMEOUT = 10L;
    protected static final long MINIMUM_TIMEOUT = 3L;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    protected String getAlertTextAndAccept() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}