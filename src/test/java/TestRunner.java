import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions
        (features = {"src/test/resources/features"},
        tags = { "@Smoke", "@Regression" },
        glue = {"classpath:common/cucumber","classpath:common.setup","classpath:products"},
                plugin = {
                        "html:target/cucumber-reports/",
                        "junit:target/cucumber-reports/report.xml",
                        "json:target/cucumber-reports/report.json",
                        "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
                }
        )

public class TestRunner {

    @AfterClass
    public static void report()
    {
        Reporter.loadXMLConfig(new File("src/main/resources/report/extent-config.xml"));
        Reporter.setSystemInfo("User Name", "HiQATech");
        Reporter.setSystemInfo("Application Name", "Test App ");
        Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
        Reporter.setSystemInfo("Environment", "QA");
        Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
    }

}

