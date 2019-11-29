package controller;

import util.Constants;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileWriter;

public class Record {

    public static void overWriteInfo(String FileName, String info) {
        FileWriter fileWriter = null;
        try {
            File file = new File(FileName);
            fileWriter = new FileWriter(file,false);
            fileWriter.write(info);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void appendInfo(String FileName, String info) {
        BufferedWriter fileWriter = null;
        try{
            File file = new File(FileName);
            fileWriter = new BufferedWriter(new FileWriter(file, true));
            fileWriter.write(String.valueOf(info));
            fileWriter.newLine();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String read(String FileName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(FileName) );
            String info = br.readLine();
            return info;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String, String> readPersonalFileAsMap() {
        String infoString = read(Constants.FILENAME_PERSON);
        List<String> infoList = Arrays.asList(infoString.split(Constants.COMMA));
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
        String infoString = read(Constants.FILENAME_RECORD);
        List<String> infoList = Arrays.asList(infoString.split(Constants.COMMA));
        Map<String, String> infoMap = new HashMap<>();
        infoMap.put(Constants.UUID, infoList.get(0));
        infoMap.put(Constants.WATER_QUANTITY, infoList.get(1));
        infoMap.put(Constants.INDOOR_ACTIVITY, infoList.get(2));
        infoMap.put(Constants.OUTDOOR_ACTIVITY, infoList.get(3));
        infoMap.put(Constants.TAKEN_QUANTITY, infoList.get(4));
        infoMap.put(Constants.TIME, infoList.get(5));
        return infoMap;
    }
}