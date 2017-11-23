package modelo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sun.awt.DesktopBrowse;

/**
 *
 * @author Raul
 */
public class Documento {
  private File archivo;

  public Documento(){
    fileChooser();
  }

  public Documento(File archivo){
    this.archivo = archivo;
  }

  private void fileChooser(){
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Buscar Documento");
    fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("All Document", "*.*"),
            new FileChooser.ExtensionFilter("PDF", "*.pdf"),
            new FileChooser.ExtensionFilter("DOCX", "*.doc")
    );
    Stage stage = new Stage();
    archivo = fileChooser.showOpenDialog(stage);       
  }
  public File getArchivo() {
    return archivo;
  }

  public void setArchivo(File archivo) {
    this.archivo = archivo;
  }

  public boolean validarDocumento(String[] extenciones){
    boolean res = true;
    int i = 0;
    while(i < extenciones.length && res == true){
        if(!archivo.getName().endsWith(extenciones[i]))
            res = false;
        i++;
    }
    return res;
  }
}
