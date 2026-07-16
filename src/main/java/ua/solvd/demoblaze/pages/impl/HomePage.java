package ua.solvd.demoblaze.pages.impl;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.enums.Category;
import ua.solvd.demoblaze.enums.Product;
import ua.solvd.demoblaze.pages.BasePage;
import ua.solvd.demoblaze.util.ConfigReader;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = ".list-group a")
    private List<WebElement> categories;

    @FindBy(css = ".hrefch")
    private List<WebElement> products;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        String demoblazeUrl = ConfigReader.getProperty("base.url");
        driver.get(demoblazeUrl);
        return this;
    }

    public HomePage selectCategory(Category category) {
        waitForListToLoad(categories, "Categories Sidebar");
        WebElement targetCategory = categories.stream()
                .filter(c -> c.getText().trim().equalsIgnoreCase(category.getName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Category with name '" + category.getName() + "' was not found on the page."));
        clickElement(targetCategory, "Category: " + category.getName());
        return this;
    }

    public ProductPage selectProduct(Product product) {
        waitForListToLoad(products, "Products Grid");
        WebElement targetProduct = products.stream()
                .filter(p -> p.getText().trim().equalsIgnoreCase(product.getName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product with name '" + product.getName() + "' was not found on the page."));
        clickElement(targetProduct, "Product: " + product.getName());
        return new ProductPage(driver);
    }
}