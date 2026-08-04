package ua.solvd.demoblaze.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.CommonBasePage;
import ua.solvd.demoblaze.pages.HeaderComponent;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CommonBasePage.class)
public class IOSCommonBasePage extends CommonBasePage {

    @FindBy(css = "#navbarExample")
    private IOSHeaderComponent header;

    public IOSCommonBasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        return header;
    }
}