package ua.solvd.demoblaze.impl;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.demoblaze.BaseTest;
import ua.solvd.demoblaze.model.Category;
import ua.solvd.demoblaze.model.Product;
import ua.solvd.demoblaze.pages.impl.CartPage;
import ua.solvd.demoblaze.pages.impl.HeaderComponent;
import ua.solvd.demoblaze.pages.impl.HomePage;
import ua.solvd.demoblaze.pages.impl.ProductPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyAddingProductToCart() {
        HomePage homePage = new HomePage(getDriver()).open();
        ProductPage productPage = homePage
                .selectCategory(Category.PHONES)
                .selectProduct(Product.SAMSUNG_GALAXY_S6);
        productPage.clickAddToCart();
        String alertMessage = productPage.acceptProductAddedAlert();
        Assert.assertEquals(alertMessage, "Product added", "Alert text has wrong content.");
        HeaderComponent header = homePage.getHeader();
        CartPage cartPage = header.clickCart();
        Assert.assertEquals(cartPage.getCartItemsCount(), 1, "Cart should contain exactly 1 item.");
        Assert.assertEquals(cartPage.getFirstCartItemName(), Product.SAMSUNG_GALAXY_S6.getName(), "Name mismatch.");
        Assert.assertEquals(cartPage.getFirstCartItemPrice(), Product.SAMSUNG_GALAXY_S6.getPrice(), "Price mismatch.");
    }
}