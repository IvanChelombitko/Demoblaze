package ua.solvd.demoblaze;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = ".list-group a")
    private List<WebElement> categories;

    @FindBy(css = ".hrefch")
    private List<WebElement> products;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void selectCategory(String categoryName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(categories));
        WebElement targetCategory = categories.stream()
                .filter(category -> category.getText().trim().equalsIgnoreCase(categoryName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Category with name '" + categoryName + "' was not found on the page."));
        targetCategory.click();
    }

    public void selectProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(products));
        WebElement targetProduct = products.stream()
                .filter(product -> product.getText().trim().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product with name '" + productName + "' was not found on the page."));
        targetProduct.click();
    }
}