package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    // Selectors
    private By menuButton = By.id("[id='react-burger-menu-btn']");
    private By productSelector = By.cssSelector("[data-test='inventory-item-name']");
    private By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private String addToCartButton = "[data-test='add-to-cart-";
    private String removeFromCartButton = "[data-test='remove-";
    private int productCount = 0;

    WebDriver driver;

    //constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Método para seleccionar un producto
    public void selectProduct(String productName) {
        // Encuentra el producto por nombre y hace click en el
        WebElement product = driver.findElements(productSelector).stream()
                .filter(element -> element.getText().equals(productName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found: " + productName));
        product.click();
    }

    // Método para agregar un producto al carrito
    public void addProductToCart(String productName) {
        // Convertimos el nombre del producto a un formato compatible con el selector de data-test
        String formattedProductName = productName.toLowerCase().replaceAll("[^a-z0-9]", "-");

        // Selector dinámico para "Add to Cart"
        By addButton = By.cssSelector(this.addToCartButton + formattedProductName + "']");

        // Click en el botón de agregar al carrito
        driver.findElement(addButton).click();

        // Incrementar el contador de productosa
        productCount++;
    }

    // Método para verificar el producto en el carrito
    public void verifyRemoveFromCart(String productName) {
        // Convertimos el nombre del producto a un formato compatible con el selector de data-test
        String formattedProductName = productName.toLowerCase().replaceAll("[^a-z0-9]", "-");
        // Verificar que el botón cambió a "Remove"
        By removeButton = By.cssSelector(this.removeFromCartButton + formattedProductName + "']");
        Assert.assertTrue("El botón no cambió a Remove", driver.findElement(removeButton).isDisplayed());
    }

    // Método para verificar que el badge del carrito se ha actualizado correctamente
    public void verifyCartBadgeUpdated() {
        WebElement cartBadgeElement = driver.findElement(cartBadge);

        // Verificar que el badge está visible
        Assert.assertTrue("El badge del carrito no es visible", cartBadgeElement.isDisplayed());

        // Obtener el número mostrado en el badge
        String badgeCountText = cartBadgeElement.getText();

        // Convertir el texto del badge en un entero
        int actualCount = Integer.parseInt(badgeCountText);

        // Comparar el número del badge con el contador de productos agregados
        Assert.assertEquals("El badge del carrito no refleja el número correcto de productos", productCount, actualCount);
    }

    // Método para vaciar el carrito
    public void clearCartIfNotEmpty() {
        try {
            // Verificar si el carrito tiene productos (si el badge del carrito está visible)
            if (driver.findElement(cartBadge).isDisplayed()) {
                while (true) {
                    WebElement removeButton = driver.findElement(By.cssSelector("[data-test^='remove-']"));
                    removeButton.click();
                }
            }
        } catch (Exception e) {
            // Si no hay más productos en el carrito, terminar
            System.out.println("El carrito ya está vacío.");
        }
    }


}