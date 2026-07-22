package ua.solvd.demoblaze.impl;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.demoblaze.BaseTest;
import ua.solvd.demoblaze.pages.impl.ContactModalComponentCommon;
import ua.solvd.demoblaze.pages.impl.HeaderComponentCommon;
import ua.solvd.demoblaze.pages.impl.HomePageCommon;

public class ContactTest extends BaseTest {

    @Test
    public void verifyContactFormSubmission() {
        HomePageCommon homePage = initPage(getDriver(), HomePageCommon.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened.");
        HeaderComponentCommon header = homePage.getHeader();
        ContactModalComponentCommon contactModal = header.clickContact();
        contactModal.fillContactForm("testuser@example.com", "John Doe", "Hello, this is a test message.");
        contactModal.clickSendMessage();
        String alertMessage = contactModal.acceptMessageSentAlert();
        Assert.assertEquals(alertMessage, "Thanks for the message!!", "Alert text mismatch.");
        Assert.assertTrue(contactModal.isModalClosed(), "Contact modal did not close after alert acceptance.");
        Assert.assertTrue(homePage.isCategoriesMenuDisplayed(), "User is not on the Home page after submission.");
    }
}