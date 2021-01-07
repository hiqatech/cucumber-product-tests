package products.DropBox.Pages;

import java.util.HashMap;

public class HomePage {

  public static HashMap<String, String> elementLocators = new HashMap<String, String>();

  public static void setElements()
  {
    elementLocators.put("email_field", "//input[@type=\"email\"]");
    elementLocators.put("password_field", "//input[@type=\"password\"]");
    elementLocators.put("sign_in_button", "//button[@type=\"submit\"]");
    elementLocators.put("", "");
    elementLocators.put("", "");
    elementLocators.put("", "");

  }

  public static String getElementSelector(String element_name)
  {
    setElements();
    String elementLocator = elementLocators.get(element_name);
    return elementLocator;
  }
}
