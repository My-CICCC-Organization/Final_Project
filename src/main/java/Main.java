import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.StageManager;

public class Main extends Application {
    public static final String PRIMARY_STAGE = "primary";
    public static final String GUIDE_SCENE = "guide";
    public static final String SETUP_SCENE = "setup";
    public static final String MAIN_SCENE = "mainScene";
    public static final String NOTIFICATION_STAGE = "notification";
    public static final String NOTIFICATION_SCENE = "notification";
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/Guide.fxml")); // the file fxml
        primaryStage.setTitle(GUIDE_SCENE); // Setting the name of the window
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        StageManager.STAGE.put(PRIMARY_STAGE, primaryStage);
    }

    public static void main(String[] args) { launch(args); }
}
