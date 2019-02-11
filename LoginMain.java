package Register;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("login.xml.fxml"));

        primaryStage.setTitle("RESTAURANT MANAGEMENT SYSTEM");

        primaryStage.setScene(new Scene(root, 400, 600));

        primaryStage.setMaximized(true);

        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
