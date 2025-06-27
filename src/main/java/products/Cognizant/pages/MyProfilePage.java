package products.Cognizant.pages;

import java.util.HashMap;

public class MyProfilePage {

    public static HashMap<String, String> elementLocators = new HashMap<String, String>();

    public static void setElements()
    {
        elementLocators.put("view_profile_menu", "//p[@id=\"userPhoto\"]");
        elementLocators.put("app_search_field", "//input[@id=\"txtPlatformBarSearch\"]");
        elementLocators.put("app_search_button", "//input[@id=\"btnsearch\"]");
        elementLocators.put("search_result_first_image", "//div[@class=\"inActive\"]/img[1]");
        elementLocators.put("", "");

    }

    public static String getElementSelector(String element_name)
    {
        setElements();
        String elementLocator = elementLocators.get(element_name);
        return elementLocator;
    }

}
