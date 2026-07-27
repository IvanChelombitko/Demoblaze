package ua.solvd.demoblaze.common;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.demoblaze.BaseTest;
import ua.solvd.demoblaze.model.User;
import ua.solvd.demoblaze.pages.HeaderComponentCommon;
import ua.solvd.demoblaze.pages.HomePageCommon;
import ua.solvd.demoblaze.pages.LoginModalComponentCommon;
import ua.solvd.demoblaze.util.UserService;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void verifyLoginFailsWithInvalidCredentials() {
        User user = UserService.createUniqueUserWithDefaultPassword();
        HomePageCommon homePage = initPage(getDriver(), HomePageCommon.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened.");
        HeaderComponentCommon header = homePage.getHeader();
        LoginModalComponentCommon loginModal = header.clickLogIn();
        loginModal.fillLoginForm(user.username(), user.password())
                .clickLogInButton();
        String alertMessage = loginModal.acceptLoginAlert();
        Assert.assertEquals(alertMessage, "User does not exist.", "Alert text mismatch for invalid login.");
        Assert.assertFalse(header.isWelcomeMessageDisplayed(), "Welcome message should not be displayed after failed login.");
    }
}