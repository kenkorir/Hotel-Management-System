package Register;

import Connectivity.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import Restaurant.Main;
import javafx.stage.Stage;


public class Login implements Initializable {

    public PasswordField paswordf;

    @FXML
    public TextField usernametxt;

    @FXML
    public Button loginbtn;


    public Login() {
    }

    public void initialize() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void onLoginPress() throws Exception {
        String username = "Admin";
        String Password = "";

        new Main();

//        if (("Admin" == usernametxt.getText())) {
//
//            new Main();
//
//        } else {
//
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText(null);
//            alert.setContentText("Wrong Username and Password Combination");
//            alert.showAndWait();
//
//        }

    }

}
