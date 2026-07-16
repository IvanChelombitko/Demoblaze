package ua.solvd.demoblaze.impl;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.demoblaze.BaseTest;
import ua.solvd.demoblaze.pages.impl.HeaderComponent;
import ua.solvd.demoblaze.pages.impl.HomePage;
import ua.solvd.demoblaze.pages.impl.SignUpModalComponent;

public class SignUpTest extends BaseTest {

    @Test
    public void verifySuccessfulUserRegistration() {
        String uniqueUsername = "TestUser_" + System.currentTimeMillis();
        String password = "StrongPassword123!";
        new HomePage(getDriver()).open();
        HeaderComponent header = new HeaderComponent(getDriver());
        SignUpModalComponent signUpModal = header.clickSignUp();
        signUpModal.fillSignUpForm(uniqueUsername, password);
        signUpModal.clickSignUpButton();
        String alertMessage = signUpModal.acceptSignUpAlert();
        Assert.assertEquals(alertMessage, "Sign up successful.", "Alert text mismatch.");
        Assert.assertTrue(signUpModal.isModalClosed(), "Sign up modal did not close after alert acceptance.");
    }
}