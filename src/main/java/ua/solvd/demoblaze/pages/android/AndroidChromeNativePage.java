package ua.solvd.demoblaze.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.ChromeNativePageCommon;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChromeNativePageCommon.class)
public class AndroidChromeNativePage extends ChromeNativePageCommon {

    @FindBy(id = "com.android.chrome:id/menu_button")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//android.widget.TextView[@text='New tab']")
    private ExtendedWebElement newTabMenuItem;

    public AndroidChromeNativePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ChromeNativePageCommon clickTabSwitcher() {
        menuButton.click();
        return this;
    }

    @Override
    public ChromeNativePageCommon clickNewTab() {
        newTabMenuItem.click();
        return this;
    }
}