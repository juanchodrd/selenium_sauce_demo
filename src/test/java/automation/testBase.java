package automation;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import dataProvider.ConfigFileReader;
import functions.Functions;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class testBase {
	WebDriver driver;
	Functions Selenium = new Functions();
	ITestResult testResult;
	ExtentReports extent;
	ExtentTest logger;
	//Para poder leer el archivo de propiedades
	ConfigFileReader configFileReader= new ConfigFileReader();

	@BeforeMethod
	public void setUp() {
		driver = Selenium.AbrirNavegador();
		driver.get(configFileReader.getApplicationUrl());
		extent=Selenium.generarReporte(extent);
	}



	@AfterMethod
	public void TearDown(ITestResult testResult) throws Exception {
		// Actualiza `testResult` con el valor proporcionado por TestNG
		Selenium.sendLogAndScreens(testResult, logger, driver, extent);
		Selenium.CerrarNavegador(driver);
	}

	@AfterTest
	public void endReport(){
		Selenium.finalizaReporte(extent);
	}
}
