package common.setup;

import org.json.simple.JSONObject;


public class AllRequests {

  public static String getWhatsUpRequestURL(String requestName) {
      return products.WhatsUp.Requests.getRequestURL(requestName);
  }

  public static JSONObject getWhatsUpRequestBody(String requestName) {
      return products.WhatsUp.Requests.getRequestBody(requestName);
  }

}
