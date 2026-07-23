package ua.solvd.demoblaze.pages.impl;

import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.BasePage;

public abstract class ChromeNativePageCommon extends BasePage {
    public ChromeNativePageCommon(WebDriver driver) {
        super(driver);
    }

    public abstract ChromeNativePageCommon clickTabSwitcher();

    public abstract ChromeNativePageCommon clickNewTab();
}