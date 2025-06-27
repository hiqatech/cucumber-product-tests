package common.setup;

public class AllURLs {

    static String YouTubeQA = "https://www.youtube.com";
    static String GitHubQA = "https://www.github.com";
    static String CognizantQA = "https://onecognizant.cognizant.com";
    static String BankingQA = "https://www.globalsqa.com/angularJs-protractor/BankingProject";

    public static String getProductURL()
    {
        if (System.getProperty("runEnvironment").contains("QA")){
            if (System.getProperty("product").contains("YouTube"))
                return YouTubeQA;
            else if (System.getProperty("product").contains("GitHub"))
                return GitHubQA;
            else if (System.getProperty("product").contains("Cognizant"))
                return CognizantQA;
            else if (System.getProperty("product").contains("Banking"))
                return BankingQA;
            else return "Product URL has not been defined on QA environment";
            }
        else return "Product URL has not been defined";
    }

}
