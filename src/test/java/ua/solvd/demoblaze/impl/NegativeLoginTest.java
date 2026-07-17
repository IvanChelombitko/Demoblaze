package ua.solvd.demoblaze.impl;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.demoblaze.BaseTest;
import ua.solvd.demoblaze.model.User;
import ua.solvd.demoblaze.pages.impl.HeaderComponent;
import ua.solvd.demoblaze.pages.impl.HomePage;
import ua.solvd.demoblaze.pages.impl.LoginModalComponent;
import ua.solvd.demoblaze.util.UserService;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void verifyLoginFailsWithInvalidCredentials() {
        User user = UserService.createRandomUser();
        HomePage homePage = new HomePage(getDriver()).open();
        HeaderComponent header = homePage.getHeader();
        LoginModalComponent loginModal = header.clickLogIn();
        loginModal.fillLoginForm(user.username(), user.password())
                .clickLogInButton();
        String alertMessage = loginModal.acceptLoginAlert();
        Assert.assertEquals(alertMessage, "User does not exist.", "Alert text mismatch for invalid login.");
        Assert.assertFalse(header.isWelcomeMessageDisplayed(), "Welcome message should not be displayed after failed login.");
    }
}