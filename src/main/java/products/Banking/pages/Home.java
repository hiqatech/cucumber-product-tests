package products.Banking.pages;

import java.util.HashMap;

public class Home {

    static HashMap<String, String> elementLocators = new HashMap<>();
    static {
        elementLocators.put("", "");
    }

    public static String getElementSelector(String element_name)
    {
        return elementLocators.get(element_name);
    }

}
