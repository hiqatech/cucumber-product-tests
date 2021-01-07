import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (features = {"src/test/resources/features"},
        tags = { "@Smoke", "@Regression" },
        glue = {"classpath:common/cucumber","classpath:common.setup","classpath:products"},
                plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
                )

public class TestRunner {
}
