package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features", // Ruta de los archivos de características
        glue = {"stepDefinition"}, // Paquete donde están los steps
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Reportes
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE // Para usar camelCase en los steps
)
public class RunCucumberTest {
}
