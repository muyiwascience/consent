import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"/Users/Olu/Documents/api-test/consent-api-test/src/test/resources/Features/RetrieveConsent.feature:5"},
        plugin = {"json:/Users/Olu/Documents/api-test/consent-api-test/target/cucumber-parallel/json/3.json"},
        monochrome = true,
        glue = {"com.optum.steps"})
public class Parallel03IT {
}
