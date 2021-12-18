package stepDefs;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= {"src/test/java/feature"},
        glue= {"stepDefs"},
        plugin = {"pretty", "json:target/cucumber.json"},
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel=true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}