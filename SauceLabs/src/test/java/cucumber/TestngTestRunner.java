package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="stepDefinition",monochrome=true,
plugin= {"html:taget/cucumber.html"})
public class TestngTestRunner extends AbstractTestNGCucumberTests {
	

}
