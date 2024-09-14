package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import io.cucumber.java.Scenario;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Functions {

    private static final WebElement False = null;
    //Config Config = new Config();
    //String ExcelPath = Config.ExcelPath;
    //XSSFWorkbook wb;
    //XSSFSheet Hoja1;
    File src;
    String URLInicial;
    String ruta;
    String NAVEGADOR;
    ConfigFileReader configFileReader = new ConfigFileReader();


//#########################################################
//##################### DRIVERS ###########################
//#########################################################

    public WebDriver AbrirNavegador() {

        WebDriver driver;
        String browser = configFileReader.getBrowser();

        if (browser.equals("chrome")) {
            // Configura el path del driver de Chrome
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
            ChromeOptions options = new ChromeOptions();
            // Configura el path al binario de Chrome
            options.setBinary("/usr/bin/google-chrome");

            // Para ejecutar la prueba sin que se abra el navegador leyendo desde properties
            options.addArguments(configFileReader.setVisibleBrowser());

            // Para evitar excepciones de seguridad
            options.setAcceptInsecureCerts(true);

            options.addArguments("user-data-dir=/home/juancho/Automation/temp-chrome-profile"); // Usa el perfil temporal


            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            return driver;

        } else if (browser.equals("firefox")) {
            // Configura el path del driver de Firefox (geckodriver)
            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
            // Desactiva los logs del navegador
            //	System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            FirefoxOptions options = new FirefoxOptions();
            // Configura el path al binario de Firefox
            options.setBinary("/usr/bin/firefox");

            // Para ejecutar la prueba sin que se abra el navegador leyendo desde properties
            options.addArguments(configFileReader.setVisibleBrowser());

            // Para evitar excepciones de seguridad
            options.setAcceptInsecureCerts(true);

            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            return driver;

        } else if (browser.equals("ie")) {
            System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer32.exe");
            InternetExplorerOptions options = new InternetExplorerOptions();
            // Para evitar excepciones de seguridad
            options.setAcceptInsecureCerts(true);
            driver = new InternetExplorerDriver(options);
            driver.manage().window().maximize();
            return driver;
        } else {
            System.out.println("AbrirNavegador: Actualiza tus drivers");
            return null;
        }
    }

    public void CerrarNavegador(WebDriver driver) {
        driver.quit();
    }

    //#########################################################
//##################### SCREENSHOTS ###########################
//#########################################################

    // Método para capturar la captura de pantalla basado en el nombre del escenario y su estado
//    public static String takeScreenshot(String scenarioName, WebDriver driver, String resultStatus) {
//        String destination = null;
//        try {
//            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//            String dir = System.getProperty("user.dir") + File.separator + "target" + File.separator + "Screenshot" + resultStatus;
//            File directory = new File(dir);
//            directory.mkdir();
//
//            destination = dir + File.separator + timeStamp + "_" + scenarioName + ".jpg";
//            System.out.println(resultStatus + ": " + driver.getCurrentUrl());
//
//            Screenshot screenshot = new AShot()
//                    .shootingStrategy(ShootingStrategies.viewportPasting(1000))
//                    .takeScreenshot(driver);
//            ImageIO.write(screenshot.getImage(), "PNG", new File(destination));
//
//        } catch (IOException e) {
//            System.out.println("Error trying to save screenshot: " + e.getMessage());
//        }
//        return destination;
//    }

    //#########################################################
    //#######################SCROLL############################
    //#########################################################

    public void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + element.getLocation().y + ")");
    }

    //#########################################################
    //#######################REPORTES##########################
    //#########################################################

//    public ExtentReports generarReporte(ExtentReports extent) {
//        //ExtentReports(String filePath,Boolean replaceExisting)
//        //filepath - path of the file, in .htm or .html format - path where your report needs to generate.
//        //replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
//        //True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
//        //False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
//        extent = new ExtentReports(System.getProperty("user.dir") + File.separator + "target" + File.separator + "STMExtentReport.html", false);
//        //extent.addSystemInfo("Environment","Environment Name")
//        extent
//                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
//                .addSystemInfo("Environment", "Entorno Testing")
//                .addSystemInfo("User Name", "Juan Tognoli");
//        //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
//        //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
//        extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
//
//        return extent;
//    }

//    public void sendLogAndScreens(ExtentTest logger, WebDriver driver, ExtentReports extent, Scenario scenario) {
//        if (scenario.isFailed()) {
//            logger.log(LogStatus.FAIL, "Test Case Failed: " + scenario.getName());
//            logger.log(LogStatus.FAIL, "Reason: " + scenario.getStatus());
//            String screenshotPath = takeScreenshot(scenario.getName(), driver, "Failure");
//            logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
//        } else {
//            logger.log(LogStatus.PASS, "Test Case Passed: " + scenario.getName());
//            String screenshotPath = takeScreenshot(scenario.getName(), driver, "Success");
//            logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
//        }
//
//        // Finaliza el test en el reporte
//        extent.endTest(logger);
//    }

//    public void finalizaReporte(ExtentReports extent) {
//        // writing everything to document
//        //flush() - to write or update test information to your report.
//        extent.flush();
//        //Call close() at the very end of your session to clear all resources.
//        //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
//        //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream.
//        //Once this method is called, calling any Extent method will throw an error.
//        //close() - To close all the operation
//        extent.close();
//    }


}



