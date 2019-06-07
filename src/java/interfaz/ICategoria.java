/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import transferObject.Categoria;

/**
 *
 * @author Computer
 */
public interface ICategoria {
    public abstract ArrayList<Categoria> listarCategoria();
    public abstract boolean insertarCategoria(Categoria categoria);//OBJETO
    public abstract boolean actualizarCategoria(Categoria categoria);
    public abstract boolean eliminarCategoria(int idCategoria);
}
