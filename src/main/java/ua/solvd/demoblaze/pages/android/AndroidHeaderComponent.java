package ua.solvd.demoblaze.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.CartPageCommon;
import ua.solvd.demoblaze.pages.ContactModalComponentCommon;
import ua.solvd.demoblaze.pages.HeaderComponentCommon;
import ua.solvd.demoblaze.pages.LoginModalComponentCommon;
import ua.solvd.demoblaze.pages.SignUpModalComponentCommon;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HeaderComponentCommon.class)
public class AndroidHeaderComponent extends HeaderComponentCommon {

    @FindBy(css = ".navbar-toggler")
    private ExtendedWebElement hamburgerMenu;

    public AndroidHeaderComponent(WebDriver driver) {
        super(driver);
    }

    private void expandMenu() {
        if (hamburgerMenu.isElementPresent(MINIMUM_TIMEOUT)) {
            hamburgerMenu.clickByJs();
            pause(MINIMUM_TIMEOUT);
        }
    }

    @Override
    public CartPageCommon clickCart() {
        expandMenu();
        cartNavLink.isElementPresent(MINIMUM_TIMEOUT);
        cartNavLink.click();
        return initPage(getDriver(), CartPageCommon.class);
    }

    @Override
    public ContactModalComponentCommon clickContact() {
        expandMenu();
        contactLink.isElementPresent(MINIMUM_TIMEOUT);
        contactLink.clickByJs();
        return initPage(getDriver(), ContactModalComponentCommon.class);
    }

    @Override
    public SignUpModalComponentCommon clickSignUp() {
        expandMenu();
        signUpLink.isElementPresent(MINIMUM_TIMEOUT);
        signUpLink.click();
        return initPage(getDriver(), SignUpModalComponentCommon.class);
    }

    @Override
    public LoginModalComponentCommon clickLogIn() {
        expandMenu();
        logInLink.isElementPresent(MINIMUM_TIMEOUT);
        logInLink.click();
        return initPage(getDriver(), LoginModalComponentCommon.class);
    }
}