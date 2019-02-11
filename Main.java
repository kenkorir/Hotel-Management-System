package Restaurant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main{

    public Main() throws Exception{

        Stage primaryStage = new Stage();

                Parent root = FXMLLoader.load(getClass().getResource("coded.fxml"));

        primaryStage.setTitle("RESTAURANT MANAGEMENT SYSTEM");

        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.setMaximized(true);

        primaryStage.show();

    }
}
