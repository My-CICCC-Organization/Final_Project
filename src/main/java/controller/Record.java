package controller;

import util.Constants;
import java.io.*;
import java.util.*;

public class Record {

    public static void overWriteInfo(String FileName, String info, boolean append) {
        try {
            File file = new File(FileName);
            FileWriter fileWriter = new FileWriter(file +".txt",false);
            fileWriter.write(info);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void appendInfo(String FileName, String info, boolean append) {
        try {
            File file = new File(FileName);
            FileWriter fileWriter = new FileWriter(file +".txt",true);
            fileWriter.write(info);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    

    public static String read(String FileName) {
        try {
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(FileName+ ".txt") );
            String info = br.readLine();
            return info;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public static Map<String, String> readPersonalFileAsMap() {
        String infoString = read(Constants.FILENAME_PERSON);
        List<String> infoList = Arrays.asList(infoString.split(","));
        Map<String, String> infoMap = new HashMap<>();
        infoMap.put(Constants.UUID, infoList.get(0));
        infoMap.put(Constants.NAME, infoList.get(1));
        infoMap.put(Constants.BIRTHDAY, infoList.get(2));
        infoMap.put(Constants.WEIGHT, infoList.get(3));
        infoMap.put(Constants.BOTTLE_SIZE, infoList.get(4));
        infoMap.put(Constants.STATUS, infoList.get(5));
        return infoMap;
    }

    public static Map<String, String> readRecodeFileAsMap() {
        String infoString = read(Constants.RECORD);
        List<String> infoList = Arrays.asList(infoString.split(","));
        Map<String, String> infoMap = new HashMap<>();
        infoMap.put(Constants.UUID, infoList.get(0));
        infoMap.put(Constants.WATER, infoList.get(1));
        infoMap.put(Constants.QUANTITY, infoList.get(2));
        infoMap.put(Constants.INDOOR_ACTIVITY, infoList.get(3));
        infoMap.put(Constants.OUTDOOR_ACTIVITY, infoList.get(4));
        infoMap.put(Constants.TAKEN_QUANTITY, infoList.get(5));
        infoMap.put(Constants.TIME, infoList.get(6));
        return infoMap;
    }
}