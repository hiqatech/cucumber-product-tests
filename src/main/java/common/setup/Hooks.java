package common.setup;

import common.selenium.WebHelp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static common.selenium.WebHelp.*;
import static org.testng.AssertJUnit.fail;

public class Hooks {

    public static boolean wantsToQuit = false;
    public static Scenario scenario;
    public static String myScenario;
    public static String stepLog;

    //------------------------------------------------------------------------//

    @Before
    public void setup(Scenario scenario) throws Exception
    {
        Hooks.scenario = scenario;

        LocalDateTime dateTime = LocalDateTime.now();

        myScenario = scenario.getName();
        System.setProperty("scenario",myScenario);
        System.setProperty("product",myScenario.substring(0,myScenario.indexOf("-")).replace(" ",""));

        System.setProperty("projectPath",System.getProperty("user.dir"));
        System.setProperty("systemTime", dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.setProperty("userID",System.getProperty("user.home").replace("C:\\Users\\",""));
        System.setProperty("downloadPath",System.getProperty("user.home")+"\\Downloads\\");
        System.setProperty("uploadPath",System.getProperty("user.home")+"\\Desktop\\");
        System.setProperty("reportPath",System.getProperty("projectPath")+"\\target\\cucumber-reports\\");
        System.setProperty("extentPath",System.getProperty("projectPath")+"\\test-output\\ExtentReport");
        System.setProperty("driverPath",System.getProperty("projectPath") + "\\src\\main\\resources\\webdrivers\\");
        System.setProperty("appDir",System.getProperty("projectPath") + "\\src\\main\\resources\\apps\\");

        print("************************************************************************************");
        print("Product Tests Starts");
        print("SystemTime : " + System.getProperty("systemTime"));
        print("Scenario : " + myScenario);
        print("ProjectPath : " + System.getProperty("projectPath"));
        print("ExtentPath : " + System.getProperty("extentPath"));
    }

    @After
    public static void tearDown(Scenario scenario)
    {
        print("----------------------------------------------------------------------------------");
        if(scenario.isFailed())
        {
            takeScreenShot();
            print("Test Failed !");
        }
        else print("Test Passed !");
        print("-----------------------------------------------------------------------------------");
        closeAllDrivers();
        print("Product Tests Ends");
        print("************************************************************************************");
    }

    public static void closeAllDrivers(){
        stopMyWebDriver();
    }

    //-----------------------------------------------------------------------------//


    public static void AssertStep(String result)
    {
        stepLog = result;
        if (!result.toUpperCase().contains("PASS")) {
            WebHelp.takeScreenShot();
            Hooks.scenario.log(getResultFailLog(result));
            //print(result);
            fail();
        }
        else {
            Hooks.scenario.log(result.replace(",,,",""));
            //print(result);
        }
    }

    public static void VerifyStep(String result)
    {
        stepLog = result;
        if (!result.toUpperCase().contains("PASS")){
            WebHelp.takeScreenShot();
            Hooks.scenario.log(getResultFailLog(result));
            //print(result);
        }
    }

    public static String getResultFailLog(String result){
        String extString = Arrays.asList(result.split(" ,,, " )).get(0);
        try{
            String desc = Arrays.asList(result.split(" ,,, " )).get(1);
            result = "FAIL " + desc + " caused by : " + extString;
        }
        catch (Exception ex) {
            return result;
        }

        return result;
    }

    public static void setProductEnv(String product,String environment){
        System.setProperty("product",product);
        System.setProperty("runEnvironment",environment);
        System.setProperty("baseURL", AllURLs.getProductURL());
        print("product : " + System.getProperty("product"));
        print("runEnvironment : " + System.getProperty("runEnvironment"));
        print("baseURL : " + System.getProperty("baseURL"));
    }

    public static void setProduct(String product){
        System.setProperty("product",product);
        System.setProperty("baseURL", AllURLs.getProductURL());
        print("product : " + System.getProperty("product"));
        print("baseURL : " + System.getProperty("baseURL"));
    }

    public static void setEnv(String environment){
        System.setProperty("runEnvironment",environment);
        print("runEnvironment : " + System.getProperty("runEnvironment"));
    }

    public static void setGrid(String grid){
        System.setProperty("runEnvironment",System.getProperty("runEnvironment") + grid);
        print("runEnvironment : " + System.getProperty("runEnvironment"));
      }

    public static void setBrowser(String browser){
        System.setProperty("System.setProperty",browser);
        print("browser : " + System.getProperty("browser"));
    }
    
    public static void print(String note){
        System.out.println(note);
    }
}
