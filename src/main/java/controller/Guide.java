package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.StageManager;

public class Guide {
    public void buttonTapped(ActionEvent actionEvent) throws Exception {
        /**
         * Open Setup
        */
        StageManager.changeScene("primary", "Setup");
        //Save Setup to Stack
        StageManager.CONTROLLER.push(this);
    }
}
