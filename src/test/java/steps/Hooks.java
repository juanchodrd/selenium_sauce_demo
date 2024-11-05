package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.initialize(); // Inicializa el WebDriver y el reporte
    }

    @After
    public void tearDown() {
        DriverManager.close(); // Cierra el WebDriver y finaliza el reporte
    }
}
