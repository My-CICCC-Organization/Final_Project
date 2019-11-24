package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.Constants;
import util.StageManager;
import java.net.URL;
import java.util.ResourceBundle;

public class Setup implements Initializable {

    @FXML
    private TextField in_dd;

    @FXML
    private TextField in_mm;

    @FXML
    private TextField in__yy;

    @FXML
    private TextField in_kg;

    @FXML
    private Button btn_continue;

    @FXML
    private TextField in_ml;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // this is where you initialize your fields
        this.btn_continue = btn_continue;
    }

    public void buttonTapped(ActionEvent actionEvent) throws Exception {
        Button btn_continue = (Button) actionEvent.getSource();
        /**
         * Calculate Time and Amount
         */
        Calculate calculate = new Calculate();
        calculate.calculate();
        /**
         * Open MainScene
         */
        StageManager.changeScene(Constants.PRIMARY_STAGE, Constants.MAIN_SCENE);
    }

}
