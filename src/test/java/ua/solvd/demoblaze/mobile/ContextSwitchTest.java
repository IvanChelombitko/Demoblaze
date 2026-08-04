package ua.solvd.demoblaze.mobile;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.demoblaze.BaseTest;
import ua.solvd.demoblaze.pages.HomePageCommon;
import ua.solvd.demoblaze.pages.NativeBrowserPage;
import ua.solvd.demoblaze.util.MobileContextService;

public class ContextSwitchTest extends BaseTest {

    @Test
    public void verifySwitchBetweenWebViewAndNativeContext() {
        HomePageCommon homePage = initPage(getDriver(), HomePageCommon.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened.");
        MobileContextService.switchContextToNative(getDriver());
        NativeBrowserPage nativeBrowserPage = initPage(getDriver(), NativeBrowserPage.class);
        nativeBrowserPage.clickTabSwitcher().clickNewTab();
        MobileContextService.switchContextToWebView(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Failed to load page in the new tab after returning to web context.");
    }
}