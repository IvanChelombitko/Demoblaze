package ua.solvd.demoblaze.pages.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.HeaderComponentCommon;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HeaderComponentCommon.class)
public class DesktopHeaderComponent extends HeaderComponentCommon {
    public DesktopHeaderComponent(WebDriver driver) {
        super(driver);
    }
}