package ua.solvd.demoblaze.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.ContactModalComponentCommon;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ContactModalComponentCommon.class)
public class AndroidContactModalComponent extends ContactModalComponentCommon {
    public AndroidContactModalComponent(WebDriver driver) {
        super(driver);
    }
}