package com.turismPage.Controlador;

import com.turismPage.Modelo.Reserva;
import com.turismPage.ModeloDAO.ReservaDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ControladorReserva")
public class ControladorReserva extends HttpServlet {

    String listar = "vistas/Reserva/listarReserva.jsp";
    String add = "vistas/Reserva/addReserva.jsp";
    String edit = "vistas/Reserva/editReserva.jsp";
    int id;
    Reserva reserva = new Reserva();
    ReservaDAO dao = new ReservaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action != null) {
            if (action.equalsIgnoreCase("listar")) {
                try {
                    List<Reserva> listaReservas = dao.listar();
                    request.setAttribute("reservas", listaReservas);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                acceso = listar;
            } else if (action.equalsIgnoreCase("add")) {
                acceso = add;
            } else if (action.equalsIgnoreCase("Agregar")) {
                int idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));
                int idPaquete = Integer.parseInt(request.getParameter("txtIdPaquete"));
                int idEmpleado = Integer.parseInt(request.getParameter("txtIdEmpleado"));
                java.sql.Date fechaReserva = java.sql.Date.valueOf(request.getParameter("txtFechaReserva"));
                java.sql.Date fechaSalida = java.sql.Date.valueOf(request.getParameter("txtFechaSalida"));
                java.sql.Date fechaRetorno = java.sql.Date.valueOf(request.getParameter("txtFechaRetorno"));
                int cantidadPersonas = Integer.parseInt(request.getParameter("txtCantidadPersonas"));

                reserva.setIdCliente(idCliente);
                reserva.setIdPaquete(idPaquete);
                reserva.setIdEmpleado(idEmpleado);
                reserva.setFechaReserva(fechaReserva);
                reserva.setFechaSalida(fechaSalida);
                reserva.setFechaRetorno(fechaRetorno);
                reserva.setCantidadPersonas(cantidadPersonas);
                dao.add(reserva);
                acceso = listar;
            } else if (action.equalsIgnoreCase("editar")) {
                request.setAttribute("idreserva", request.getParameter("id"));
                acceso = edit;
            } else if (action.equalsIgnoreCase("Modificar")) {
                id = Integer.parseInt(request.getParameter("txtId"));
                int idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));
                int idPaquete = Integer.parseInt(request.getParameter("txtIdPaquete"));
                int idEmpleado = Integer.parseInt(request.getParameter("txtIdEmpleado"));
                java.sql.Date fechaReserva = java.sql.Date.valueOf(request.getParameter("txtFechaReserva"));
                java.sql.Date fechaSalida = java.sql.Date.valueOf(request.getParameter("txtFechaSalida"));
                java.sql.Date fechaRetorno = java.sql.Date.valueOf(request.getParameter("txtFechaRetorno"));
                int cantidadPersonas = Integer.parseInt(request.getParameter("txtCantidadPersonas"));

                reserva.setIdReserva(id);
                reserva.setIdCliente(idCliente);
                reserva.setIdPaquete(idPaquete);
                reserva.setIdEmpleado(idEmpleado);
                reserva.setFechaReserva(fechaReserva);
                reserva.setFechaSalida(fechaSalida);
                reserva.setFechaRetorno(fechaRetorno);
                reserva.setCantidadPersonas(cantidadPersonas);
                dao.edit(reserva);
                acceso = listar;
            } else if (action.equalsIgnoreCase("eliminar")) {
                id = Integer.parseInt(request.getParameter("id"));
                reserva.setIdReserva(id);
                dao.delete(id);
                acceso = listar;
            } else {
                acceso = listar;
            }
        } else {
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
