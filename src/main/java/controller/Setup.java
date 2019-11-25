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

     public int dd =  0;
     public int mm = 0;
     public int yyyy = 0;
     public int kg = 0;
     public int ml = 0;
     public String name;



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
        dd =Integer.parseInt(in_dd.getText());
        mm =Integer.parseInt(in_mm.getText());
        yyyy = Integer.parseInt(in_yy.getText());
        name = in_name.getText();
        kg =Integer.parseInt(in_kg.getText());
        ml =Integer.parseInt(in_ml.getText());
        String unit = choise_units.getValue();


        // Typing data into memo.txt
        try (FileWriter fw = new FileWriter("memo", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)){
            out.println("SetupDone");
            out.println(name);
            out.println(dd);
            out.println(mm);
            out.println(yyyy);
            out.println(kg);
            out.println(ml);

            System.out.println("*Data Saved in memo.txt");
            bw.close();
            out.close();
            StageManager.changeScene(Constants.PRIMARY_STAGE, Constants.MAIN_SCENE);


        } catch (IOException e) {
            System.out.println("Some Problems bro!");
        }

    }
}


