/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 *
 * @author pc
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField userNameInput;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXPasswordField passwordInput;

    @FXML
    public void makeLogin(ActionEvent event) {
        if (Validators.validateLetters(userNameInput.toString()) && !passwordInput.toString().isEmpty()) {
            System.out.println("succes");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error in Login");
            alert.setContentText("The fields can't be empties or UserName invalid");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
