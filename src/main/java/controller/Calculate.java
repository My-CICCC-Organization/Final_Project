package controller;

import javafx.fxml.Initializable;
import model.Person;
import util.Constants;
import util.StageManager;

import java.net.URL;
import java.util.ResourceBundle;


public class Calculate {
    private int nextDrinkTimer;
    private int nextDrinkQuantity;
    private int inDoorActivity;
    private int outDoorActivity;

    public Calculate() {
        calculate();
    }

    public int getNextDrinkTimer() {
        return nextDrinkTimer;
    }

    public String getWaterQuantity() {
        return String.valueOf(nextDrinkQuantity);
    }

    public void calculate() {
        //int age = Person.getAge();
        nextDrinkTimer = 5;
        nextDrinkQuantity = 125;
    }
}
