import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (features = {"src/test/resources/features"},
                glue = {"classpath:com/stepdefs","classpath:com.setup","classpath:product"},
                plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                }
        )

public class RunCukesTest {

    @AfterClass
    public static void report()
    {
    }

}
