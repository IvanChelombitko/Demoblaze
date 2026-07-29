package ua.solvd.demoblaze.pages.impl.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.impl.SignUpModalComponentCommon;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignUpModalComponentCommon.class)
public class AndroidSignUpModalComponent extends SignUpModalComponentCommon {
    public AndroidSignUpModalComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickSignUpButton() {
        signUpButton.scrollTo();
        signUpButton.clickByJs();
    }
}