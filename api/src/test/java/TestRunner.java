import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to the feature files
        glue = {"stepDefinitions"}, // Package containing step definitions
        plugin = {"pretty", "html:target/cucumber-reports"}, // Reporting plugins
        monochrome = true // Console output readability
)
public class TestRunner {
}
