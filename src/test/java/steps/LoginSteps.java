package steps;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import automation.testBase;

public class LoginSteps extends testBase {
    LoginPage loginPage;
    private final WebDriver driver = new ChromeDriver();

    @Given("que estoy en la página de login")
    public void que_estoy_en_la_pagina_de_login() {
        loginPage = new LoginPage(driver);
        loginPage.goToUrl();
    }

    @When("ingreso el usuario {string} y la contraseña {string}")
    public void ingreso_el_usuario_y_la_contraseña(String usuario, String contraseña) {
        loginPage.login(usuario, contraseña);
    }

    @Then("debería ver la página de productos")
    public void deberia_ver_la_pagina_de_productos() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("La URL contiene 'inventory.html'", currentUrl.contains("inventory.html"));
    }
}
