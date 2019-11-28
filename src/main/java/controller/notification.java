package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import util.Constants;
import util.StageManager;

import java.net.URL;
import java.util.ResourceBundle;

public class notification implements Initializable {

    @FXML
    private Label AmountThisTime;

    @FXML
    private Button snooze;

    @FXML
    private Button goToInPut;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String quantity = Calculate.calculate().get(Constants.NEXT_WATER_QUANTITY);
        AmountThisTime.setText(quantity + " ml");
    }

    public void snooze() {
        //Stage stage = (Stage) snooze.getScene().getWindow();
        //stage.close();
        StageManager.showLater(Constants.NOTIFICATION_STAGE,Constants.NOTIFICATION_SCENE, 5);
        StageManager.closeStage(Constants.NOTIFICATION_STAGE);
    }

    public void goToInPut() {
        /**
         * Open Input
         */
        StageManager.changeScene(Constants.PRIMARY_STAGE,Constants.INPUT_SCENE);
        StageManager.closeStage(Constants.NOTIFICATION_STAGE);
    }
}
