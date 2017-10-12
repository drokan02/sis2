/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.VO;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
                new FileChooser.ExtensionFilter("DOC", "*.doc")
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
    
    public boolean validarDocumento(String [] extenciones){
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
