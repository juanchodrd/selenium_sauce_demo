package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    // Definición de elementos
    private By usernameInput = By.cssSelector("[data-test='username']");
    private By passwordInput = By.cssSelector("[data-test='password']");
    private By loginSubmitButton = By.cssSelector("[data-test='login-button']");
    private By textLoginIncorrecto = By.cssSelector("[data-test='error-button']");

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Método ingresar a url
    public void goToUrl() {
        driver.get("https://www.saucedemo.com/");
    }

    // Método para ingresar el nombre de usuario
    public void enterUsername(String value) {
        WebElement usernameElement = driver.findElement(usernameInput);
        usernameElement.sendKeys(value);
    }

    // Método para ingresar la contraseña
    public void enterPassword(String value) {
        WebElement passwordElement = driver.findElement(passwordInput);
        passwordElement.sendKeys(value);
    }

    // Método para hacer clic en el botón de login
    public void submitLogin() {
        WebElement loginButtonElement = driver.findElement(loginSubmitButton);
        loginButtonElement.click();
    }

    // Método que encapsula el flujo de login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        submitLogin();
    }

    // metodo para obtener url actual
    public void validateLogin() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("La URL contiene 'inventory.html'", currentUrl.contains("inventory.html"));
    }

    // Method to verify incorrect login message is visible and contains the expected text
    public void verifyIncorrectLogin() {
        // Wait for the error message to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 seconds timeout
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(textLoginIncorrecto));

        // Verify the text of the error message
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualMessage = errorMessage.getText();

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Error message is displayed correctly: " + actualMessage);
        } else {
            System.out.println("Error message is incorrect. Found: " + actualMessage);
        }
    }


}
