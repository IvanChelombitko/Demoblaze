package ua.solvd.demoblaze.impl;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.demoblaze.BaseTest;
import ua.solvd.demoblaze.model.User;
import ua.solvd.demoblaze.pages.impl.HeaderComponent;
import ua.solvd.demoblaze.pages.impl.HomePage;
import ua.solvd.demoblaze.pages.impl.LoginModalComponent;
import ua.solvd.demoblaze.util.UserService;

public class LoginTest extends BaseTest {

    @Test
    public void verifySuccessfulUserLogin() {
        User user = UserService.createPredefinedUser();
        HomePage homePage = new HomePage(getDriver()).open();
        HeaderComponent header = homePage.getHeader();
        LoginModalComponent loginModal = header.clickLogIn();
        loginModal.fillLoginForm(user.username(), user.password())
                .clickLogInButton();
        Assert.assertTrue(loginModal.isModalClosed(), "Login modal did not close after log in.");
        Assert.assertTrue(header.isWelcomeMessageDisplayed(), "Welcome message is not displayed.");
        Assert.assertEquals(header.getWelcomeMessageText(), "Welcome " + user.username(), "Welcome message text is incorrect.");
        Assert.assertTrue(header.isLogOutLinkDisplayed(), "Log out link is not displayed.");
        Assert.assertTrue(header.isLogInLinkInvisible(), "Log in link is still visible.");
        Assert.assertTrue(header.isSignUpLinkInvisible(), "Sign up link is still visible.");
    }
}