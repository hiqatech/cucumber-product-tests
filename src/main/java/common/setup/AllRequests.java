package common.setup;

import org.json.simple.JSONObject;


public class AllRequests {

  public static String getLinkedinRequestURL(String requestName) {
      return products.Linkedin.Requests.getRequestURL(requestName);
  }

  public static String getGoogleDriveRequestURL(String requestName) {
      return products.DropBox.Requests.getRequestURL(requestName);
  }

  public static JSONObject getLinkedinRequestBody(String requestName) {
      return products.Linkedin.Requests.getRequestBody(requestName);
  }

  public static JSONObject getGoogleDriveRequestBody(String requestName) {
      return products.DropBox.Requests.getRequestBody(requestName);
  }

}
