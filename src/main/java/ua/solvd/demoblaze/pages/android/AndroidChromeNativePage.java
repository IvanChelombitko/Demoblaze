package ua.solvd.demoblaze.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.ChromeNativePageCommon;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChromeNativePageCommon.class)
public class AndroidChromeNativePage extends ChromeNativePageCommon {

    @FindBy(id = "com.android.chrome:id/menu_button")
    protected ExtendedWebElement menuButton;

    @FindBy(xpath = "//android.widget.TextView[@text='New tab']")
    protected ExtendedWebElement newTabMenuItem;

    public AndroidChromeNativePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ChromeNativePageCommon clickTabSwitcher() {
        menuButton.isElementPresent(MINIMUM_TIMEOUT);
        menuButton.click();
        return this;
    }

    @Override
    public ChromeNativePageCommon clickNewTab() {
        newTabMenuItem.isElementPresent(MINIMUM_TIMEOUT);
        newTabMenuItem.click();
        return this;
    }
}