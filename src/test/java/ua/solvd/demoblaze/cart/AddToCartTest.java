package ua.solvd.demoblaze.cart;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.demoblaze.*;
import ua.solvd.demoblaze.enums.Category;
import ua.solvd.demoblaze.enums.Product;
import ua.solvd.demoblaze.pages.HeaderComponent;

public class AddToCartTest extends BaseClassTest {

    @Test
    public void verifyAddingProductToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.selectCategory(Category.PHONES.getName());
        homePage.selectProduct(Product.SAMSUNG_GALAXY_S6.getName());
        ProductPage productPage = new ProductPage(getDriver());
        productPage.clickAddToCart();
        String alertMessage = productPage.getAlertTextAndAccept();
        Assert.assertEquals(alertMessage, "Product added", "Alert text has wrong content.");
        HeaderComponent header = new HeaderComponent(getDriver());
        header.clickCart();
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertTrue(cartPage.isProductInCart(Product.SAMSUNG_GALAXY_S6.getName()), "Product is absent in the cart.");
    }
}