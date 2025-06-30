package common.cucumber;


import common.service.ServiceHelp;
import io.cucumber.java.en.Given;

import static common.setup.Hooks.AssertExecutedStep;

public class ServiceSteps {

  @Given("I set the {string} request path")
  public static void ISetTheRequestURL(String path) {
    AssertExecutedStep( ServiceHelp.setRequestFullURL(path) + " : " + "I set the " + path + " request url");
  }

  @Given("I set the {string} request body")
  public static void ISetTheRequestBody(String reqName) {
    AssertExecutedStep(ServiceHelp.setRequestBody(reqName) + " : " + "I set the " + reqName + " request body");
  }

  @Given("I send {string} request to {string}")
  public static void ISendTheRequest(String type, String path) {
    AssertExecutedStep( ServiceHelp.sendTheRequest(type, path)  + " : " + "I send the " + type + " request to " + path);
  }

  @Given("The response status code {string} be {string}")
  public static void TheResponseShouldBe(String should, String expected) {
    String result = "PASS";
    String actual = ServiceHelp.getResponseStatusCode();
    if (!actual.equals(expected)) {
      result = "FAIL";
    }
    AssertExecutedStep( result + " : " + "The " + actual + " status code " + should  +  " equal to " + actual);
  }

  @Given("I get the auth token by {string} and {string}")
  public static void IGetTheAuthToken(String userName, String password) {
    AssertExecutedStep(ServiceHelp.getAuthTokenBy(userName, password) + " : " + "I get the auth token by " + userName + " and " + password);
  }


}
