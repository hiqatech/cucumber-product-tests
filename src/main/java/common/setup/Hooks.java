package common.setup;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;


import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static common.selenium.WebHelp.*;
import static common.util.DataHelp.getTimeStamp;

public class Hooks {

    public static boolean wantsToQuit = false;
    public static Scenario scenario;
    public static String myScenario;
    public static String stepLog;

    //------------------------------------------------------------------------//

    @Before
    public void setup(Scenario scenario) throws Exception
    {
        this.scenario = scenario;

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
        System.setProperty("filePath",System.getProperty("projectPath") + "\\src\\main\\resources\\files\\");
        System.setProperty("driverPath",System.getProperty("projectPath") + "\\src\\main\\resources\\webdrivers\\");
        System.setProperty("reportConfigPath",System.getProperty("projectPath") + "\\src\\main\\resources\\report\\extent-config.xml");

        if(wantsToQuit)
            throw new RuntimeException("Test FAIL : Cucumber wants to quit");

        System.out.println("************************************************************************************");

        System.out.println("SystemTime : " + System.getProperty("systemTime"));
        System.out.println("Product Tests Starts");
        System.out.println("Scenario : " + myScenario);
        System.out.println("ProjectPath : " + System.getProperty("projectPath"));
        System.out.println("ReportPath : " + System.getProperty("reportPath"));
        System.out.println("************************************************************************************");

        try { File screenshots = new File(System.getProperty("filePath") + "\\screenshots\\");
            FileUtils.cleanDirectory(screenshots);}
        catch (Exception ex){System.out.println(ex.toString());}

    }

    @After
    public static void tearDown(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            takeScreenShot(System.getProperty("reportPath") + myScenario + " failed_" + getTimeStamp("YYYY-MM-DD-HH-mm-ss-SSS"));
            System.out.println("Test Failed !");
        }
        else System.out.println("Test Passed !");
        closeAllDrivers();
        System.out.println("************************************************************************************");
    }

    public static void closeAllDrivers(){
        stopMyWebDriver();
    }

    //-----------------------------------------------------------------------------//


    public static void AssertExecutedStep(String result)
    {
        stepLog = result;
        if (!result.toUpperCase().contains("PASS")) {
            //Hooks.scenario.log(getResultFailLog(result));
            System.out.println(result);
            Assert.assertTrue(false);
        }
        else {
            //Hooks.scenario.log(result.replace(",,,",""));
            System.out.println(result);
        }
    }

    public static void VerifyExecutedStep(String result)
    {
        stepLog = result;
        if (!result.toUpperCase().contains("PASS")){
           //Hooks.scenario.log(getResultFailLog(result));
            System.out.println(result);
        }
    }

    public static String getResultFailLog(String result){
        String extString = Arrays.asList(result.split(" ,,, " )).get(0);
        String desc = Arrays.asList(result.split(" ,,, " )).get(1);
        result = "FAIL " + desc + " caused by : " + extString;
        return result;
    }

    public static void setProductEnv(String product,String environment){
        System.setProperty("product",product);
        System.setProperty("runEnvironment",environment);
        System.setProperty("baseURL", AllURLs.getProductURL());
        AllPages.setAllProductsPageElements();
        System.out.println("product : " + System.getProperty("product"));
        System.out.println("runEnvironment : " + System.getProperty("runEnvironment"));
        System.out.println("baseURL : " + System.getProperty("baseURL"));
    }

    public static void setProduct(String product){
        System.setProperty("product",product);
        System.setProperty("baseURL", AllURLs.getProductURL());
        AllPages.setAllProductsPageElements();
        System.out.println("product : " + System.getProperty("product"));
        System.out.println("baseURL : " + System.getProperty("baseURL"));
    }

    public static void setEnv(String environment){
        System.setProperty("runEnvironment",environment);
        System.out.println("runEnvironment : " + System.getProperty("runEnvironment"));
    }

    public static void setGrid(String grid){
        System.setProperty("runEnvironment",System.getProperty("runEnvironment") + grid);
        System.out.println("runEnvironment : " + System.getProperty("runEnvironment"));
      }

    public static void setBrowser(String browser){
        System.setProperty("System.setProperty",browser);
        System.out.println("browser : " + System.getProperty("browser"));
    }



}
