package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import model.Person;
import util.Constants;
import util.StageManager;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Setup implements Initializable {

     private ObservableList<String> weightUnit = FXCollections.observableArrayList("Kg","Lb");

     @FXML
     private TextField in_dd;

     @FXML
     private TextField in_mm;

     @FXML
     private TextField in_yy;

     @FXML
     public TextField in_name;

     @FXML
     private TextField in_weight;

     @FXML
     private Button btn_continue;

     @FXML
     private TextField in_size;

     @FXML
     public Text lb_error;

     @FXML
     public ChoiceBox<String> chooseWeightUnit;

     @Override
     public void initialize(URL location, ResourceBundle resources) {
        chooseWeightUnit.setValue("Kg");
        chooseWeightUnit.setItems(weightUnit);
    }

    public void click_btn_continue(ActionEvent actionEvent) {
        Button btn_continue = (Button) actionEvent.getSource();
        System.out.println(btn_continue.getId() + " CLicked ");


        // checking if the fields are not empty
        if(in_dd.getText().equals("") || in_mm.getText().equals("") || in_yy.getText().equals("") || in_weight.getText().equals("") || in_name.getText().equals("")){
            lb_error.setFill(Paint.valueOf("red"));
            lb_error.setText("You' re missing some fields");
        }else {
            lb_error.setFill(Paint.valueOf("green"));
            lb_error.setText("   Correct !");
        }

        // Converting the input into local variables
        String dd = in_dd.getText();
        String mm = in_mm.getText();
        String yyyy = in_yy.getText();
        String name = in_name.getText();
        String weightUnit = chooseWeightUnit.getValue();
        //TODO
        String weight = in_weight.getText();
        //TODO
        String size = in_size.getText();

        List<String> personalInfo = new ArrayList<String>();
        personalInfo.add(name);
        personalInfo.add(yyyy+mm+dd);
        personalInfo.add(weight);
        Person.setInformation(personalInfo);
        //TODO
        // Bottle.setSize(size);

        StageManager.changeScene(Constants.PRIMARY_STAGE, Constants.MAIN_SCENE);
    }
}


