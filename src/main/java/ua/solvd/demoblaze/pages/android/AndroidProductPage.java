package ua.solvd.demoblaze.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.ProductPageCommon;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageCommon.class)
public class AndroidProductPage extends ProductPageCommon {
    public AndroidProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickAddToCart() {
        addToCartButton.scrollTo();
        addToCartButton.clickByJs();
    }
}