package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import util.Constants;
import util.StageManager;
import java.net.URL;
import java.util.ResourceBundle;


public class Guide implements Initializable {

    private String setupIs;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupIs = Record.read(Constants.FILENAME_PERSON + ".txt");
    }

    public void buttonTapped(ActionEvent actionEvent){
        if (setupIs != null) {
            StageManager.changeScene(Constants.PRIMARY_STAGE, Constants.MAIN_SCENE);
        } else{
            StageManager.changeScene(Constants.PRIMARY_STAGE, Constants.SETUP_SCENE);
        }
    }
}
