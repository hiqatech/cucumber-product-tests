package products.Cognizant.Pages;

import java.util.HashMap;

public class HomePage {

  public static HashMap<String, String> elementLocators = new HashMap<String, String>();

  public static void setElements()
  {
    elementLocators.put("email_field", "//input[@type=\"email\"]");
    elementLocators.put("next_button", "//input[@id=\"idSIButton9\"]");
    elementLocators.put("password_field", "//input[@type=\"password\"]");
    elementLocators.put("sign_in_button", "//input[@type=\"submit\"]");
    elementLocators.put("otp_number_field", "//input[@id=\"idTxtBx_SAOTCC_OTC\"]");
    elementLocators.put("otp_number_verify_button", "//input[@type=\"submit\"]");
    elementLocators.put("stay_sign_in_yes_button", "//input[@type=\"submit\"]");

  }

  public static String getElementSelector(String element_name)
  {
    setElements();
    String elementLocator = elementLocators.get(element_name);
    return elementLocator;
  }
}
