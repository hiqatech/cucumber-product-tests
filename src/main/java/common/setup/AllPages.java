package common.setup;

public class AllPages {

    public static String getBankingElementSelector(String elementName)
    {
        if(System.getProperty("activePage").equalsIgnoreCase("Home"))
            return products.Banking.pages.Home.getElementSelector(elementName);
        else if(System.getProperty("activePage").equalsIgnoreCase("Login"))
            return products.Banking.pages.Login.getElementSelector(elementName);
        else if(System.getProperty("activePage").equalsIgnoreCase("UserHome"))
            return products.Banking.pages.UserHome.getElementSelector(elementName);
        else if(System.getProperty("activePage").equalsIgnoreCase("Deposit"))
            return products.Banking.pages.Deposit.getElementSelector(elementName);
        else if(System.getProperty("activePage").equalsIgnoreCase("Transactions"))
            return products.Banking.pages.Transactions.getElementSelector(elementName);
        else {System.out.println( System.getProperty("product") + " " + System.getProperty("activePage") +
                " Page has not been defined in the AllPages");
            return "NoSuchAnElement";}
    }

}
