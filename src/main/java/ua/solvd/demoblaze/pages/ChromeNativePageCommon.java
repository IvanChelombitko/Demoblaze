package ua.solvd.demoblaze.pages;

import org.openqa.selenium.WebDriver;

public abstract class ChromeNativePageCommon extends BasePage {
    public ChromeNativePageCommon(WebDriver driver) {
        super(driver);
    }

    public abstract ChromeNativePageCommon clickTabSwitcher();

    public abstract ChromeNativePageCommon clickNewTab();
}