import com.vimalselvam.cucumber.listener.Reporter;
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
                        "junit:target/reports-reports/report.xml",
                        "json:target/reports-reports/report.json"
                        //"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
                        //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                        }
        )

public class TestRunner {

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(System.getProperty("reportConfigPath")));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");

    }

    public String getReportConfigPath(){
        String reportConfigPath = System.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

}

