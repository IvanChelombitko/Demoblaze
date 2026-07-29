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

public class HomePage extends BasePage {

    @Name("Categories")
    @FindBy(css = ".list-group a")
    private List<ExtendedWebElement> categories;

    @Name("Products")
    @FindBy(css = ".hrefch")
    private List<ExtendedWebElement> products;

    @Name("Categories Menu")
    @FindBy(css = ".list-group")
    private ExtendedWebElement categoriesMenu;

    @FindBy(css = ".hrefch")
    private ExtendedWebElement firstProductIndicator;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent getHeader() {
        return new HeaderComponent(getDriver());
    }

    public HomePage selectCategory(Category category) {
        categoriesMenu.isElementPresent(MINIMUM_TIMEOUT);
        ExtendedWebElement targetCategory = categories.stream()
                .filter(c -> c.getText().trim().equalsIgnoreCase(category.getName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Category with name '" + category.getName() + "' was not found on the page."));
        targetCategory.click();
        return this;
    }

    public ProductPage selectProduct(Product product) {
        firstProductIndicator.isElementPresent(MINIMUM_TIMEOUT);
        ExtendedWebElement targetProduct = products.stream()
                .filter(p -> p.getText().trim().equalsIgnoreCase(product.getName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product with name '" + product.getName() + "' was not found on the page."));
        targetProduct.click();
        return new ProductPage(getDriver());
    }

    public boolean isCategoriesMenuDisplayed() {
        return categoriesMenu.isElementPresent();
    }
}