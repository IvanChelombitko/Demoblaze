package ua.solvd.demoblaze.pages.impl.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.impl.ProductPageCommon;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageCommon.class)
public class DesktopProductPage extends ProductPageCommon {
    public DesktopProductPage(WebDriver driver) {
        super(driver);
    }
}