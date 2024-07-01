package com.turismPage.Modelo;

import java.util.Date;

public class Reserva {
    int idReserva;
    int idCliente;
    int idPaquete;
    Integer idEmpleado;  // Puede ser null
    Date fechaReserva;
    Date fechaSalida;
    Date fechaRetorno;
    int cantidadPersonas;

    public Reserva() {
    }

    public Reserva(int idCliente, int idPaquete, Integer idEmpleado, Date fechaReserva, Date fechaSalida, Date fechaRetorno, int cantidadPersonas) {
        this.idCliente = idCliente;
        this.idPaquete = idPaquete;
        this.idEmpleado = idEmpleado;
        this.fechaReserva = fechaReserva;
        this.fechaSalida = fechaSalida;
        this.fechaRetorno = fechaRetorno;
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(Date fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
}
