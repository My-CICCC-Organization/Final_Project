package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.Duration;
import util.Constants;
import util.StageManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class MainScene {
    @FXML
    public Label AmountThisTime;
    @FXML
    public Label lb_time;
    @FXML
    public Text lb_good;

    private int minute;
    private int hour;
    private int seconds;



    private Setup a = new Setup();


    public void initialize() throws IOException {
        Record record = Record.read();
        AmountThisTime.setText(record.getMl() + " ml");

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            minute = LocalDateTime.now().getMinute();
            hour = LocalDateTime.now().getHour();
            seconds = LocalDateTime.now().getSecond();
            if (hour > 7 && hour < 12){
                lb_good.setText("Good Morning, " + record.getName());
            }
            if(hour >= 12 && hour < 18){
                lb_good.setText("Good Day, "+ record.getName());
            }
            if(hour >= 18 && hour < 24){
                lb_good.setText("Good Night, "+ record.getName());
            }

        }),
                new KeyFrame(Duration.seconds(1))
        );

        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();



    }



    public void buttonTapped(ActionEvent actionEvent) throws Exception {
        /**
         *  minimizeStage
         */
        StageManager.minimizeStage(Constants.PRIMARY_STAGE);
    }
}
