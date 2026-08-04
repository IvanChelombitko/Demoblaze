package ua.solvd.demoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.constant.Constants;
import ua.solvd.demoblaze.model.Category;
import ua.solvd.demoblaze.model.Product;

import java.util.List;

public class HomePageCommon extends BasePage {

    @FindBy(css = ".list-group a")
    protected List<ExtendedWebElement> categories;

    @FindBy(css = ".hrefch")
    protected List<ExtendedWebElement> products;

    @FindBy(css = ".list-group")
    protected ExtendedWebElement categoriesMenu;

    @FindBy(css = ".hrefch")
    protected ExtendedWebElement firstProductIndicator;

    public HomePageCommon(WebDriver driver) {
        super(driver);
    }

    public HomePageCommon selectCategory(Category category) {
        if (!categoriesMenu.isElementPresent(Constants.MINIMUM_TIMEOUT)) {
            throw new RuntimeException("Categories menu did not load within the timeout.");
        }
        ExtendedWebElement targetCategory = categories.stream()
                .filter(c -> c.getText().trim().equalsIgnoreCase(category.getName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Category with name '" + category.getName() + "' was not found on the page."));
        targetCategory.click();
        return this;
    }

    public ProductPageCommon selectProduct(Product product) {
        if (!firstProductIndicator.isElementPresent(Constants.MINIMUM_TIMEOUT)) {
            throw new RuntimeException("Products list did not load within the timeout.");
        }
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