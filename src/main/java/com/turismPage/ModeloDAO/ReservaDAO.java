package com.turismPage.ModeloDAO;

import com.turismPage.Config.Conexion;
import com.turismPage.Interfaces.CRUDReserva;
import com.turismPage.Modelo.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO implements CRUDReserva {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Reserva reserva = new Reserva();

    @Override
    public List<Reserva> listar() {
        ArrayList<Reserva> list = new ArrayList<>();
        String sql = "SELECT * FROM reserva ORDER BY idreserva ASC";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("idreserva"));
                reserva.setIdCliente(rs.getInt("idcliente"));
                reserva.setIdPaquete(rs.getInt("idpaquete"));
                reserva.setIdEmpleado(rs.getInt("idempleado"));
                reserva.setFechaReserva(rs.getDate("fecha_reserva"));
                reserva.setFechaSalida(rs.getDate("fecha_salida"));
                reserva.setFechaRetorno(rs.getDate("fecha_retorno"));
                reserva.setCantidadPersonas(rs.getInt("cantidad_personas"));
                list.add(reserva);
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
    public Reserva list(int id) {
        String sql = "SELECT * FROM reserva WHERE idreserva = " + id;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                reserva.setIdReserva(rs.getInt("idreserva"));
                reserva.setIdCliente(rs.getInt("idcliente"));
                reserva.setIdPaquete(rs.getInt("idpaquete"));
                reserva.setIdEmpleado(rs.getInt("idempleado"));
                reserva.setFechaReserva(rs.getDate("fecha_reserva"));
                reserva.setFechaSalida(rs.getDate("fecha_salida"));
                reserva.setFechaRetorno(rs.getDate("fecha_retorno"));
                reserva.setCantidadPersonas(rs.getInt("cantidad_personas"));
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
        return reserva;
    }

    @Override
    public boolean add(Reserva reserva) {
        String sql = "INSERT INTO reserva (idcliente, idpaquete, idempleado, fecha_reserva, fecha_salida, fecha_retorno, cantidad_personas) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, reserva.getIdCliente());
            pst.setInt(2, reserva.getIdPaquete());
            pst.setInt(3, reserva.getIdEmpleado());
            pst.setDate(4, new java.sql.Date(reserva.getFechaReserva().getTime()));
            pst.setDate(5, new java.sql.Date(reserva.getFechaSalida().getTime()));
            pst.setDate(6, new java.sql.Date(reserva.getFechaRetorno().getTime()));
            pst.setInt(7, reserva.getCantidadPersonas());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
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
    public boolean edit(Reserva reserva) {
        String sql = "UPDATE reserva SET idcliente = ?, idpaquete = ?, idempleado = ?, fecha_reserva = ?, fecha_salida = ?, fecha_retorno = ?, cantidad_personas = ? WHERE idreserva = ?";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, reserva.getIdCliente());
            pst.setInt(2, reserva.getIdPaquete());
            pst.setInt(3, reserva.getIdEmpleado());
            pst.setDate(4, new java.sql.Date(reserva.getFechaReserva().getTime()));
            pst.setDate(5, new java.sql.Date(reserva.getFechaSalida().getTime()));
            pst.setDate(6, new java.sql.Date(reserva.getFechaRetorno().getTime()));
            pst.setInt(7, reserva.getCantidadPersonas());
            pst.setInt(8, reserva.getIdReserva());
            int rowsUpdated = pst.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
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
        String sql = "DELETE FROM reserva WHERE idreserva = " + id;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
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
}
