package ua.solvd.demoblaze.pages.impl.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.impl.CartPageCommon;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageCommon.class)
public class AndroidCartPage extends CartPageCommon {
    public AndroidCartPage(WebDriver driver) {
        super(driver);
    }
}