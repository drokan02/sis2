/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Raul
 */
public class UserMysql implements Mysql<User>{
    private Connector conn;
    private Connection con;
    protected Statement st;
    protected ResultSet rt;
    protected PreparedStatement pst;
    
    @Override
    public String insert(User a) {
        String res = "";
        String insert = "INSERT into usuario(username,password,first_name,last_name,email,university) "
                      + "values (?,?,?,?,?,?)"; 
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
        try {
            pst = con.prepareStatement(insert);
            pst.setString(1, a.getUserName());
            pst.setString(2, a.getPassword());
            pst.setString(3, a.getFirstName());
            pst.setString(4, a.getLastName());
            pst.setString(5, a.getEmail());
            pst.setString(6, a.getUniversity());
            int n = pst.executeUpdate();
            if (n > 0){
                res = "correctly registered user";
            }
        } catch (SQLException ex) {
                res = Errores.MessageError(ex.getErrorCode(), ex.getMessage());
        }
        return res;  
    }

    @Override
    public String edit(User a) {
        String res = "";
        String edit = "UPDATE usuario SET "
                      + "username = '"+a.getUserName()+"', "
                      + "password = "+a.getPassword()+", "
                      + "first_name = "+a.getFirstName()+", "
                      + "last_name = "+a.getLastName()+", "
                      + "email = "+a.getEmail()+" "
                      + "university = "+a.getUniversity()+" "
                      + "WHERE ci_cli = "+a.getId()+"";
        try {
            st = con.createStatement();
            int n = st.executeUpdate(edit);
            if(n > 0){
              res = "Cliente editado correctamente";
            }
        } catch (SQLException ex) {
              res = Errores.MessageError(ex.getErrorCode(), ex.getMessage());
        }
        return res;
    }

    @Override
    public String delete(User a) {
        String res = "";
        String delete = "DELETE from cliente "
                       + "WHERE ci_cli = '"+a.getId()+"'";
        try {
            st = con.createStatement();
            int n = st.executeUpdate(delete);
            if (n > 0){
                res = "Cliente eliminado correctamente";
            }
        } catch (SQLException ex) {
            res = Errores.MessageError(ex.getErrorCode(), ex.getMessage());
        }
        return res;
    }
    
    @Override
    public ArrayList<User> list(String description) {
        ArrayList<User> res = new ArrayList<>();
        String list = "SELECT id_user,username,password,first_name,last_name,email,university "
                     + "FROM usuario "
                     + "WHERE concat(username,' ',first_name,' ',last_name,' ',email,' ',university) like '%"+description+"%'";
                        
        try {
            st = con.createStatement();
            rt = st.executeQuery(list);
            while(rt.next()){
                res.add(new User(rt.getInt(1), rt.getString(2), rt.getString(3), rt.getString(4), rt.getString(5), rt.getString(6), rt.getString(7)));         
             }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return res;
    }

    @Override
    public User search(User a) {
        String search = "SELECT username,password,first_name,last_name,email,university "
                      + "FROM usuario "
                      + "WHERE ci_cli = '"+a.getId()+"'";           
        try {
            st = con.createStatement();
            rt = st.executeQuery(search);
            if(rt.next()){
                a.setUserName(rt.getString(1));
                a.setPassword(rt.getString(2));
                a.setFirstName(rt.getString(3));
                a.setLastName(rt.getString(4));
                a.setEmail(rt.getString(5));
                a.setUniversity(rt.getString(6));    
            }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,Errores.MessageError(ex.getErrorCode(), ex.getMessage()));
        }
        return a;
    }
    
}
