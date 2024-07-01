<%@ page import="com.turismPage.ModeloDAO.ReservaDAO" %>
<%@ page import="com.turismPage.Modelo.Reserva" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Reserva</title>
</head>
<body>
<%
    ReservaDAO dao = new ReservaDAO();
    int id = Integer.parseInt((String)request.getAttribute("idreserva"));
    Reserva reserva = dao.list(id);
%>
<h1>Modificar Reserva</h1>
<form action="ControladorReserva">
    ID Cliente: <br>
    <input type="text" name="txtIdCliente" value="<%= reserva.getIdCliente() %>" required><br>
    ID Paquete: <br>
    <input type="text" name="txtIdPaquete" value="<%= reserva.getIdPaquete() %>" required><br>
    ID Empleado: <br>
    <input type="text" name="txtIdEmpleado" value="<%= reserva.getIdEmpleado() %>"><br>
    Fecha Reserva: <br>
    <input type="date" name="txtFechaReserva" value="<%= reserva.getFechaReserva() %>" required><br>
    Fecha Salida: <br>
    <input type="date" name="txtFechaSalida" value="<%= reserva.getFechaSalida() %>" required><br>
    Fecha Retorno: <br>
    <input type="date" name="txtFechaRetorno" value="<%= reserva.getFechaRetorno() %>" required><br>
    Cantidad Personas: <br>
    <input type="number" name="txtCantidadPersonas" value="<%= reserva.getCantidadPersonas() %>" required><br>
    <input type="hidden" name="txtId" value="<%= reserva.getIdReserva() %>">
    <input type="submit" name="accion" value="Modificar">
</form>
</body>
</html>
