package controller;

import util.Constants;
import util.StageManager;

import java.io.*;
import java.util.*;

public class Record {

    public static void write(String FileName, String info) {
        try (FileWriter fw = new FileWriter(FileName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
             bw.close();
             out.close();
             StageManager.changeScene(Constants.PRIMARY_STAGE, Constants.MAIN_SCENE);
        } catch (IOException e) {
            System.out.println("There are some problems");
        }
    }

    public static String read(String FileName) {
        try {
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(FileName));
            String info = br.readLine();
            return info;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public static Map readPersonalFileAsMap(String name) {
        try {
            String FileName = Constants.PERSONAL_INFO;
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(FileName));
            String infoString = br.readLine();
            List<String> infoList = Arrays.asList(infoString.split(","));
            Map<String, String> infoMap = new HashMap<>();
            infoMap.put(Constants.UUID, infoList.get(0));
            infoMap.put(Constants.NAME, infoList.get(1));
            infoMap.put(Constants.BIRTHDAY, infoList.get(2));
            infoMap.put(Constants.WEIGHT, infoList.get(3));
            infoMap.put(Constants.STATUS, infoList.get(4));

            return infoMap;

        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public static Map readRecodeFileAsMap() {
        try {
            String FileName = Constants.RECORD;
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(FileName));
            String infoString = br.readLine();
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

        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
}
