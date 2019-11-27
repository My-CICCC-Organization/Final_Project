package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.Person;
import util.Constants;
import util.StageManager;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class MainScene implements Initializable {

    @FXML
    private Label nextDrinkTimer;
    @FXML
    private Label amountThisTime;
    @FXML
    private Label lb_time;
    @FXML
    private Text lb_good;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            int hour = LocalDateTime.now().getHour();
            if (hour > 7 && hour < 12){
                lb_good.setText("Good Morning, " + Person.getName());
            }
            if(hour >= 12 && hour < 18){
                lb_good.setText("Good Day, "+ Person.getName());
            }
            if(hour >= 18 && hour < 24){
                lb_good.setText("Good Night, "+ Person.getName());
            }
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        Calculate calculate = new Calculate();
        nextDrinkTimer.setText(String.valueOf(calculate.getNextDrinkTimer()));
        amountThisTime.setText(calculate.getWaterQuantity() + " ml");
        StageManager.showLater(Constants.NOTIFICATION_STAGE,Constants.NOTIFICATION_SCENE, calculate.getNextDrinkTimer());
    }

    public void buttonTapped(ActionEvent actionEvent) {
        /**
         *  minimizeStage
         */
        StageManager.minimizeStage(Constants.PRIMARY_STAGE);
    }
}
