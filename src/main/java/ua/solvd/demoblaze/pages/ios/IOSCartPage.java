package ua.solvd.demoblaze.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.CartPageCommon;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageCommon.class)
public class IOSCartPage extends CartPageCommon {
    public IOSCartPage(WebDriver driver) {
        super(driver);
    }
}