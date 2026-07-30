package ua.solvd.demoblaze.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.ContactModalComponentCommon;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ContactModalComponentCommon.class)
public class IOSContactModalComponent extends ContactModalComponentCommon {
    public IOSContactModalComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickSendMessage() {
        sendMessageButton.click();
    }
}