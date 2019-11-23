package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;


public class setup {


    ObservableList<String> units = FXCollections.observableArrayList("Kg","Lb");

    private boolean alreadySetup = false;

    @FXML
    private TextField in_dd;

    @FXML
    private TextField in_mm;

    @FXML
    private TextField in_yy;

    @FXML
    private TextField in_kg;

    @FXML
    private Button btn_continue;

    @FXML
    private TextField in_ml;

    public Text lb_error;

    @FXML
    public ChoiceBox choise_units;


    public void initialize() {
        choise_units.setValue("Kg");
        choise_units.setItems(units);
    }

    public void click_btn_continue(ActionEvent actionEvent) {
        Button btn_continue = (Button) actionEvent.getSource();
        System.out.println(btn_continue.getId() + " CLicked ");


        // checking if the fields are not empty
        if(in_dd.getText().equals("") || in_mm.getText().equals("") || in_yy.getText().equals("") || in_kg.getText().equals("")){
            lb_error.setFill(Paint.valueOf("red"));
            lb_error.setText("You' re missing some fields");
        }else {
            lb_error.setFill(Paint.valueOf("green"));
            lb_error.setText("   Correct !");
        }

        // Converting the input into local variables
        int dd = Integer.parseInt(in_dd.getText());
        int mm = Integer.parseInt(in_mm.getText());
        int yyyy = Integer.parseInt(in_yy.getText());
        int kg = Integer.parseInt(in_kg.getText());
        int ml = Integer.parseInt(in_ml.getText());
        String unit = (String) choise_units.getValue();


            // Typing data into memo.txt
            try (FileWriter fw = new FileWriter("memo", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.print("DOB: ");
                out.println(dd + " / " + mm + " / " + yyyy);
                out.print("WEIGHT: ");
                out.println(kg);
                out.print("SIZE: ");
                out.println(ml);

                // changing the flag
                alreadySetup = true;

                System.out.println("*Data Saved in memo.txt");

            } catch (IOException e) {
                System.out.println("Some Problems bro!");
            }

    }
}
