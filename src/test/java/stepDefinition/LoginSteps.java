package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.DriverManager;
import io.qameta.allure.Step;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage(DriverManager.getDriver()); // Pasar el WebDriver desde DriverManager

    @Step("The user is on the login page")
    @Given("que estoy en la página de login")
    public void que_estoy_en_la_pagina_de_login() {
        loginPage.goToUrl();
    }

    @Step("User enters username {0} and password {1}")
    @When("ingreso el usuario {string} y la contraseña {string}")
    public void ingreso_el_usuario_y_la_contraseña(String usuario, String contraseña) {
        loginPage.login(usuario, contraseña);
    }

    @Step("User should see the dashboard")
    @Then("debería ver la página de productos")
    public void deberia_ver_la_pagina_de_productos() {
        loginPage.validateLogin();
    }

    @Then("debería ver un mensaje de error")
    public void deberíaVerUnMensajeDeError() {
        // Validate that the error message is displayed
        loginPage.verifyIncorrectLogin();
    }

}
