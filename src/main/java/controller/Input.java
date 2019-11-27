package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.UUID;

public class Input implements Initializable {

    @FXML
    private TextField day;
    @FXML
    private TextField month;
    @FXML
    private TextField year;
    @FXML
    private TextField weight;
    @FXML
    private TextField cup;

    // provinces as fields
    //private Person[] person;

    @FXML
    private void initialSetting(ActionEvent event) {
        UUID uuid = UUID.randomUUID();
        // birthday
        String StringBd = this.year.getText() + this.month.getText() + this.day.getText();
        LocalDate localDate = LocalDate.parse(StringBd, DateTimeFormatter.ofPattern("yyyyMMdd"));
        // default constructor

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
