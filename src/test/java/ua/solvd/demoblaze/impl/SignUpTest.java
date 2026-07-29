package ua.solvd.demoblaze.impl;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.demoblaze.BaseTest;
import ua.solvd.demoblaze.model.User;
import ua.solvd.demoblaze.pages.impl.HeaderComponentCommon;
import ua.solvd.demoblaze.pages.impl.HomePageCommon;
import ua.solvd.demoblaze.pages.impl.SignUpModalComponentCommon;
import ua.solvd.demoblaze.util.UserService;

public class SignUpTest extends BaseTest {

    @Test
    public void verifySuccessfulUserRegistration() {
        User user = UserService.createRandomUser();
        HomePageCommon homePage = initPage(getDriver(), HomePageCommon.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened.");
        HeaderComponentCommon header = homePage.getHeader();
        SignUpModalComponentCommon signUpModal = header.clickSignUp();
        signUpModal.fillSignUpForm(user.username(), user.password());
        signUpModal.clickSignUpButton();
        String alertMessage = signUpModal.acceptSignUpAlert();
        Assert.assertEquals(alertMessage, "Sign up successful.", "Alert text mismatch.");
        Assert.assertTrue(signUpModal.isModalClosed(), "Sign up modal did not close after alert acceptance.");
    }
}