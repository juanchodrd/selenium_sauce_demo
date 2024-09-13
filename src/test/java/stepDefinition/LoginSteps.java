package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import automation.DriverManager;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage(DriverManager.getDriver()); // Pasar el WebDriver desde DriverManager

    @Given("que estoy en la página de login")
    public void que_estoy_en_la_pagina_de_login() {
        loginPage.goToUrl();
    }

    @When("ingreso el usuario {string} y la contraseña {string}")
    public void ingreso_el_usuario_y_la_contraseña(String usuario, String contraseña) {
        loginPage.login(usuario, contraseña);
    }

    @Then("debería ver la página de productos")
    public void deberia_ver_la_pagina_de_productos() {
        loginPage.validateLogin();
    }
}
