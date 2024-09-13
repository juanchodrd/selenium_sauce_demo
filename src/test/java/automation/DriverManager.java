package automation;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import utils.ConfigFileReader;
import utils.Functions;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;
    private static Functions selenium = new Functions();
    private static ExtentReports extent;
    private static ExtentTest logger;
    private static ConfigFileReader configFileReader = new ConfigFileReader();

    public static void initialize() {
        if (driver == null) {
            driver = selenium.AbrirNavegador();
            extent = selenium.generarReporte(extent);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static ExtentTest getLogger() {
        return logger;
    }

    public static void setLogger(ExtentTest logger) {
        DriverManager.logger = logger;
    }

    public static void close() throws Exception {
        if (driver != null) {
            selenium.sendLogAndScreens(logger, driver, extent, null); // Puedes pasar `null` si no tienes un escenario
            selenium.CerrarNavegador(driver);
            driver = null;
        }
        selenium.finalizaReporte(extent);
    }
}
