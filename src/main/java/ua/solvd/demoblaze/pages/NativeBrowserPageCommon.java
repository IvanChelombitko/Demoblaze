package ua.solvd.demoblaze.pages;

import org.openqa.selenium.WebDriver;

public abstract class NativeBrowserPageCommon extends BasePage {
    public NativeBrowserPageCommon(WebDriver driver) {
        super(driver);
    }

    public abstract NativeBrowserPageCommon clickTabSwitcher();

    public abstract NativeBrowserPageCommon clickNewTab();
}