package common.setup;

public class AllURLs {

    public static String YouTubeQA = "https://www.youtube.com";
    public static String LinkedinQA = "https://www.linkedin.com";
    public static String DropBoxQA = "https://www.dropbox.com/h";

    public static String getProductURL()
    {
        if (System.getProperty("runEnvironment").equals("QA")){
            if (System.getProperty("product").contains("YouTube"))
                return YouTubeQA;
            else if (System.getProperty("product").contains("Linkedin"))
                return LinkedinQA;
            else if (System.getProperty("product").contains("DropBox"))
                return DropBoxQA;
            else return "Product URL has not been defined on QA environment";
            }

        else return "Product URL has not been defined";

    }


}
