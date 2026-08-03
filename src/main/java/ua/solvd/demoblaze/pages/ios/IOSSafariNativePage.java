package ua.solvd.demoblaze.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.NativeBrowserPage;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = NativeBrowserPage.class)
public class IOSSafariNativePage extends NativeBrowserPage {

    @ExtendedFindBy(iosPredicate = "type == 'XCUIElementTypeButton' AND (name == 'Tabs' OR name == 'Tab overview' OR name == 'MoreMenuButton')")
    private ExtendedWebElement tabSwitcherButton;

    @ExtendedFindBy(iosPredicate = "type == 'XCUIElementTypeButton' AND (name == 'NewTabButton' OR name == 'Add' OR label == 'New Tab')")
    private ExtendedWebElement newTabButton;

    public IOSSafariNativePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public NativeBrowserPage clickTabSwitcher() {
        tabSwitcherButton.click();
        return this;
    }

    @Override
    public NativeBrowserPage clickNewTab() {
        newTabButton.click();
        return this;
    }
}