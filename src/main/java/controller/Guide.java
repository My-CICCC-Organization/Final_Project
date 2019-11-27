package controller;

import javafx.event.ActionEvent;
import util.Constants;
import util.StageManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Guide {

    private String setupIs;
    public void initialize() throws IOException {
        String FileName = "PersonalInfo";
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(FileName));
        setupIs = br.readLine();
    }

    public void buttonTapped(ActionEvent actionEvent){

        if (setupIs != null) {
            StageManager.changeScene(Constants.PRIMARY_STAGE, Constants.MAIN_SCENE);
        } else{
            StageManager.changeScene(Constants.PRIMARY_STAGE, Constants.SETUP_SCENE);
        }
    }
}
