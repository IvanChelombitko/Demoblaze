package ua.solvd.demoblaze.pages.impl.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.impl.LoginModalComponentCommon;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginModalComponentCommon.class)
public class AndroidLoginModalComponent extends LoginModalComponentCommon {
    public AndroidLoginModalComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickLogInButton() {
        logInButton.scrollTo();
        logInButton.clickByJs();
    }
}