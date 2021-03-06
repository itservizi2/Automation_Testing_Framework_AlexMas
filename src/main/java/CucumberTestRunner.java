import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/features",
        glue = "stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = {"@RunContact"},
        plugin = {"pretty", "html:target/cucumberreports"}
)
public class CucumberTestRunner {

}
