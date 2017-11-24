/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Raul
 */
public interface Mysql <T> {
   
   public String insert(T a);
   public String edit(T a);
   public String delete(T a);
   public ArrayList<T> list(String description);
   public T search(T a);
}
