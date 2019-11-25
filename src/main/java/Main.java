import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.Constants;
import util.StageManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/Guide.fxml")); // the file fxml
        primaryStage.setTitle(Constants.GUIDE_SCENE); // Setting the name of the window
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        StageManager.STAGE.put(Constants.PRIMARY_STAGE, primaryStage);
    }

    public static void main(String[] args) { launch(args); }
}
