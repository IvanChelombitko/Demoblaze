package ua.solvd.demoblaze.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.solvd.demoblaze.constant.Constants;

public abstract class BasePage extends AbstractPage {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    protected String getAlertTextAndAccept() {
        waitUntil(ExpectedConditions.alertIsPresent(), Constants.DEFAULT_TIMEOUT);
        Alert alert = getDriver().switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public HeaderComponentCommon getHeader() {
        CommonBasePage basePage = initPage(getDriver(), CommonBasePage.class);
        return basePage.getHeader();
    }
}