package ua.solvd.demoblaze.pages;

import org.openqa.selenium.WebDriver;

public abstract class NativeBrowserPage extends BasePage {
    public NativeBrowserPage(WebDriver driver) {
        super(driver);
    }

    public abstract NativeBrowserPage clickTabSwitcher();

    public abstract NativeBrowserPage clickNewTab();
}