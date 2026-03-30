package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber",   glue = "StepDefination_195", monochrome = true,plugin = {"html:target/cucumber.html"}) //tell your feature where yournfeature file exist
public class TestNGTestRunner extends AbstractTestNGCucumberTests {


}
