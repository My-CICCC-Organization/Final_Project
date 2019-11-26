package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import util.Constants;
import util.StageManager;

import java.io.*;

 public class Setup {

     public String dd;
     public String name;
     public String mm;
     public String yyyy;
     public String kg;
     public String ml;
     public String unit;



     ObservableList<String> units = FXCollections.observableArrayList("Kg","Lb");



     @FXML
    private TextField in_dd;

    @FXML
    private TextField in_mm;

    @FXML
    private TextField in_yy;

    @FXML
     public TextField in_name;

    @FXML
    private TextField in_kg;

    @FXML
    private Button btn_continue;

    @FXML
    private TextField in_ml;

    public Text lb_error;

    @FXML
    public ChoiceBox<String> choise_units;



     public void initialize() throws IOException {
        choise_units.setValue("Kg");
        choise_units.setItems(units);
    }

    public void click_btn_continue(ActionEvent actionEvent) {
        Button btn_continue = (Button) actionEvent.getSource();
        System.out.println(btn_continue.getId() + " CLicked ");


        // checking if the fields are not empty
        if(in_dd.getText().equals("") || in_mm.getText().equals("") || in_yy.getText().equals("") || in_kg.getText().equals("") || in_name.getText().equals("")){
            lb_error.setFill(Paint.valueOf("red"));
            lb_error.setText("You' re missing some fields");
        }else {
            lb_error.setFill(Paint.valueOf("green"));
            lb_error.setText("   Correct !");
        }

        // Converting the input into local variables
        dd = in_dd.getText();
        mm = in_mm.getText();
        yyyy = in_yy.getText();
        name = in_name.getText();
        kg = in_kg.getText();
        ml = in_ml.getText();
        unit = choise_units.getValue();

        Record.store(name);
        Record.store(dd);
        Record.store(mm);
        Record.store(yyyy);
        Record.store(kg);
        Record.store(ml);
        Record.store(unit);

        StageManager.changeScene(Constants.PRIMARY_STAGE, Constants.MAIN_SCENE);



    }
}


