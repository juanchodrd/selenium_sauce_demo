package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailProductPage {

    // Definición de elementos
    private By cartSelector = By.cssSelector("[data-test='add-to-cart']");
    private By productTitleSelector = By.cssSelector("[data-test='inventory-item-name']");

    WebDriver driver;

    //constructor
    public DetailProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Método para añadir producto al carrito
    public void addToCart() {
        driver.findElement(cartSelector).click();
    }

    // Método para validar el título del producto
    public void validateProductTitle(String expectedTitle) {
        // Localiza el elemento del título del producto
        WebElement productTitleElement = driver.findElement(productTitleSelector);

        // Obtén el texto del título del producto
        String actualTitle = productTitleElement.getText();

        // Verifica que el título del producto contiene el texto esperado
        Assert.assertTrue("El título del producto contiene el valor esperado. Título actual: " + actualTitle,
                actualTitle.contains(expectedTitle));
    }


}