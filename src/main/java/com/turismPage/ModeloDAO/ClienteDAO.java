package com.turismPage.ModeloDAO;

import com.turismPage.Config.Conexion;
import com.turismPage.Interfaces.CRUDClient;
import com.turismPage.Modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements CRUDClient {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Cliente cli = new Cliente();

    @Override
    public List<Cliente> listar() {
        ArrayList<Cliente> list = new ArrayList<>();
        String sql = "SELECT * FROM cliente ORDER BY idcliente ASC";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("idcliente"));
                cli.setNombre(rs.getString("nombres"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setTelefono(rs.getInt("telefono"));
                cli.setCorreo(rs.getString("correo"));
                cli.setDni(rs.getString("dni"));
                list.add(cli);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Cliente list(int id) {
        ArrayList<Cliente> list = new ArrayList<>();
        String sql = "SELECT * FROM cliente where idcliente="+id;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                cli.setId(rs.getInt("idcliente"));
                cli.setNombre(rs.getString("nombres"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setTelefono(rs.getInt("telefono"));
                cli.setCorreo(rs.getString("correo"));
                cli.setDni(rs.getString("dni"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cli;
    }

    @Override
    public boolean add(Cliente cliente) {
        String sql="INSERT INTO cliente (nombres, direccion, telefono, correo, dni) VALUES " +
                "('"+cliente.getNombre()+"', '"+cliente.getDireccion()+"', '"+cliente.getTelefono()+"', '"+ cliente.getCorreo()+"', '"+cliente.getDni()+"' )";
        try{
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean edit(Cliente cliente) {
        String sql = "UPDATE cliente SET nombres=?, direccion=?, telefono=?, correo=?, dni=? WHERE idcliente=?";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getDireccion());
            pst.setInt(3, cliente.getTelefono());
            pst.setString(4, cliente.getCorreo());
            pst.setString(5, cliente.getDni());
            pst.setInt(6, cliente.getId());
            int rowsUpdated = pst.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    @Override
    public boolean delete(int id) {
        String sql="delete from cliente where idcliente="+id;
        try{
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
        }catch (Exception e){

        }
        return false;
    }
}
