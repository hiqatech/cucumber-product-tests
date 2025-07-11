package common.util;

import org.apache.commons.io.output.ByteArrayOutputStream;
import java.beans.XMLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DataHelp {


    private static List<Map<String,String>> List1;
    private static List<Map<String,String>> List2;

    public static void setList(String listNumber, List<Map<String, String>> data) {
        List<Map<String,String>> List = data;
        System.out.println("Setting List1");
        for (Map map : List) {
            List<String> listHeaders = new ArrayList<String>(map.keySet());
            List<String> listValues1 = new ArrayList<String>(map.values());
            for (int i = 0; i < listHeaders.size(); i++) {
                System.out.print(listHeaders.get(i) +
                        " = " + listValues1.get(i) + " ");
            }
            System.out.println();
        }

        if(listNumber.equals("1"))
            List1 = List;
        else if(listNumber.equals("2"))
            List2 = List;

        System.out.println("------------------------");
    }

    public static List<String> storedTexts = Arrays.asList("","","","","","","","","","");
    public static HashMap<String,String> MyMap;
    public static String getTimeStamp(String format)
    {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

    public static String prepText(String text)
    {
        try
        {
            String extension = "ext";
            String addition = "add";

            if(text.contains("TimeStamp"))
                text = text.replace("+TimeStamp","-" + getTimeStamp("YYYY-MM-DD-HH-mm-ss-SSS"));

            if(text.contains("+Text"))
            {
                int index = Integer.parseInt(text.replaceAll("\\D+",""));
                text = text.substring(0,text.indexOf("+")) + storedTexts.get(index);
            }
            else if(text.contains("+"))
            {
                extension = text.substring(text.indexOf("+"));
                text = text.replace(extension,"");
                extension = extension.replace("+","");
            }
            else if(text.contains("-"))
            {
                addition = text.substring(text.indexOf("-"));
                text = text.replace(addition,"");
            }

            if(text.contains("Text"))
            {
                int index = Integer.parseInt(text.replaceAll("\\D+",""));
                text = storedTexts.get(index);
            }

            if(!(addition.equalsIgnoreCase("add")))
                text = text + addition;
            if(!(extension.equalsIgnoreCase("ext")))
                text = text + extension;

            return text;
        }
        catch(Exception ex)
        {System.out.println(ex.toString()); return  ex.toString();}
    }

    public static String storeText(String text, String TextX)
    {
        try
        {
            int index = Integer.parseInt(TextX.replaceAll("\\D+",""));
            storedTexts.set(index,text);
            return "PASS";
        }
        catch(Exception ex)
        {System.out.println(ex.toString()); return  ex.toString();}
    }

    public static String getStoredText(String TextX)
    {
        try
        {
            int index = Integer.parseInt(TextX.replaceAll("\\D+",""));
            return storedTexts.get(index);
        }
        catch(Exception ex)
        {System.out.println(ex.toString()); return  ex.toString();}
    }

    public static String getFileNameExt(String fileName)
    {
        try
        {
            return fileName.substring(fileName.indexOf("."));
        }
        catch(Exception ex)
        {System.out.println(ex.toString()); return  ex.toString();}
    }

    public static void printMap(HashMap<String,String> map)
    {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();

        while(iter.hasNext())
        {
            Map.Entry<String,String> entry = iter.next();
            sb.append(entry.getKey());
            sb.append("=").append('"');
            sb.append(entry.getValue());
            sb.append('"');

            if(iter.hasNext())
                sb.append(',').append(' ');
        }

        System.out.println(sb.toString());
    }

    public static String hashMapToXmlString(HashMap map)
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        XMLEncoder xmlEncoder = new XMLEncoder(bos);
        xmlEncoder.writeObject(map);
        xmlEncoder.flush();

        return bos.toString();
    }

    public static  String generateRandomString(int length, String startWith)
    {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        int randomLength = length - startWith.length();
        int remove = dateTime.length() -randomLength;

        String randomString = dateTime.substring(1,remove);
        randomString = startWith + randomString;
        return randomString;
    }

    public static String generateRandomIntString(int min, int max)
    {
        Random rand = new Random();
        int randomInt = rand.nextInt((max-min)+1)+min;
        return Integer.toString(randomInt);
    }

    public static String getDynamicDate(String dateString , String pattern)
    {
        try
        {

            LocalDateTime newDate = LocalDateTime.now();
            dateString = dateString.replace("CurrentDate","");
            if(dateString.contains("+"))
            {
                int offset = Integer.parseInt(dateString.replace("+",""));
                newDate = newDate.plusDays(offset);
            }
            else if(dateString.contains("-"))
            {
                int offset = Integer.parseInt(dateString.replace("-",""));
                newDate = newDate.minusDays(offset);
            }

            return newDate.format(DateTimeFormatter.ofPattern(pattern));
        }
        catch(Exception ex)
        {System.out.println(ex.toString()); return  ex.toString();}
    }

    public static boolean onlyDigits(String str)
    {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
            else return false;
        }
        return false;
    }

    public static String getTimeStamp(){
        String nano = String.valueOf(LocalDateTime.now().getNano());
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return  date + "-" + nano;
    }
}

