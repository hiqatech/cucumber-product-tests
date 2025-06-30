package products.Booking.requests;

import io.restassured.response.Response;
import org.json.JSONObject;

public class bodies {

    private static final String USERNAME = "TOOLSQA-Test";
    private static final String PASSWORD = "Test@@123";
    private static final String BASE_URL = "https://bookstore.toolsqa.com";

    private static String token;
    private static Response response;
    private static String jsonString;
    private static String bookId;

    static JSONObject object1;

    public static JSONObject getBody(String name){

        return object1;
    }

}
