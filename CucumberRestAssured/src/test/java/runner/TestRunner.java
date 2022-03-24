package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber-html-report"},
        features = "src/test/java/features",
        glue = "steps" )
public class TestRunner extends AbstractTestNGCucumberTests {

}
