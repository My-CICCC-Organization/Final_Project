package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

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

    public void initialize(URL url, ResourceBundle resourceBundle) {
        // this is where you initialize your fields
        this.btn_continue = btn_continue;

    }

    public void buttonTapped(ActionEvent actionEvent) {
        Button btn_continue = (Button) actionEvent.getSource();
        System.out.println(btn_continue.getId());
    }

}
