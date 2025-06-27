package common.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;

public class ServiceHelp {

  //public static RestAssuredConfig config = RestAssured.config().connectionConfig(new ConnectionConfig().closeIdleConnectionsAfterEachResponseAfter(10, TimeUnit.MILLISECONDS));

  public static JSONObject setRequestValues(JSONObject requestBody, HashMap<String, String> requestMap) {

    for (Object key : requestBody.keySet()) {
      String bodyKey = (String) key;

      //System.out.println("key: "+ bodyKey + " value: " + bodyValue);

      for (Map.Entry<String, String> entry : requestMap.entrySet()) {
        String requestKey = entry.getKey();
        String requestValue = entry.getValue();

        if (bodyKey.equalsIgnoreCase(requestKey))
          requestBody.put(bodyKey, requestValue);
      }
    }

    return requestBody;
  }


  /*public static Response sendRequest(String service, String fullRequestUrl, String requestType, JSONObject requestBody)
  {
    Response response=null;

    if(!(requestBody.entrySet().size() == 0))
      System.out.println(" service is: " + service + "\n full request url is: " + fullRequestUrl +
                         "\n request type is: " + requestType+ "\n request body is: " + requestBody.toString()+ "\n");
    else
      System.out.println(" service is: " + service+ "\n full request url is: " + fullRequestUrl +
                         "\n request type is: " + requestType + "\n");

    if (requestType.equalsIgnoreCase("GET"))
    {
      response =
      //RestAssured.with().config(config).
      given().
      //contentType("application/json").
      //body(request_body).
      //queryParam().
      //when().
      get(fullRequestUrl).
                         then().
                               statusCode(200).
                                              extract().response();

      return response;
    }
    else if (requestType.equalsIgnoreCase("POST"))
    {
      response =
      given().
             contentType("application/json; charset=UTF-8").
                                                           body(requestBody).
      //queryParam("").
      when().
            post(fullRequestUrl).
                                then().
                                      statusCode(201).
                                                     extract().response();
      return response;
    }
    else if (requestType.equalsIgnoreCase("PUT"))
    {
      response =
      given().
             contentType("application/json").
                                            body(requestBody).
      //queryParam("").
      when().
            put(fullRequestUrl).
                               then().
                                     statusCode(201).
                                                    extract().response();
      return response;

    }
    else System.out.println( requestType + " request type has not defined yet in the test messenger");
    return response;

  }


   */

}
