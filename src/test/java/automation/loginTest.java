package automation;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class loginTest extends testBase {
    LoginPage loginPage;

    @Test
    public void testLogin() {
        loginPage = new LoginPage(driver);
        logger = extent.startTest("Comienzo caso de prueba");
        logger.log(LogStatus.INFO, "Ingreso usuario");
        loginPage.login("standard_user", "secret_sauce");
        // Verifica que la URL actual contenga "inventory.html"
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), "URL contains 'inventory.html'");

    }

}
