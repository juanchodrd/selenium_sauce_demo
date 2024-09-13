package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductsPage {
    private WebDriver driver;

    //constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Definición de elementos
    private By menuButton = By.id("[id='react-burger-menu-btn']");
    private By productSelector = By.cssSelector("[data-test='inventory-item-name']");

    // Método para seleccionar un producto
    public void selectProduct(String productName) {
        // Encuentra el producto por nombre y haz clic en él
        WebElement product = driver.findElements(productSelector).stream()
                .filter(element -> element.getText().equals(productName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found: " + productName));
        product.click();
    }
}