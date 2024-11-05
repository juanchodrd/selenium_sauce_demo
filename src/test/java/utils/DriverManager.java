package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;
    private static Functions selenium = new Functions();

    public static void initialize() {
        if (driver == null) {
            driver = selenium.AbrirNavegador();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void close() {
        if (driver != null) {
            selenium.CerrarNavegador(driver);
            driver = null;
        }
    }
}
