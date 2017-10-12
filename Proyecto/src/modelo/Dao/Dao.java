/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Dao;

import java.util.List;

/**
 *
 * @author Raul
 */
public interface Dao <T,K,G> {
    
   public void insertar(T a);
   public void modificar(T a);
   public void eliminar(T a);
   public List<T> listar(); 
   public T buscar(G id);
}
