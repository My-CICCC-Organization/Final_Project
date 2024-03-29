package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class StageManager {
    public static Map<String, Stage> STAGE = new HashMap<String, Stage>();
    public static Stack<Object> CONTROLLER = new Stack<Object>();

    public static Stage newStage(String stage, String scene){
        try{
            Stage s = new Stage();
            Parent root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("view/"+scene+".fxml"));
            s.setTitle(scene);
            s.setScene(new Scene(root));
            STAGE.put(stage, s);
            return s;
        } catch (IOException e) {
            return null;
        }
    }

    public static void changeScene(String stage,String scene) {
        try {
            Stage s = StageManager.STAGE.get(stage);
            if (s == null) {
                s = newStage(stage, scene);
            }
            Parent root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("view/"+scene+".fxml"));
            s.setTitle(scene);
            s.setScene(new Scene(root));
            s.show();
        } catch (IOException e) {

        }
    }
    public static void showLater(String stage,String scene, int time) {
        Stage s = StageManager.STAGE.get(stage);
        if (s == null) {
            s = newStage(stage, scene);
        }
        Stage finalStage = s;
        ActionListener taskPerformer = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Platform.runLater(finalStage::show);
            }
        };
        new Timer(time*1000*60,taskPerformer).start();
    }
    public static void minimizeStage(String stage) {
        Stage s = StageManager.STAGE.get(stage);
        s.setIconified(true);
    }
    public static void closeStage(String stage) {
        Stage s = StageManager.STAGE.get(stage);
        s.close();
    }
}