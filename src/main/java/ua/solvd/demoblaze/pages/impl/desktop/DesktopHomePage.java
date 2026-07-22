package ua.solvd.demoblaze.pages.impl.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.impl.HomePageCommon;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageCommon.class)
public class DesktopHomePage extends HomePageCommon {
    public DesktopHomePage(WebDriver driver) {
        super(driver);
    }
}