package ua.solvd.demoblaze.impl;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.demoblaze.BaseTest;
import ua.solvd.demoblaze.model.User;
import ua.solvd.demoblaze.pages.impl.HeaderComponent;
import ua.solvd.demoblaze.pages.impl.HomePage;
import ua.solvd.demoblaze.pages.impl.SignUpModalComponent;
import ua.solvd.demoblaze.util.UserService;

public class SignUpTest extends BaseTest {

    @Test
    public void verifySuccessfulUserRegistration() {
        User user = UserService.createRandomUser();
        HomePage homePage = new HomePage(getDriver()).open();
        HeaderComponent header = homePage.getHeader();
        SignUpModalComponent signUpModal = header.clickSignUp();
        signUpModal.fillSignUpForm(user.username(), user.password());
        signUpModal.clickSignUpButton();
        String alertMessage = signUpModal.acceptSignUpAlert();
        Assert.assertEquals(alertMessage, "Sign up successful.", "Alert text mismatch.");
        Assert.assertTrue(signUpModal.isModalClosed(), "Sign up modal did not close after alert acceptance.");
    }
}