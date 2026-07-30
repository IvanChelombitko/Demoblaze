package ua.solvd.demoblaze.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.demoblaze.pages.ProductPageCommon;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageCommon.class)
public class IOSProductPage extends ProductPageCommon {
    public IOSProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickAddToCart() {
        addToCartButton.click();
    }
}