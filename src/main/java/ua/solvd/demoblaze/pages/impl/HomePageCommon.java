package ua.solvd.demoblaze.pages.impl;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import jdk.jfr.Name;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.model.Category;
import ua.solvd.demoblaze.model.Product;
import ua.solvd.demoblaze.pages.BasePage;

import java.util.List;

public abstract class HomePageCommon extends BasePage {

    @Name("Categories")
    @FindBy(css = ".list-group a")
    protected List<ExtendedWebElement> categories;

    @Name("Products")
    @FindBy(css = ".hrefch")
    protected List<ExtendedWebElement> products;

    @Name("Categories Menu")
    @FindBy(css = ".list-group")
    protected ExtendedWebElement categoriesMenu;

    @FindBy(css = ".hrefch")
    protected ExtendedWebElement firstProductIndicator;

    public HomePageCommon(WebDriver driver) {
        super(driver);
    }

    public HeaderComponentCommon getHeader() {
        return initPage(getDriver(), HeaderComponentCommon.class);
    }

    public HomePageCommon selectCategory(Category category) {
        categoriesMenu.isElementPresent(MINIMUM_TIMEOUT);
        ExtendedWebElement targetCategory = categories.stream()
                .filter(c -> c.getText().trim().equalsIgnoreCase(category.getName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Category with name '" + category.getName() + "' was not found on the page."));
        targetCategory.click();
        return this;
    }

    public ProductPageCommon selectProduct(Product product) {
        firstProductIndicator.isElementPresent(MINIMUM_TIMEOUT);
        ExtendedWebElement targetProduct = products.stream()
                .filter(p -> p.getText().trim().equalsIgnoreCase(product.getName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product with name '" + product.getName() + "' was not found on the page."));
        targetProduct.click();
        return initPage(getDriver(), ProductPageCommon.class);
    }

    public boolean isCategoriesMenuDisplayed() {
        return categoriesMenu.isElementPresent();
    }
}