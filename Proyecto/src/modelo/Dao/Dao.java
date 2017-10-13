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
