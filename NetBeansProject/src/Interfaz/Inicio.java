/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JFrame;

public class Inicio extends JFrame{
	String user;
	public Inicio(String u,String ident) {
		super("Bienvenido "+u+" "+ident);
		user=u;
		setLocation(100,50);
		setSize(500,400);
		setDefaultCloseOperation(3);
	}	
}