package controller;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.StageManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculate{
     public void calculate() {
         /**
          * Start Notification
          */
         Stage stage = StageManager.STAGE.get("notification");
         if (stage == null) {
             stage = StageManager.newStage("notification", "notification");
         }

         Stage finalStage = stage;
         Platform.runLater(new Runnable() {
             @Override
             public void run() {
                finalStage.show();
             }
         });
     }
}
