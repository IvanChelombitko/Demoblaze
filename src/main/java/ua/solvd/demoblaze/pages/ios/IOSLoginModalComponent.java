package ua.solvd.demoblaze.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.LoginModalComponentCommon;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginModalComponentCommon.class)
public class IOSLoginModalComponent extends LoginModalComponentCommon {
    public IOSLoginModalComponent(WebDriver driver) {
        super(driver);
    }
}