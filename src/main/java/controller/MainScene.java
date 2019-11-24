package controller;

import javafx.event.ActionEvent;
import util.Constants;
import util.StageManager;

public class MainScene {
    public void buttonTapped(ActionEvent actionEvent) throws Exception {
        /**
         *  minimizeStage
         */
        StageManager.minimizeStage(Constants.PRIMARY_STAGE);
    }
}
