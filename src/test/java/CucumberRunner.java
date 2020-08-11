import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"utils.CustomListener"},
        glue = {"stepdefs"},
        features = {"src/test/resources/"},
        tags = {"@all"}
)
public class CucumberRunner {
}