package com.turismPage.Interfaces;

import java.util.List;
import com.turismPage.Modelo.Cliente;

public interface CRUDClient {
    public List listar();
    public Cliente list(int id);
    public boolean add(Cliente cliente);
    public boolean edit(Cliente cliente);
    public boolean delete(int id);
}
