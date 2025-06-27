package common.setup;

public class AllPages {

    public static String getYouTubeElementSelector(String elementName)
    {
        if(System.getProperty("activePage").equalsIgnoreCase("Home"))
            return products.YouTube.pages.HomePage.getElementSelector(elementName);
        else if(System.getProperty("activePage").equalsIgnoreCase("Search"))
            return products.YouTube.pages.SearchPage.getElementSelector(elementName);
        else {System.out.println( System.getProperty("product") + " " + System.getProperty("activePage") +
                                 " Page has not been defined in the AllPages");
            return "NoSuchAnElement";}
    }

    public static String getWhatsUpElementSelector(String elementName)
    {
        if(System.getProperty("activePage").equalsIgnoreCase("Home"))
            return products.WhatsUp.pages.LogInPage.getElementSelector(elementName);
        else if(System.getProperty("activePage").equalsIgnoreCase("Search"))
            return products.WhatsUp.pages.HomePage.getElementSelector(elementName);
        else {System.out.println( System.getProperty("product") + " " + System.getProperty("activePage") +
                                  " Page has not been defined in the AllPages");
            return "NoSuchAnElement";}
    }

    public static String getGitHubElementSelector(String elementName)
    {
        if(System.getProperty("activePage").equalsIgnoreCase("Home"))
            return products.GitHub.pages.HomePage.getElementSelector(elementName);
        else if(System.getProperty("activePage").equalsIgnoreCase("MyProfile"))
            return products.GitHub.pages.MyProfilePage.getElementSelector(elementName);
        else {System.out.println( System.getProperty("product") + " " + System.getProperty("activePage") +
                " Page has not been defined in the AllPages");
            return "NoSuchAnElement";}
    }

    public static String getCognizantElementSelector(String elementName)
    {
        if(System.getProperty("activePage").equalsIgnoreCase("Home"))
            return products.Cognizant.pages.HomePage.getElementSelector(elementName);
        else if(System.getProperty("activePage").equalsIgnoreCase("MyProfile"))
            return products.Cognizant.pages.MyProfilePage.getElementSelector(elementName);
        else {System.out.println( System.getProperty("product") + " " + System.getProperty("activePage") +
                " Page has not been defined in the AllPages");
            return "NoSuchAnElement";}
    }

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

    public static void setAllProductsPageElements(){
        products.Banking.pages.Deposit.setElements();
        products.Banking.pages.Home.setElements();
        products.Banking.pages.Login.setElements();
        products.Banking.pages.Transactions.setElements();
        products.Banking.pages.UserHome.setElements();
    }

}
