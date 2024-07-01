<%@ page import="com.turismPage.ModeloDAO.ReservaDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.turismPage.Modelo.Reserva" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listar Reservas</title>
</head>
<body>
<div>
    <h1> Reservas </h1>
    <a href="ControladorReserva?accion=add">Agregar Nueva</a>
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>ID Cliente</th>
            <th>ID Paquete</th>
            <th>ID Empleado</th>
            <th>Fecha Reserva</th>
            <th>Fecha Salida</th>
            <th>Fecha Retorno</th>
            <th>Cantidad Personas</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <%
            ReservaDAO dao = new ReservaDAO();
            List<Reserva> list = dao.listar();
            Iterator<Reserva> iter = list.iterator();
            Reserva reserva = null;
            while (iter.hasNext()) {
                reserva = iter.next();
        %>
        <tbody>
        <tr>
            <td><%= reserva.getIdReserva() %></td>
            <td><%= reserva.getIdCliente() %></td>
            <td><%= reserva.getIdPaquete() %></td>
            <td><%= reserva.getIdEmpleado() %></td>
            <td><%= reserva.getFechaReserva() %></td>
            <td><%= reserva.getFechaSalida() %></td>
            <td><%= reserva.getFechaRetorno() %></td>
            <td><%= reserva.getCantidadPersonas() %></td>
            <td>
                <a href="ControladorReserva?accion=editar&id=<%= reserva.getIdReserva() %>">Editar</a>
                <a href="ControladorReserva?accion=eliminar&id=<%= reserva.getIdReserva() %>">Eliminar</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
