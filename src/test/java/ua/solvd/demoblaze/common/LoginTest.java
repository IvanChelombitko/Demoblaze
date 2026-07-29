package ua.solvd.demoblaze.common;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.demoblaze.BaseTest;
import ua.solvd.demoblaze.model.User;
import ua.solvd.demoblaze.pages.HeaderComponent;
import ua.solvd.demoblaze.pages.HomePageCommon;
import ua.solvd.demoblaze.util.UserService;

public class LoginTest extends BaseTest {

    @Test
    public void verifySuccessfulUserLogin() {
        User user = UserService.createPredefinedUser();
        HomePageCommon homePage = initPage(getDriver(), HomePageCommon.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened.");
        homePage = homePage.getHeader().clickLogIn()
                .fillLoginForm(user.username(), user.password())
                .clickLogInButton();
        HeaderComponent header = homePage.getHeader();
        Assert.assertTrue(header.isWelcomeMessageDisplayed(), "Welcome message is not displayed.");
        Assert.assertEquals(header.getWelcomeMessageText(), "Welcome " + user.username(), "Welcome message text is incorrect.");
        Assert.assertTrue(header.isLogOutLinkDisplayed(), "Log out link is not displayed.");
        Assert.assertTrue(header.waitUntilLogInLinkDisappears(), "Log in link is still visible.");
        Assert.assertTrue(header.waitUntilSignUpLinkDisappears(), "Sign up link is still visible.");
    }
}