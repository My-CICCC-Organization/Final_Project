package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

    String UUID;
    String name;
    Date birthday;
    double weightLb;
    double weightKg;
    int takenQuantity;
    int status;

    public int calAge(){
        //(今日の日付-誕生日)/10000の小数点以下切捨て。
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");

        String formattedDate=dateFormat.format(date);

        System.out.println(formattedDate);
        return 0;
    }


}
