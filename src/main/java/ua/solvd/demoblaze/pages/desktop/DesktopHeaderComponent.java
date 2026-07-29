package ua.solvd.demoblaze.pages.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.HeaderComponent;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HeaderComponent.class)
public class DesktopHeaderComponent extends HeaderComponent {
    public DesktopHeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}