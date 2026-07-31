package ua.solvd.demoblaze.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.NativeBrowserPageCommon;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = NativeBrowserPageCommon.class)
public class IOSSafariNativePage extends NativeBrowserPageCommon {

    @ExtendedFindBy(iosPredicate = "type == 'XCUIElementTypeButton' AND (name == 'Tabs' OR name == 'Tab overview' OR name == 'MoreMenuButton')")
    private ExtendedWebElement tabSwitcherButton;

    @ExtendedFindBy(iosPredicate = "type == 'XCUIElementTypeButton' AND (name == 'NewTabButton' OR name == 'Add' OR label == 'New Tab')")
    private ExtendedWebElement newTabButton;

    public IOSSafariNativePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public NativeBrowserPageCommon clickTabSwitcher() {
        tabSwitcherButton.click();
        return this;
    }

    @Override
    public NativeBrowserPageCommon clickNewTab() {
        newTabButton.click();
        return this;
    }
}