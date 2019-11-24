import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.imageio.IIOException;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("view/setup.fxml")); // the file fxml
            primaryStage.setTitle("iSede"); // Setting the name of the window
            primaryStage.setScene(new Scene(root, 700, 500));
            primaryStage.show();
        }
        catch (IIOException e){

        }
=======
import javafx.stage.Stage;
import util.Constants;
import util.StageManager;
>>>>>>> Wenda

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
