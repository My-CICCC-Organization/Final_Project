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
import model.Bottle;
import model.Person;
import util.Constants;
import util.StageManager;
import util.Tools;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Setup implements Initializable {

    Bottle b = new Bottle();
    Person p = new Person();
    Tools tools = new Tools();

    private ObservableList<String> weightUnit = FXCollections.observableArrayList("Kg","Lb");
    private ObservableList<String> quantityUnit = FXCollections.observableArrayList("ml","oz");


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
     public Button btn_continue;

     @FXML
     private TextField in_size;

     @FXML
     public Text lb_error;

     @FXML
     public ChoiceBox<String> chooseWeightUnit;
     @FXML
     public ChoiceBox<String> chooseQuantityUnit;

     @Override
     public void initialize(URL location, ResourceBundle resources) {
        chooseWeightUnit.setValue("Kg");
        chooseWeightUnit.setItems(weightUnit);
        chooseQuantityUnit.setValue("ml");
         chooseQuantityUnit.setItems(quantityUnit);
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
            lb_error.setText("Correct !");
        }

        // Converting the input into local variables
        String dd = in_dd.getText();
        String mm = in_mm.getText();
        String yyyy = in_yy.getText();
        String name = in_name.getText();
        String weight = in_weight.getText();
        String size = in_size.getText();
        String weightUnit = chooseWeightUnit.getValue();
        String quantityUnit = chooseQuantityUnit.getValue();

        if(weightUnit.equals("Lb")){
            weight = String.valueOf(Tools.exchangeWeight(weight));
        }
        if(quantityUnit.equals("oz")){
            size = String.valueOf(Tools.exchangeSize(size));
        }

        List<String> personalInfo = new ArrayList<String>();
        personalInfo.add(name);
        personalInfo.add(dd + mm + yyyy);
        personalInfo.add(weight);
        Person.setInformation(personalInfo);
        Bottle.set_Size(size);
        StageManager.changeScene(Constants.PRIMARY_STAGE, Constants.MAIN_SCENE);
    }
}


