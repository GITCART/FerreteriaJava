/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conection.Conexion;
import interfaz.ICategoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transferObject.Categoria;

/**
 *
 * @author Computer
 */
public class CategoriaDao implements ICategoria {
    /*
     Conexion conn;

     public CategoriaDao(Conexion conn) {
     this.conn = conn;
     }
     */

    @Override
    public ArrayList<Categoria> listarCategoria() {
        ArrayList<Categoria> listaCategoria = new ArrayList<>(); //tipo de dato
        Conexion conn = new Conexion();
        Connection cn = conn.getConnection();
        //PROCESO
        if (cn != null) {
            try {
                String sp = "{CALL SP_LISTARCATEGORIA()}";
                CallableStatement cs = cn.prepareCall(sp);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setIdCategoria(rs.getInt("idCategoria"));
                    categoria.setDescripcion(rs.getString("descripcion"));
                    categoria.setEstado(rs.getString("estado").charAt(0));
                    listaCategoria.add(categoria);
                }
            } catch (SQLException e) {
                System.out.println("Error. " + e);
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.out.println("Error " + e);
                }
            }
        }
        return listaCategoria;
     }

    @Override
    public boolean insertarCategoria(Categoria categoria) {
        boolean insert = false;
        int res;
        Conexion conn = new Conexion();
        Connection cn = conn.getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall("CALL SP_INSERTARCATEGORIA(?,?,?)");
                cs.setInt(1, categoria.getIdCategoria());
                cs.setString(2, categoria.getDescripcion());
                cs.setString(3, String.valueOf(categoria.getEstado()));
                res = cs.executeUpdate();
                if (res == 1) {
                    insert = true;
                }
            } catch (SQLException e) {
                System.out.println("Error." + e);
            } finally {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    System.out.println("Error." + ex);
                }
            }
        }

        return insert;
    }

    @Override
    public boolean actualizarCategoria(Categoria categoria) {
        boolean update = false;
        int res;
        Conexion conn = new Conexion();
        Connection cn = conn.getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall("CALL SP_ACTUALIZARCATEGORIA(?,?,?)");
                cs.setInt(1, categoria.getIdCategoria());
                cs.setString(2, categoria.getDescripcion());
                cs.setString(3, String.valueOf(categoria.getEstado()));
                res = cs.executeUpdate();
                if (res == 1) {
                    update = true;
                }
            } catch (SQLException e) {
                System.out.println("Error" + e);
            } finally {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    System.out.println("Error." + ex);
                }
            }
        }
        return update;
    }

    @Override
    public boolean eliminarCategoria(int idCategoria) {
        boolean delete = false;
        int res;
        Conexion conn = new Conexion();
        Connection cn = conn.getConnection();
        if(cn!= null){
            try {
                CallableStatement cs = cn.prepareCall("CALL SP_ELIMINARCATEGORIA(?)");
                cs.setInt(1, idCategoria);
                res=cs.executeUpdate();
                if(res==1){
                    delete = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error."+ex);
            }finally{
                try {
                    cn.close();
                } catch (SQLException ex) {
                    System.out.println("error"+ ex);
                }
            }
        }
        return delete;
    }

}
