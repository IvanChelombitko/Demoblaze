package ua.solvd.demoblaze.mobile;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.demoblaze.BaseTest;
import ua.solvd.demoblaze.pages.HomePageCommon;
import ua.solvd.demoblaze.util.MobileContextService;

public class ContextSwitchTest extends BaseTest {

    @Test
    public void verifyNativeContextSwitch() {
        HomePageCommon homePage = initPage(getDriver(), HomePageCommon.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened.");
        MobileContextService.switchContextToNative(getDriver());
        MobileContextService.switchContextToWebView(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Failed to return to the web context.");
    }
}