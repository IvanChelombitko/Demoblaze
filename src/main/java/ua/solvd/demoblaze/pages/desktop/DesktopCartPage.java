package ua.solvd.demoblaze.pages.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.CartPageCommon;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageCommon.class)
public class DesktopCartPage extends CartPageCommon {
    public DesktopCartPage(WebDriver driver) {
        super(driver);
    }
}