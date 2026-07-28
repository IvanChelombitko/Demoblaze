package ua.solvd.demoblaze.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.CommonBasePage;
import ua.solvd.demoblaze.pages.HeaderComponentCommon;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CommonBasePage.class)
public class AndroidCommonBasePage extends CommonBasePage {

    @FindBy(css = "#navbarExample")
    private AndroidHeaderComponent header;

    public AndroidCommonBasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponentCommon getHeader() {
        return header;
    }
}