package common.setup;

public class AllPages {

    public static String getYouTubeElementSelector(String elementName)
    {
        if(System.getProperty("activePage").equals("Home"))
            return products.YouTube.Pages.HomePage.getElementSelector(elementName);
        else if(System.getProperty("activePage").equals("Search"))
            return products.YouTube.Pages.SearchPage.getElementSelector(elementName);
        else {System.out.println( System.getProperty("product") + " " + System.getProperty("activePage") +
                                 " Page has not been defined in the AllPages");
            return "NoSuchAnElement";}
    }

    public static String getWhatsUpElementSelector(String elementName)
    {
        if(System.getProperty("activePage").equals("Home"))
            return products.WhatsUp.Pages.LogInPage.getElementSelector(elementName);
        else if(System.getProperty("activePage").equals("Search"))
            return products.WhatsUp.Pages.HomePage.getElementSelector(elementName);
        else {System.out.println( System.getProperty("product") + " " + System.getProperty("activePage") +
                                  " Page has not been defined in the AllPages");
            return "NoSuchAnElement";}
    }

    public static String getGitHubElementSelector(String elementName)
    {
        if(System.getProperty("activePage").equals("Home"))
            return products.GitHub.Pages.HomePage.getElementSelector(elementName);
        else if(System.getProperty("activePage").equals("MyProfile"))
            return products.GitHub.Pages.MyProfilePage.getElementSelector(elementName);
        else {System.out.println( System.getProperty("product") + " " + System.getProperty("activePage") +
                " Page has not been defined in the AllPages");
            return "NoSuchAnElement";}
    }

    public static String getCognizantElementSelector(String elementName)
    {
        if(System.getProperty("activePage").equals("Home"))
            return products.Cognizant.Pages.HomePage.getElementSelector(elementName);
        else if(System.getProperty("activePage").equals("MyProfile"))
            return products.Cognizant.Pages.MyProfilePage.getElementSelector(elementName);
        else {System.out.println( System.getProperty("product") + " " + System.getProperty("activePage") +
                " Page has not been defined in the AllPages");
            return "NoSuchAnElement";}
    }

}
