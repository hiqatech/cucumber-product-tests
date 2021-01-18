package common.etl;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class ETLSteps {

    static ArrayList al1=new ArrayList();
    static ArrayList al2=new ArrayList();
    static ArrayList al3=new ArrayList();
    static Workbook workbook1;
    static Workbook workbook2;
    static Workbook workbook3;
    static Workbook workbook4;


    public static String readFile(String file, String path) {
        try {
            BufferedReader CSVFile = new BufferedReader(new FileReader(path + file));
            String dataRow1 = null;
            dataRow1 = CSVFile.readLine();

            while (dataRow1 != null) {
                String[] dataArray1 = dataRow1.split(",");
                for (String item1 : dataArray1) {
                    if (file.contains("1")){
                    al1.add(item1);}
                    else if (file.contains("2")){
                        al2.add(item1);}
                }
                dataRow1 = CSVFile.readLine(); // Read next line of data.
            }
            CSVFile.close();
        } catch (Exception ex) {
            return "FAIL : " + ex.toString();
        }

        return "PASS : I read the " + file + " from " + path;
    }


    public static String diffFilesAndWriteInto(String diff, String file, String path){

        int size = 0;
        if(diff.equals("file1-file2")) {
            for (Object bs : al2) {
                al1.remove(bs);
            }
            size =al1.size();
            al3 = al1;
        }
        else if(diff.equals("file2-file1")) {
            for (Object bs : al1) {
                al2.remove(bs);
            }
            size =al2.size();
            al3 = al2;
        }

     try
        {
            FileWriter writer=new FileWriter(path+file);
            while(size!=0)
            {
                size--;
                writer.append("" + al3.get(size));
                writer.append('\n');
            }
            writer.flush();
            writer.close();
        }
        catch(Exception ex)
        {
            return "FAIL : " + ex.toString();
        }
        return "PASS : I compare the files and noted File1-File2 into " + file + " at " + path;
    }

    public static String openWorkbook(String fileName,String workbookName,String path) {
        if(path.contains("Downloads"))
            path = System.getProperty("downloadPath");
        else if(path.contains("Files"))
            path = System.getProperty("filePath");

        try {
            FileInputStream inputStream = new FileInputStream(new File(path+fileName));
            switch (workbookName) {
                case "workbook1": { workbook1 = WorkbookFactory.create(inputStream);break; }
                case "workbook2": { workbook2 = WorkbookFactory.create(inputStream);break; }
                case "workbook3": { workbook3 = WorkbookFactory.create(inputStream);break; }
                case "workbook4": { workbook4 = WorkbookFactory.create(inputStream);break; }
            }
            inputStream.close();
            return "PASS : I open " + fileName + " on " + workbookName + " from " + path;
        }
        catch(Exception ex)
        {return "FAIL : I open " + fileName + " on " + workbookName + " from " + path + " " + ex.toString();}
    }

    public static String saveWorkbook(String fileName,String workbookName) {
        String path = System.getProperty("downloadPath") + fileName;
        try {
        FileOutputStream outputStream = new FileOutputStream(new File(path));
        switch (workbookName) {
            case "workbook1": {workbook1.write(outputStream);break; }
            case "workbook2": {workbook2.write(outputStream);break; }
            case "workbook3": {workbook3.write(outputStream);break; }
            case "workbook4": {workbook4.write(outputStream);break; }
        }
            outputStream.close();
            return "PASS : I save " + fileName + " from " + workbookName;
        }
        catch(Exception ex)
        {return "FAIL : I save " + fileName + " from " + workbookName + " " + ex.toString();}
    }

    public static String closeWorkbook(String fileName, String workbookName) {
        try {
            switch (workbookName) {
                case "workbook1": {workbook1.close();break; }
                case "workbook2": {workbook2.close();break; }
                case "workbook3": {workbook3.close();break; }
                case "workbook4": {workbook4.close();break; }
            }
            return "PASS : I close " + fileName + " on " + workbookName;
        }
        catch(Exception ex)
        {return "FAIL : I close " + fileName + " on " + workbookName + " " + ex.toString();}
    }

    public static String saveAndCloseWorkbook(String fileName, String workbookName){
        return saveWorkbook(fileName,workbookName) + closeWorkbook(fileName, workbookName);
    }

    public static String updateDatabaseWorkbook(String databaseWorkbookName,String updaterWorkbookName){
        Sheet databaseSheet = getWorkbookSheetAt0(databaseWorkbookName);
        Sheet updaterSheet = getWorkbookSheetAt0(updaterWorkbookName);

        try{
            for(int i=1; i<updaterSheet.getPhysicalNumberOfRows(); i ++) {
                HashMap<String, String> updaterData = readWorkbookDataSet(updaterSheet, i);
                for(int j=1; j<databaseSheet.getPhysicalNumberOfRows(); j++) {
                    HashMap<String, String> databaseData = readWorkbookDataSet(databaseSheet, j);
                    if (databaseData.get("ID").equals(updaterData.get("ID"))) {
                        for (String key:updaterData.keySet()
                             ) {
                            databaseData.put(key,updaterData.get(key));
                        }
                        for (int k = 0; k < databaseData.size(); k++) {
                            if(!databaseSheet.getRow(j).getCell(k).toString().equalsIgnoreCase(databaseData.get(getColumnNameByIndex(databaseSheet,k))))
                                databaseSheet.getRow(j).getCell(k).setCellValue(databaseData.get(getColumnNameByIndex(databaseSheet,k).toString()));
                        }
                    }
                }
            }
        }
        catch(Exception ex)
        {
            return "FAIL : Could not run update process " + ex.toString();
        }
        return "PASS : I update the " + databaseWorkbookName + " by the  " + updaterWorkbookName;
    }

    static Sheet getWorkbookSheetAt0(String workbookName){
        Sheet sheet = null;
        switch (workbookName) {
            case "workbook1": { sheet=workbook1.getSheetAt(0);break; }
            case "workbook2": { sheet=workbook2.getSheetAt(0);break; }
            case "workbook3": { sheet=workbook3.getSheetAt(0);break; }
            case "workbook4": { sheet=workbook4.getSheetAt(0);break; }
        }
        return sheet;
    }

    static HashMap<String,String> readWorkbookDataSet(Sheet sheet,int rowNumber){
        ArrayList<String> headers=new ArrayList<String>();
        for(int i =0; i <sheet.getRow(0).getPhysicalNumberOfCells(); i++){
            headers.add(sheet.getRow(0).getCell(i).toString());}

        HashMap<String, String> dataSet = new HashMap<String, String>();
        for(int i =0;i<sheet.getRow(rowNumber).getPhysicalNumberOfCells(); i++){
            dataSet.put( headers.get(i), sheet.getRow(rowNumber).getCell(i).toString());}
        return dataSet;
    }

    static String getColumnNameByIndex(Sheet sheet, int index) {
        ArrayList<String> headers=new ArrayList<String>();
        for(int i =0; i <sheet.getRow(0).getPhysicalNumberOfCells(); i++){
            headers.add(sheet.getRow(0).getCell(i).toString());}
        return headers.get(index);
    }


}
