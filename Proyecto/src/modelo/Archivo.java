/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class Archivo {
    private File archivo;
    
    public Archivo(){
        fileChooser();
    }
    public Archivo(File archivo){
    this.archivo = archivo;
    }
    private void fileChooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Documento");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Document", "*.*"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("DOC", "*.doc")
        );
        Stage stage = new Stage();
        archivo = fileChooser.showOpenDialog(stage);
        if(archivo != null)
            JOptionPane.showMessageDialog(null, "bien");
    }
    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
}
