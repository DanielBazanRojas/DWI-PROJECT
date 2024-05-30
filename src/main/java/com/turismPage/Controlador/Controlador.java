package com.turismPage.Controlador;

import com.turismPage.Modelo.Cliente;
import com.turismPage.ModeloDAO.ClienteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {

    String listar = "vistas/listar.jsp";
    String add = "vistas/add.jsp";
    String edit = "vistas/edit.jsp";
    int id;
    Cliente cli = new Cliente();
    ClienteDAO dao = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action != null) {
            if (action.equalsIgnoreCase("listar")) {
                try {
                    List<Cliente> listaClientes = dao.listar();
                    request.setAttribute("clientes", listaClientes);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                acceso = listar;
            } else if (action.equalsIgnoreCase("add")) {
                acceso = add;
            } else if (action.equalsIgnoreCase("Agregar")) {
                String nombre=request.getParameter("txtNombres");
                String direccion=request.getParameter("txtDireccion");
                String telefono=request.getParameter("txtTelefono");
                String correo=request.getParameter("txtCorreo");
                String dni=request.getParameter("txtDni");
                cli.setNombre(nombre);
                cli.setDireccion(direccion);
                cli.setTelefono(Integer.parseInt(telefono));
                cli.setCorreo(correo);
                cli.setDni(dni);
                dao.add(cli);
                acceso=listar;
            } else if (action.equalsIgnoreCase("editar")) {
                request.setAttribute("idcliente", request.getParameter("id"));
                acceso = edit;
            } else if (action.equalsIgnoreCase("Modificar")) {
                id= Integer.parseInt(request.getParameter("txtId"));
                String nombre=request.getParameter("txtNombres");
                String direccion=request.getParameter("txtDireccion");
                String telefono=request.getParameter("txtTelefono");
                String correo=request.getParameter("txtCorreo");
                String dni=request.getParameter("txtDni");
                cli.setId(id);
                cli.setNombre(nombre);
                cli.setDireccion(direccion);
                cli.setTelefono(Integer.parseInt(telefono));
                cli.setCorreo(correo);
                cli.setDni(dni);
                dao.edit(cli);
                acceso=listar;
            } else if (action.equalsIgnoreCase("eliminar")) {
                id=Integer.parseInt(request.getParameter("id"));
                cli.setId(id);
                dao.delete(id);
                acceso=listar;
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
