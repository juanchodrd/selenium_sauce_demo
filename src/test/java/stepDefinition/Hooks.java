package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        DriverManager.initialize(); // Inicializa el WebDriver y el reporte
        DriverManager.setLogger(DriverManager.getExtent().startTest(scenario.getName())); // Inicia un nuevo test en el reporte
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        DriverManager.close(scenario); // Cierra el WebDriver y finaliza el reporte
    }
}
