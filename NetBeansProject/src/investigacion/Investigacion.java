package investigacion;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interfaz.Inicio;

import Data.Conexion;

public class Investigacion extends JFrame{
    Conexion com;
    Inicio ini;
    JButton iniciarB,cancelarB;
    JTextField user;
    JPasswordField pass;
    JLabel icon;
    public static void main(String[] args) {
		Investigacion in=new Investigacion();
		in.setVisible(true);
    }
    public Investigacion(){
    	super("Login");
    	
    	com=new Conexion();
    	if(!com.getEstado())setTitle("Login error al conectar");
        else setTitle("Login  <<conectado>>");
    	
    	setLayout(null);
    	icon=new JLabel();
    	ImageIcon ic=new ImageIcon("img/user.png");
    	icon.setIcon(ic);
    	icon.setBounds(5,5,ic.getIconWidth(),ic.getIconHeight());
    	
    	user=new JTextField("Encargado");
    	user.setBounds(150,20,240,30);
    	
    	pass=new JPasswordField("1234567890");
    	pass.setBounds(150,55,240,30);
    	
    	iniciarB=new JButton("Iniciar");
    	iniciarB.setBounds(185,105,85,30);
    	
    	cancelarB=new JButton("Cancelar");
    	cancelarB.setBounds(275,105,85,30);
    	
    	add(icon);
    	add(user);
    	add(pass);
    	add(iniciarB);
    	add(cancelarB);
    	
    	setLocation(100,50);
    	setSize(400,170);
    	setResizable(false);
    	setDefaultCloseOperation(3);
    	EventoLog eventos=new EventoLog();
    	iniciarB.addActionListener(eventos);
    	cancelarB.addActionListener(eventos);
    }
    class EventoLog implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==iniciarB){
    			if(com.verificar(user.getText(),pass.getText())){
    				setVisible(false);
    				ini=new Inicio(user.getText(),com.identidad());
    				ini.setVisible(true);
    			}
                        else{
                            setTitle("Login   "+com.getRespuesta());
                            pass.setText("");
                            user.setText("");
                        }
    		}
    		if(e.getSource()==cancelarB){
    			System.exit(0);
    		}
    	}
    }
}
