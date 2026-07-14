package ua.solvd.demoblaze.cart;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.demoblaze.*;
import ua.solvd.demoblaze.enums.Category;
import ua.solvd.demoblaze.enums.Product;
import ua.solvd.demoblaze.pages.impl.CartPage;
import ua.solvd.demoblaze.pages.impl.HomePage;
import ua.solvd.demoblaze.pages.impl.ProductPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyAddingProductToCart() {
        ProductPage productPage = new HomePage(getDriver())
                .open()
                .selectCategory(Category.PHONES)
                .selectProduct(Product.SAMSUNG_GALAXY_S6);
        productPage.clickAddToCart();
        String alertMessage = productPage.getAlertTextAndAccept();
        Assert.assertEquals(alertMessage, "Product added", "Alert text has wrong content.");
        CartPage cartPage = productPage.getHeader().clickCart();
        Assert.assertEquals(cartPage.getCartItemsCount(), 1, "Cart should contain exactly 1 item.");
        Assert.assertEquals(cartPage.getFirstCartItemName(), Product.SAMSUNG_GALAXY_S6.getName(), "Name mismatch.");
        Assert.assertEquals(cartPage.getFirstCartItemPrice(), Product.SAMSUNG_GALAXY_S6.getPrice(), "Price mismatch.");
    }
}