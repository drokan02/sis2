package modelo;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Raul
 */
public class Document {
  private File document;

  public Document(){
    fileChooser();
  }

  public Document(File document){
    this.document = document;
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
    document = fileChooser.showOpenDialog(stage);       
  }
  public File getDocument() {
    return document;
  }

  public void setFile(File document) {
    this.document = document;
  }

  public boolean validateDocument(String[] extensions){
    boolean res = true;
    int i = 0;
    while(i < extensions.length && res == true){
        if(!document.getName().endsWith(extensions[i]))
            res = false;
        i++;
    }
    return res;
  }
}
