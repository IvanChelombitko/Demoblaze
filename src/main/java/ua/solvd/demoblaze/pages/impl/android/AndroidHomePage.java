package ua.solvd.demoblaze.pages.impl.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.impl.HomePageCommon;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageCommon.class)
public class AndroidHomePage extends HomePageCommon {
    public AndroidHomePage(WebDriver driver) {
        super(driver);
    }
}