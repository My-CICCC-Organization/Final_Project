package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import model.Person;
import util.Constants;
import util.StageManager;
import java.net.URL;
import java.util.ResourceBundle;


public class Guide implements Initializable {

    private String setupIs = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupIs = Person.getName();
    }

    public void buttonTapped(ActionEvent actionEvent){
        if (setupIs == null) {
            StageManager.changeScene(Constants.PRIMARY_STAGE, Constants.SETUP_SCENE);
        } else{
            StageManager.changeScene(Constants.PRIMARY_STAGE, Constants.MAIN_SCENE);
        }
    }
}
