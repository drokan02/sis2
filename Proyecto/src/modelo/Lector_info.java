/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author pc
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileReader;


public class Lector_info {
    public static String leertxt(String direccion){
      String text="";
    try{
        BufferedReader bf = new BufferedReader(new FileReader(direccion));
        String aux="";
        String read;
        while((read = bf.readLine()) !=null){
            aux =aux+read;
        }
        text = aux;
    }catch(Exception e){
        System.err.println("Archivo no encontrado");
    }    
    return  text;
    }
    public static void main(String [] args){
        leertxt("src\\modelo\\aspectos_basicos.txt");
        
    }
}

