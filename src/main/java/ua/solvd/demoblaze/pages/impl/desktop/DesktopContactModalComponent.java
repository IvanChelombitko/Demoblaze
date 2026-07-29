package ua.solvd.demoblaze.pages.impl.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.impl.ContactModalComponentCommon;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ContactModalComponentCommon.class)
public class DesktopContactModalComponent extends ContactModalComponentCommon {
    public DesktopContactModalComponent(WebDriver driver) {
        super(driver);
    }
}