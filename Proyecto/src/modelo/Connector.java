package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class Connector {
  protected Connection conexion;
  private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  private final String DB_URL = "jdbc:mysql://localhost/investigaciones";
  private final String user = "root";
  private final String pass = "";



  //metodo para realizar la coneccion
  public void conectar(){
    Connection con = null;
    try {
      Class.forName(JDBC_DRIVER);
      conexion = DriverManager.getConnection(DB_URL,user,pass);
    } catch (ClassNotFoundException ex) {} 
    catch (SQLException ex) {
      String error = "Error: "+ Errores.MessageError(ex.getErrorCode(), 
              ex.getMessage());
      JOptionPane.showMessageDialog(null,error,"Mensaje de Error", 
              JOptionPane.ERROR_MESSAGE);
    }
  }

  public void desconectar(){
    if(conexion != null){
      try {
        if(!conexion.isClosed()){
            conexion.close();
        }
      } catch (SQLException ex) {
        String error = "Error: "+Errores.MessageError(ex.getErrorCode(), 
                ex.getMessage());
        JOptionPane.showMessageDialog(null,error,"Mensaje de Error", 
                JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  public Connection getConexion() {
    if (conexion == null) {
        conectar();
    }
    return conexion;
  }
}