package products.GitHub.Pages;

import java.util.HashMap;

public class MyProfilePage {

    public static HashMap<String, String> elementLocators = new HashMap<String, String>();

    public static void setElements()
    {
        elementLocators.put("my_profile_menu", "//summary[@aria-label=\"View profile and more\"]");
        elementLocators.put("", "");

    }

    public static String getElementSelector(String element_name)
    {
        setElements();
        String elementLocator = elementLocators.get(element_name);
        return elementLocator;
    }

}
