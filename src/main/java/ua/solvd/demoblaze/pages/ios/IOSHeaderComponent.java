package ua.solvd.demoblaze.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.HeaderComponent;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HeaderComponent.class)
public class IOSHeaderComponent extends HeaderComponent {
    public IOSHeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}