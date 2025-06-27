package common.setup;

import org.json.simple.JSONObject;

import static common.setup.AllPages.*;
import static common.setup.AllRequests.*;

public class AllProducts {

    public static String getElementSelector(String elementName)
    {
        if(System.getProperty("product").contains("Banking"))
            return getBankingElementSelector(elementName);
        if(System.getProperty("product").contains("YouTube"))
            return getYouTubeElementSelector(elementName);
        else if(System.getProperty("product").contains("GitHub"))
            return getGitHubElementSelector(elementName);
        else if(System.getProperty("product").contains("Cognizant"))
            return getCognizantElementSelector(elementName);
        else if(System.getProperty("product").contains("WhatsUp"))
            return getWhatsUpElementSelector(elementName);
        else {System.out.println("Product has not been defined in AllProducts");
            return "NoSuchAProduct";}
    }

    public static String getFullRequestURL(String requestName) {
        if (System.getProperty("product").contains("Linkedin")) {
            return getWhatsUpRequestURL(requestName); }
        else { System.out.println("Product has not defined yet in the test requests AllProducts \n");
            return "NoSuchAProduct";}
    }

    public static JSONObject getRequestBodyByRequestName(String requestName) {
        if (System.getProperty("product").contains("Linkedin"))
             return getWhatsUpRequestBody(requestName);
        else System.out.println("Product request has not defined yet in the test requests AllProducts \n");
            return null;
        }

    }

