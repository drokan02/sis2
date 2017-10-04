/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conexion {
	
        Connection conx;
        boolean estado;
        private String nomCompleto,respuesta,cargo;
        
	public Conexion(){
		try {
	    	Class.forName("com.mysql.jdbc.Driver").newInstance();
	    	conx=DriverManager.getConnection("jdbc:mysql://localhost:3306/investigaciones","root","");
	    	estado=true;
		}
		catch (Exception ex) {
			System.out.println (ex.toString());
			estado=false;
		}
	}
	public boolean verificar(String us,String pas){
		try {
                        Statement stt = conx.createStatement();
			ResultSet res = stt.executeQuery("select * from usuario where nick='"+us+"' AND password="+pas);
                        if(!res.next())
                        {
                            respuesta="Usuario o contraseña INCORRECTA";
                            return false;
                        }
                        else{
                            int ca=Integer.parseInt(res.getString("nivel_acceso"));
                            if(ca==0)cargo="Administrador";
                            else cargo="usuario";
                            nomCompleto=res.getString("nombre_completo");
                            respuesta="contraseña correcta";
                            return true;
                        }
                }
		catch (Exception ex) {
                    System.out.println(ex.toString());
                    System.out.println("error al verificar");
                    return false;
		}
		
	}
	public boolean getEstado(){
		return estado;
	}
        public String identidad(){
            return "cargo: "+cargo+" Nombre: "+nomCompleto;
        }
        public String getRespuesta(){
            return respuesta;
        }
}