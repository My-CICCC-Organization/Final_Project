package controller;

import javafx.event.ActionEvent;
import util.StageManager;

public class MainScene {
    public void buttonTapped(ActionEvent actionEvent) throws Exception {
        /**
         *  minimizeStage
         */
        StageManager.minimizeStage("primary");
        //Save Setup to Stack
        StageManager.CONTROLLER.push(this);
    }
}
