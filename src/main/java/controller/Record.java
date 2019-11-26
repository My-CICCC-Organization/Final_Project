package controller;

import util.Constants;
import util.StageManager;

import java.io.*;

public class Record {

    private String name ;
    private String day ;
    private String month ;
    private String year ;
    private String weight ;
    private String ml ;
    private String unit ;

    public Record(String name, String day, String month, String year, String weight, String ml, String unit) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.weight = weight;
        this.ml = ml;
        this.unit = unit;
    }

    public static void store(String info){
        try (FileWriter fw = new FileWriter("memo", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)){
             out.println(info);

            System.out.println("*Data Saved in memo.txt");
            bw.close();
            out.close();
            StageManager.changeScene(Constants.PRIMARY_STAGE, Constants.MAIN_SCENE);


        } catch (IOException e) {
            System.out.println("Some Problems bro!");
        }

    }

    public static Record read() throws IOException {
        String FileName = "memo";
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(FileName));
        String name = br.readLine();
        String day =br.readLine();
        String month =br.readLine();
        String year =br.readLine();
        String weight =br.readLine();
        String ml =br.readLine();
        String unit =br.readLine();
        return new Record(name, day, month, year, weight, ml, unit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMl() {
        return ml;
    }

    public void setMl(String ml) {
        this.ml = ml;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
