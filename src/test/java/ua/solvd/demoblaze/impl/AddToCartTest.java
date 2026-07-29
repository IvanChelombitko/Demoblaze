package ua.solvd.demoblaze.impl;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.demoblaze.BaseTest;
import ua.solvd.demoblaze.model.Category;
import ua.solvd.demoblaze.model.Product;
import ua.solvd.demoblaze.pages.impl.CartPageCommon;
import ua.solvd.demoblaze.pages.impl.HeaderComponentCommon;
import ua.solvd.demoblaze.pages.impl.HomePageCommon;
import ua.solvd.demoblaze.pages.impl.ProductPageCommon;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyAddingProductToCart() {
        HomePageCommon homePage = initPage(getDriver(), HomePageCommon.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened.");
        ProductPageCommon productPage = homePage
                .selectCategory(Category.PHONES)
                .selectProduct(Product.SAMSUNG_GALAXY_S6);
        productPage.clickAddToCart();
        String alertMessage = productPage.acceptProductAddedAlert();
        Assert.assertEquals(alertMessage, "Product added", "Alert text has wrong content.");
        HeaderComponentCommon header = homePage.getHeader();
        CartPageCommon cartPage = header.clickCart();
        Assert.assertEquals(cartPage.getCartItemsCount(), 1, "Cart should contain exactly 1 item.");
        Assert.assertEquals(cartPage.getFirstCartItemName(), Product.SAMSUNG_GALAXY_S6.getName(), "Name mismatch.");
        Assert.assertEquals(cartPage.getFirstCartItemPrice(), Product.SAMSUNG_GALAXY_S6.getPrice(), "Price mismatch.");
    }
}