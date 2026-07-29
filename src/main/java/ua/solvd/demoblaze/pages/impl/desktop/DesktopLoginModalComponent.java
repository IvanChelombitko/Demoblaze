package ua.solvd.demoblaze.pages.impl.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.impl.LoginModalComponentCommon;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginModalComponentCommon.class)
public class DesktopLoginModalComponent extends LoginModalComponentCommon {
    public DesktopLoginModalComponent(WebDriver driver) {
        super(driver);
    }
}