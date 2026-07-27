package ua.solvd.demoblaze.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.CartPageCommon;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageCommon.class)
public class AndroidCartPage extends CartPageCommon {
    public AndroidCartPage(WebDriver driver) {
        super(driver);
    }
}