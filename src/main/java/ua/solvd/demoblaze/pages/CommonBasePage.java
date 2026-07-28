package ua.solvd.demoblaze.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CommonBasePage extends AbstractPage {

    protected CommonBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract HeaderComponentCommon getHeader();
}