package controller;

import util.StageManager;

public class Calculate{
    private int nextDrinkTimer;

    public Calculate() {
        this.nextDrinkTimer = 30;
    }

    public void calculate() {
        /**
          * Start Notification
          */
        StageManager.showLater("notification","notification", nextDrinkTimer);
     }
}
