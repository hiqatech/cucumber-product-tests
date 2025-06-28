package common.service;

import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;

public class ServiceHelp {

  public void WeatherMessageBody()
  {
    RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
    RequestSpecification httpRequest = RestAssured.given();
    Response response = httpRequest.get("/Hyderabad");

    ResponseBody body = response.getBody();
    JsonPath jsonPathEvaluator = response.jsonPath();

    String city = jsonPathEvaluator.get("City");

    System.out.println("Response Body is: " + body.asString());
  }



}
