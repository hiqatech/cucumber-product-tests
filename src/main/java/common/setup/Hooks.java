package common.setup;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static common.app.App.*;
import static common.selenium.WebHelp.takeScreenShot;
import static common.selenium.WebSteps.*;
import static common.util.DataHelp.getTimeStamp;

public class Hooks {

    public static boolean wantsToQuit = false;
    public static Scenario scenario;
    public static String myScenario;
    public static String accountSID;
    public static String authToken;
    public static String phoneNumber;
    public static String otpNumber;
    public static String myUserName;
    public static String myPassword;

    //------------------------------------------------------------------------//

    @Before
    public void setup(Scenario scenario) throws Exception
    {
        this.scenario = scenario;

        LocalDateTime dateTime = LocalDateTime.now();

        myScenario = scenario.getName();
        System.setProperty("scenario",myScenario);
        System.setProperty("product",myScenario.substring(0,myScenario.indexOf("-")).replace(" ",""));

        // local use, comment before push
        System.setProperty("runDriver","chrome");
        System.setProperty("seleniumGrid","local"); //http://192.168.1.208:32001/wd/hub
        System.setProperty("runEnvironment","QA");

        System.setProperty("projectPath",System.getProperty("user.dir"));
        System.setProperty("systemTime", dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.setProperty("userID",System.getProperty("user.home").replace("C:\\Users\\",""));
        System.setProperty("downloadPath",System.getProperty("user.home")+"\\Desktop\\");
        System.setProperty("uploadPath",System.getProperty("user.home")+"\\Desktop\\");
        System.setProperty("reportPath",System.getProperty("projectPath")+"\\target\\cucumber-reports\\");
        System.setProperty("filePath",System.getProperty("projectPath") + "\\src\\main\\resources\\files\\");
        System.setProperty("driverPath",System.getProperty("projectPath") + "\\src\\main\\resources\\webdrivers\\");
        System.setProperty("reportConfigPath",System.getProperty("projectPath") + "\\src\\main\\resources\\report\\extent-config.html");

        System.setProperty("account_sid","AC9bad98c469be29cdc854277ac5ef63cd");
        System.setProperty("auth_token","c6d4a5c59d6155c6b09627757a21ec6a");
        System.setProperty("phone_number","+18306421459");

        if(System.getProperty("product").equals("GitHubWeb")){
            System.setProperty("my_username","hiqatech");
            System.setProperty("my_password","Strid@b52");}
        else if(System.getProperty("product").equals("CognizantWeb")){
            System.setProperty("my_username","668904@cognizant.com");
            System.setProperty("my_password","Lidia@20");}

        accountSID= System.getProperty("account_sid");
        authToken= System.getProperty("auth_token");
        phoneNumber= System.getProperty("phone_number");
        myUserName= System.getProperty("my_username");
        myPassword= System.getProperty("my_password");

        if(wantsToQuit)
            throw new RuntimeException("Test FAIL : Cucumber wants to quit");

        System.out.println("************************************************************************************");

        System.out.println("SystemTime : " + System.getProperty("systemTime"));
        System.out.println("Product Tests Starts");
        System.out.println("Scenario : " + myScenario);

        System.out.println("ProjectPath : " + System.getProperty("projectPath"));
        System.out.println("ReportPath : " + System.getProperty("reportPath"));
        System.out.println("FilePath : " + System.getProperty("filePath"));

        System.out.println("Environment : " + System.getProperty("runEnvironment"));

        if(scenario.getName().contains("Web"))
            startWebDriver(System.getProperty("runDriver"));
        else if(scenario.getName().contains("Android"))
            startAndroidDriver();
        else if(scenario.getName().contains("IOS"))
            startIOSDriver();

        System.out.println("************************************************************************************");

    }

    @After
    public static void tearDown(Scenario screnario) throws Exception
    {
        if(screnario.isFailed())
        {
            takeScreenShot(System.getProperty("reportPath") + myScenario + " failed_" + getTimeStamp("YYYY-MM-DD-HH-mm-ss-SSS"));
            stopWebDriver();
            stopAndroidDriver();
            stopIOSDriver();

            System.out.println("Test Failed !");
            }

        else{
            System.out.println("Test Passed !");
        }
        stopWebDriver();
        stopAndroidDriver();
        stopIOSDriver();
        System.out.println("************************************************************************************");
    }

    //-----------------------------------------------------------------------------//

}
