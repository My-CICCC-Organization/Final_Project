package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import model.Person;
import util.Constants;
import util.StageManager;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class Input implements Initializable {

    private int waterQuantity;
    private String OutsideExercise = null;
    private String InsideExercise = null;
    private String takenQuantity;
    private String record;

    @FXML
    private Slider waterQt;
    @FXML
    private Slider exerQt;
    @FXML
    private RadioButton exerOut;
    @FXML
    private RadioButton exerIn;
    @FXML
    private Button btn_continue;

    public void initialize( URL location, ResourceBundle resources) {
        // this is where you initialize your fields
        this.btn_continue = btn_continue;
    }

    public void buttonTapped( ActionEvent actionEvent){

        // set Water quantity
        waterQuantity = (int) waterQt.getValue();

        // set Exercise
        if (exerIn.isSelected()){
            InsideExercise = Double.toString(exerQt.getValue());
        } else if (exerOut.isSelected()){
            OutsideExercise = Double.toString(exerQt.getValue());
        }

        // calculate taken quantity (how much have you drunk today)
        takenQuantity = Integer.toString(waterQuantity + Person.getTakenQuantity());

        // get current time
        LocalDateTime ldt = LocalDateTime.now();

        // put above values to the string
        // UUID, Water quantity, Indoor exercise, Outdoor exercise, taken Quantity, current time
        record = Person.getUUID() + ","
                + waterQuantity + ","
                + InsideExercise + ","
                + OutsideExercise + ","
                + takenQuantity + ","
                + ldt;

        // call Record class
        Record.write(Constants.FILENAME_RECORD, record);

        /**
         * Open MainScene
         */
        StageManager.changeScene(Constants.PRIMARY_STAGE, Constants.MAIN_SCENE);

    }

}
