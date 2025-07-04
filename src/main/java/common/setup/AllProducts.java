package common.setup;

import org.json.JSONObject;
import static common.setup.AllPages.*;
import static common.setup.AllRequests.*;

public class AllProducts {

    public static String getElementSelector(String elementName)
    {
        if(System.getProperty("product").contains("Banking"))
            return getBankingElementSelector(elementName);
        else {System.out.println("Product has not been defined in AllProducts");
            return "NoSuchAProduct";}
    }

    public static String getRequestURL(String requestName) {
        if (System.getProperty("product").contains("Booking")) {
            return getBookingURL(requestName); }
        else { System.out.println("Product has not defined yet in the test requests AllProducts \n");
            return "NoSuchAProduct";}
    }

    public static JSONObject getRequestBodyByRequestName(String requestName) {
        if (System.getProperty("product").contains("Booking"))
             return getBookingBody(requestName);
        else System.out.println("Product request has not defined yet in the test requests AllProducts \n");
            return null;
        }

    }

