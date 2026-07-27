package ua.solvd.demoblaze.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.HomePageCommon;
import ua.solvd.demoblaze.pages.LoginModalComponentCommon;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginModalComponentCommon.class)
public class AndroidLoginModalComponent extends LoginModalComponentCommon {
    public AndroidLoginModalComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageCommon clickLogInButton() {
        logInButton.scrollTo();
        logInButton.clickByJs();
        return initPage(getDriver(), HomePageCommon.class);
    }
}