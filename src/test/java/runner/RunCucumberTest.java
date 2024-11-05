package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features", // Ruta de los archivos de características
        glue = {"utility", "steps"},// Paquete donde están los steps
//        tags = "@only",
//        plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Reportes
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE // Para usar camelCase en los steps
)
public class RunCucumberTest {
}
