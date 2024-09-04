package automation;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import dataProvider.ConfigFileReader;
import functions.Functions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class Test1 {
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
		
	
	@Test
	@Parameters({ "ejemplo"})
	
	public void test(@Optional String ejemplo) {		
			logger = extent.startTest("Comienzo caso de prueba");
			logger.log(LogStatus.INFO, "Ingreso a URL...: ");
			driver.get("https://www.google.co.in");
	        String actualTilte = driver.getTitle();
	        if (actualTilte.contains("Google")) {
	            Assert.assertTrue(actualTilte.contains("Google"));
	            System.out.println("OK");
	        }
	else{
		System.out.println("NO OK");
		}
}

	@AfterMethod
	public void TearDown() throws Exception{
        Selenium.sendLogAndScreens(testResult,logger,driver,extent);
        Selenium.CerrarNavegador(driver);

    }
	@AfterTest
	public void endReport(){
		Selenium.finalizaReporte(extent);
    }
}
