package model;

import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Record<recordList> {
    private int UUID;
    private String Name;
    private int birthday;
    private int Weight;
    private int takenQuantity;
    private int requiredQuantity;
    private int Time;




    public Record(int UUID, String name, int birthday, int weight, int takenQuantity, int requiredQuantity, int time) {
        this.UUID = UUID;
        this.Name = name;
        this.birthday = birthday;
        this.Weight = weight;
        this.takenQuantity = takenQuantity;
        this.requiredQuantity = requiredQuantity;
        this.Time = time;
    }

    Record myRecord = new Record
            (0010, "Tae", 19870831,50,1000,2500,30);



    public void listAllRecord() {
        for (int i = 0; i < myRecord.size(); i++) {
            String result = "<UUID> " + myRecord.get(i).getUUID() + "name " + myRecord.get(i).getName()+
           "Birthday" + myRecord.get(i).getBirthday()+", home=" + myRecord.get(i).getHomeNumber()+
            if (!myRecord.get(i).getCityName().isEmpty()) result += (", city=" + myRecord.get(i).getCityName());
            result = result + ')';

            System.out.println(result);
        }
    }

    private int size() {
        return size();
    }

}











