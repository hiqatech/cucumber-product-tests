package common.etl;

import static common.etl.ETLHelp.*;

public class ETLSteps {


    public static String readMyFile(String file, String path) {
        return readFile(file, path) + "  ,,,  : I read the " + file + " from " + path;
    }

    public static String diffMyFilesAndWriteInto(String diff, String file, String path){
        return diffFilesAndWriteInto(diff, file, path) + "  ,,,  : I compare the files and noted File1-File2 into " + file + " at " + path;
    }

    public static String openMyWorkbook(String fileName,String workbookName,String path) {
        if(path.contains("Downloads"))
            path = System.getProperty("downloadPath");
        else if(path.contains("Files"))
            path = System.getProperty("filePath");

        return openWorkbook(fileName, workbookName, path) + "  ,,,  : I open " + fileName + " on " + workbookName + " from " + path;
    }

    public static String saveMyWorkbook(String fileName,String workbookName) {
        String path = System.getProperty("downloadPath") + fileName;
        return saveWorkbook(fileName, workbookName, path) + "  ,,,  : I save " + fileName + " from " + workbookName;
    }

    public static String closeMyWorkbook(String fileName, String workbookName) {
        return closeWorkbook(fileName, workbookName) + "  ,,,  : I close " + fileName + " on " + workbookName;
    }

    public static String saveAndCloseMyWorkbook(String fileName, String workbookName){
        return closeMyWorkbook(fileName,workbookName) + closeMyWorkbook(fileName, workbookName);
    }

    public static String updateMyDatabaseWorkbook(String databaseWorkbookName,String updaterWorkbookName, String myKey) {
        return updateDatabaseWorkbook(databaseWorkbookName, updaterWorkbookName, myKey) + "  ,,,  : I update the " + databaseWorkbookName + " by the  " + updaterWorkbookName;
    }


}
