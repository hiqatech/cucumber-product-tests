package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",
        features = "src/test/resources/Features/Banking/Web/DepositTests.feature",
        glue = {"classpath:common/cucumber","classpath:common.setup","classpath:products"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public final class TestRunner extends AbstractTestNGCucumberTests {


}