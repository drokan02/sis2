package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import modelo.VO.Documento;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

public class LoginController implements Initializable {

  @FXML
  private JFXTextField userNameInput;

  @FXML
  private JFXButton loginButton;

  @FXML
  private JFXButton signUpButton;

  @FXML
  private JFXPasswordField passwordInput;

  @FXML
  public void makeLogin(ActionEvent event) {
    Documento doc = new Documento();
    if (Validators.validateLetters(userNameInput.toString()) && !passwordInput.toString().isEmpty()) {
      System.out.println("succes");
    } else {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error in Login");
      alert.setContentText("The fields can't be empties or UserName invalid");
      alert.showAndWait();
    }
  }

  @FXML
  void goToSignUp(ActionEvent event) throws IOException{
    Stage stage; 
    Parent root;        
    stage=(Stage) signUpButton.getScene().getWindow();
    //load up OTHER FXML document
    root = FXMLLoader.load(getClass().getResource("/vista/FXMLSignUp.fxml"));
    //create a new scene with root and set the stage
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }


  @Override
  public void initialize(URL url, ResourceBundle rb) {
     // TODO
  }

}
