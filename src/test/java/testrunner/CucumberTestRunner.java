package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src\\test\\resources\\featuresFile",
        glue = "org.example.stepdef",
        plugin="pretty"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    @DataProvider
    @Override
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
