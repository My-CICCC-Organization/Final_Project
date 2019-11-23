package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import util.StageManager;

import javax.imageio.IIOException;
import java.io.IOException;
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
        AmountThisTime.setText("1000ml");
    }

    public void snooze() {
        //Stage stage = (Stage) snooze.getScene().getWindow();
        //stage.close();
        StageManager.closeStage("notification");
    }

    public void goToInPut() {
        /**
         * Open Input
         */
        StageManager.changeScene("primary","Input");
        snooze();
        //Save Setup to Stack
        StageManager.CONTROLLER.push(this);
    }
}
