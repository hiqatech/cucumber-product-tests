package common.setup;

import org.json.JSONObject;
import products.Booking.requests.bodies;
import products.Booking.requests.paths;


public class AllRequests {

  public static String getBookingURL(String requestName) {
      return paths.getURL(requestName);
  }

  public static JSONObject getBookingBody(String requestName) {
      return bodies.getBody(requestName);
  }

}
