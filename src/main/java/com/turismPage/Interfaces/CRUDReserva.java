package com.turismPage.Interfaces;

import java.util.List;
import com.turismPage.Modelo.Reserva;

public interface CRUDReserva {
    public List listar();
    public Reserva list(int id);
    public boolean add(Reserva reserva);
    public boolean edit(Reserva reserva);
    public boolean delete(int id);
}
