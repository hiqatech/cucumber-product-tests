package common.setup;

import common.appium.AppHelp;

public class AllURLs {

    static final String BankingQA = "https://www.globalsqa.com/angularJs-protractor/BankingProject";
    static final String BookingQA = "https://bookstore.toolsqa.com";
    static final String StoregQA = AppHelp.url;

    static final String BankingUAT = "https://www.globalsqa.com/angularJs-protractor/BankingProject";
    static final String BookingUAT = "https://bookstore.toolsqa.com";
    static final String StoreUAT = AppHelp.url;

    public static String getProductURL()
    {
        if (System.getProperty("runEnvironment").contains("QA")){
            if (System.getProperty("product").contains("Booking"))
                return BookingQA;
            else if (System.getProperty("product").contains("Banking"))
                return BankingQA;
            else if (System.getProperty("product").contains("Store"))
                return StoregQA;
            else return "Product URL has not been defined on QA environment";
            }
        else if (System.getProperty("runEnvironment").contains("UAT")){
            if (System.getProperty("product").contains("Booking"))
                return BookingUAT;
            else if (System.getProperty("product").contains("Banking"))
                return BankingUAT;
            else if (System.getProperty("product").contains("Store"))
                return StoreUAT;
            else return "Product URL has not been defined on UAT environment";
        }
        else
            return "Product URL has not been defined";
    }

}
