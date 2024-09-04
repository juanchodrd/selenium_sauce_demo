package automation;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import dataProvider.ConfigFileReader;
import functions.Functions;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;


public class loginTest {
	WebDriver driver;
	Functions Selenium = new Functions();
	ITestResult testResult;
	ExtentReports extent;
	ExtentTest logger;
	//Para poder leer el archivo de propiedades
	ConfigFileReader configFileReader= new ConfigFileReader();
	LoginPage loginPage;


	@BeforeMethod
	public void setUp() {
		driver = Selenium.AbrirNavegador();
		driver.get(configFileReader.getApplicationUrl());
		extent=Selenium.generarReporte(extent);


	}


	@Test
	public void testLogin() {
		loginPage = new LoginPage(driver);
		logger = extent.startTest("Comienzo caso de prueba");
		logger.log(LogStatus.INFO, "Ingreso usuario");
		loginPage.login("standard_user", "secret_sauce");


	}

	@AfterMethod
	public void TearDown() throws Exception {
		Selenium.CerrarNavegador(driver);
	}


}
