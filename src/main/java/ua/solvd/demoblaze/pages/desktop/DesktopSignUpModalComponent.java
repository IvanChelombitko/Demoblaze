package ua.solvd.demoblaze.pages.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.SignUpModalComponentCommon;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignUpModalComponentCommon.class)
public class DesktopSignUpModalComponent extends SignUpModalComponentCommon {
    public DesktopSignUpModalComponent(WebDriver driver) {
        super(driver);
    }
}