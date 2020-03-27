import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/user_order.feature" }, plugin = { "pretty",
		"html:out" }, snippets = SnippetType.CAMELCASE)
public class RunCukesTest {
}