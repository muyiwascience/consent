import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"/Users/Olu/Documents/api-test/consent-api-test/src/test/resources/Features/CreateConsent.feature:11"},
        plugin = {"json:/Users/Olu/Documents/api-test/consent-api-test/target/cucumber-parallel/json/2.json"},
        monochrome = true,
        glue = {"com.optum.steps"})
public class Parallel02IT {
}
