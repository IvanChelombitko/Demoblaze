package ua.solvd.demoblaze.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.constant.Constants;
import ua.solvd.demoblaze.pages.CartPageCommon;
import ua.solvd.demoblaze.pages.ContactModalComponentCommon;
import ua.solvd.demoblaze.pages.HeaderComponent;
import ua.solvd.demoblaze.pages.LoginModalComponentCommon;
import ua.solvd.demoblaze.pages.SignUpModalComponentCommon;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HeaderComponent.class)
public class AndroidHeaderComponent extends HeaderComponent {

    @FindBy(css = ".navbar-toggler")
    private ExtendedWebElement hamburgerMenu;

    public AndroidHeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    private void expandMenu() {
        if (hamburgerMenu.isElementPresent(Constants.MINIMUM_TIMEOUT)) {
            hamburgerMenu.clickByJs();
            pause(Constants.MINIMUM_TIMEOUT);
        }
    }

    @Override
    public CartPageCommon clickCart() {
        expandMenu();
        cartNavLink.click();
        return initPage(getDriver(), CartPageCommon.class);
    }

    @Override
    public ContactModalComponentCommon clickContact() {
        expandMenu();
        contactLink.clickByJs();
        return initPage(getDriver(), ContactModalComponentCommon.class);
    }

    @Override
    public SignUpModalComponentCommon clickSignUp() {
        expandMenu();
        signUpLink.click();
        return initPage(getDriver(), SignUpModalComponentCommon.class);
    }

    @Override
    public LoginModalComponentCommon clickLogIn() {
        expandMenu();
        logInLink.click();
        return initPage(getDriver(), LoginModalComponentCommon.class);
    }
}