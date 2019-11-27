package model;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import controller.Record;
import util.Constants;

public class Person {

    // set personal information
    // UUID, Name, Birthday, Weight(kg), Status
    public void setInformation(List personalInfo){
        String personInfo = String.join(",", personalInfo);
        // recordメソッド呼び出し　書き込み
        Record.write(Constants.FILENAME_PERSON, personInfo);
    }

    // get user's UUID
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return  uuid.toString();
    }

    // get user's name
    public static String getName() {
        return Record.readPersonalFileAsMap().get(Constants.NAME);
    }

    // get user's Birthday
    public static LocalDate getBirthday() {
        // get birthday from personal map
        String bd = Record.readPersonalFileAsMap().get(Constants.BIRTHDAY);
        // string to Local Date
        LocalDate birthday = LocalDate.parse(bd, DateTimeFormatter.ofPattern("yyyyMMdd"));
        return birthday;
    }

    // get user's Weight(kg)
    public static double getWeight() {
        return Double.parseDouble(Record.readPersonalFileAsMap().get(Constants.WEIGHT));
    }

    // get user's Taken Quantity(ml)
    public static int getTakenQuantity() {
        return Integer.parseInt(Record.readPersonalFileAsMap().get(Constants.TAKEN_QUANTITY));
    }

    // get user's status
    public static int getStatus() {
        return Integer.parseInt(Record.readPersonalFileAsMap().get(Constants.STATUS));
    }

    // get user's age
    public static int getAge() {
        LocalDate today = LocalDate.now();
        return Period.between(getBirthday(), today).getYears();
    }

}
