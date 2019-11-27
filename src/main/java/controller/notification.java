package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import util.Constants;
import util.StageManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


    public class notification  {


    @FXML
    private Label AmountThisTime;

    @FXML
    private Button snooze;

    @FXML
    private Button goToInPut;


    public void initialize() throws IOException {

            String FileName = "memo";
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(FileName));
            br.readLine();
            String name = br.readLine();
            br.readLine();
            br.readLine();
            br.readLine();
            br.readLine();
            String quantity = br.readLine();
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
