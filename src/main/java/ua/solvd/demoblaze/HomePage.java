package ua.solvd.demoblaze;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.solvd.demoblaze.pages.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = ".list-group a")
    private List<WebElement> categories;

    @FindBy(css = ".hrefch")
    private List<WebElement> products;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void selectCategory(String categoryName) {
        waitForElementsVisibility(categories, "Categories Sidebar");
        WebElement targetCategory = categories.stream()
                .filter(category -> category.getText().trim().equalsIgnoreCase(categoryName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Category with name '" + categoryName + "' was not found on the page."));
        clickElement(targetCategory, "Category: " + categoryName);
    }

    public void selectProduct(String productName) {
        waitForElementsVisibility(products, "Products Grid");
        WebElement targetProduct = products.stream()
                .filter(product -> product.getText().trim().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product with name '" + productName + "' was not found on the page."));
        clickElement(targetProduct, "Product: " + productName);
    }
}