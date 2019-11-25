import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.Constants;
import util.StageManager;

import javax.imageio.IIOException;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("view/Guide.fxml")); // the file fxml
            primaryStage.setTitle("iSede"); // Setting the name of the window
            primaryStage.setScene(new Scene(root, 700, 500));
            primaryStage.setTitle(Constants.GUIDE_SCENE); // Setting the name of the window
            StageManager.STAGE.put(Constants.PRIMARY_STAGE, primaryStage);
            primaryStage.show();
        }
        catch (IIOException e){

        }
    }

    public static void main(String[] args) { launch(args); }
}
