package ua.solvd.demoblaze.pages.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.CommonBasePage;
import ua.solvd.demoblaze.pages.HeaderComponent;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CommonBasePage.class)
public class DesktopCommonBasePage extends CommonBasePage {

    @FindBy(css = "#navbarExample")
    private DesktopHeaderComponent header;

    public DesktopCommonBasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        return header;
    }
}