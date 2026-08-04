package ua.solvd.demoblaze.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.SignUpModalComponentCommon;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SignUpModalComponentCommon.class)
public class IOSSignUpModalComponent extends SignUpModalComponentCommon {
    public IOSSignUpModalComponent(WebDriver driver) {
        super(driver);
    }
}