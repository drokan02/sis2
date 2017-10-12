/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import modelo.VO.Documento;
import sun.awt.DesktopBrowse;



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
  void makeLogin(ActionEvent event) {
        Documento doc = new Documento();
  }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  
    
}
