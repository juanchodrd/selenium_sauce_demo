package automation;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;


public class selectProductTest extends testBase{
	LoginPage loginPage;
	ProductsPage productsPage;

	@Test
	public void testLogin() {
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		String producto="Sauce Labs Backpack";

		logger = extent.startTest("Comienzo caso de prueba");
		logger.log(LogStatus.INFO, "Realizo login");
		loginPage.login("standard_user", "secret_sauce");
		logger.log(LogStatus.INFO, "Verifica que la URL actual contenga \"inventory.html\"");
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory.html"), "URL does not contain 'inventory.html'");
		logger.log(LogStatus.INFO, "Selecciono producto: "+producto);
		productsPage.selectProduct(producto);
		logger.log(LogStatus.INFO, "Verifica que la URL actual contenga inventory-item.html?id=");
		currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory-item.html?id="));

	}

}
