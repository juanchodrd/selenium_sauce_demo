package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pages.DetailProductPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverManager;

public class selectProductSteps {
    private LoginPage loginPage = new LoginPage(DriverManager.getDriver()); // Pasar el WebDriver desde DriverManager
    private ProductsPage productsPage = new ProductsPage(DriverManager.getDriver());
    private DetailProductPage detailProductPage = new DetailProductPage(DriverManager.getDriver());

    @Step("The user is on products page")
    @Given("que estoy en la pagina de seleccion de productos")
    public void que_estoy_en_la_página_de_seleccion_de_productos() {
        loginPage.validateLogin();
    }

    @And("selecciono el producto {string}")
    public void selecciono_el_producto(String productName) {
        productsPage.selectProduct(productName);
    }

    @Then("debería ver el detalle del producto seleccionado {string}")
    public void deberíaVerElDetalleDelProductoSeleccionado(String productName) {
        detailProductPage.validateProductTitle(productName);
    }
}
