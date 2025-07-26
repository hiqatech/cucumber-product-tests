package products.Store.pages;

import java.util.HashMap;

public class MainPage {

    public static HashMap<String, String> elementLocators = new HashMap<String, String>();
    static {
        elementLocators.put("countryDropDown", "//android.widget.TextView" +
                "[@resource-id=\"android:id/text1\"]");
        elementLocators.put("nameField", "//android.widget.EditText" +
                "[@resource-id=\"com.androidsample.generalstore:id/nameField\"]");
        elementLocators.put("letsGoShop", "//android.widget.Button" +
                "[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]");
        elementLocators.put("radioMale", "com.androidsample.generalstore:id/radioMale");
    }

    public static String get(String element_name)
    {
        return elementLocators.get(element_name);
    }


}
