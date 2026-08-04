package ua.solvd.demoblaze.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.HomePageCommon;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageCommon.class)
public class IOSHomePage extends HomePageCommon {
    public IOSHomePage(WebDriver driver) {
        super(driver);
    }
}