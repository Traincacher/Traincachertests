package traincacher.be.tests.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format={"pretty",
                "html:target/cucumber"},
        features = {"src/test/resources/traincacher.be/features/gecachedTreintrajectVerwijderen.feature"},
        tags={"~@skip"},
        glue="traincacher.be/tests/steps")
public class Testrunner {
}