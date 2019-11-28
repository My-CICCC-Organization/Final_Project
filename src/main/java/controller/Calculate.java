package controller;

import model.Person;
import util.Constants;
import util.StageManager;

import java.util.HashMap;
import java.util.Map;


public class Calculate {
    private static int nextDrinkTime = 30;
    private static int nextWaterQuantity = 300;

    public static Map<String, String> calculate() {
        Map<String, String> calculateResult = new HashMap<>();

        int age = Person.getAge();
        double weight = Person.getWeight();

        int wholeDayWaterQuantity;
        if (age <= 17) {
            wholeDayWaterQuantity = (int) Math.round(weight) * Constants.AGE_17;
        } else if (age <= 24) {
            wholeDayWaterQuantity = (int) Math.round(weight) * Constants.AGE18_24;
        } else if (age <= 54) {
            wholeDayWaterQuantity = (int) Math.round(weight) * Constants.AGE25_54;
        } else if (age <= 64) {
            wholeDayWaterQuantity = (int) Math.round(weight) * Constants.AGE55_64;
        } else {
            wholeDayWaterQuantity = (int) Math.round(weight) * Constants.AGE65_;
        }

        Map<String, String> record = Record.readRecodeFileAsMap();
        int takenWaterQuantity = Integer.parseInt(record.get(Constants.TAKEN_QUANTITY));
        int inDoorActivity = Integer.parseInt(record.get(Constants.INDOOR_ACTIVITY));
        int outDoorActivity = Integer.parseInt(record.get(Constants.OUTDOOR_ACTIVITY));

        if (inDoorActivity != 0) {
            nextDrinkTime *= 0.8;
            nextWaterQuantity *= 1.2;
        }

        if (outDoorActivity != 0) {
            nextDrinkTime *= 0.6;
            nextWaterQuantity *= 1.5;
        }

        if (takenWaterQuantity == wholeDayWaterQuantity) {
            nextDrinkTime = 0;
            nextWaterQuantity = 0;
        } else {
            StageManager.showLater(Constants.NOTIFICATION_STAGE, Constants.NOTIFICATION_SCENE, nextDrinkTime);
        }

        calculateResult.put(Constants.NEXT_DRINK_TIME, String.valueOf(nextDrinkTime));
        calculateResult.put(Constants.NEXT_WATER_QUANTITY, String.valueOf(nextWaterQuantity));
        return calculateResult;
    }
}
