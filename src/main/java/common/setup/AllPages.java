package common.setup;

import products.GitHub.Pages.MyProfilePage;

public class AllPages {

    public static String getYouTubeElementSelector(String elementName)
    {
        if(System.getProperty("activePage").equals("Home"))
            return products.YouTube.Pages.HomePage.getElementSelector(elementName);
        else if(System.getProperty("activePage").equals("Search"))
            return products.YouTube.Pages.SearchPage.getElementSelector(elementName);
        else {System.out.println( System.getProperty("product") + " " + System.getProperty("activePage") +
                                 " Page has not been defined in the AllPages");
            return "";}
    }

    public static String getWhatsUpElementSelector(String elementName)
    {
        if(System.getProperty("activePage").equals("Home"))
            return products.WhatsUp.Pages.LogInPage.getElementSelector(elementName);
        else if(System.getProperty("activePage").equals("Search"))
            return products.WhatsUp.Pages.HomePage.getElementSelector(elementName);
        else {System.out.println( System.getProperty("product") + " " + System.getProperty("activePage") +
                                  " Page has not been defined in the AllPages");
            return "";}
    }

    public static String getGitHubElementSelector(String elementName)
    {
        if(System.getProperty("activePage").equals("Home"))
            return products.GitHub.Pages.HomePage.getElementSelector(elementName);
        else if(System.getProperty("activePage").equals("MyProfile"))
            return MyProfilePage.getElementSelector(elementName);
        else {System.out.println( System.getProperty("product") + " " + System.getProperty("activePage") +
                " Page has not been defined in the AllPages");
            return "";}
    }


}
