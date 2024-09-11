package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    // Definición de elementos
    private By usernameInput = By.cssSelector("[data-test='username']");
    private By passwordInput = By.cssSelector("[data-test='password']");
    private By loginSubmitButton = By.cssSelector("[data-test='login-button']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
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
}
