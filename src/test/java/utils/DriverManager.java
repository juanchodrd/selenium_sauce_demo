package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;
    private static Functions selenium = new Functions();
    private static ConfigFileReader configFileReader = new ConfigFileReader();

    public static void initialize() {
        if (driver == null) {
            driver = selenium.AbrirNavegador();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void close(Scenario scenario) throws Exception {
        if (driver != null) {
            selenium.CerrarNavegador(driver);
            driver = null;
        }
    }
}
