<%@ page import="com.turismPage.ModeloDAO.PaqueteTuristicoDAO" %>
<%@ page import="com.turismPage.Modelo.PaqueteTuristico" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Reserva</title>
</head>
<body>
<h1>Agregar Nueva Reserva</h1>
<form action="ControladorReserva">
    ID Cliente: <br>
    <input type="text" name="txtIdCliente" required><br>

    ID Paquete: <br>
    <select name="txtIdPaquete" required>
        <%
            PaqueteTuristicoDAO paqueteDAO = new PaqueteTuristicoDAO();
            List<PaqueteTuristico> paquetes = paqueteDAO.listar();
            for (PaqueteTuristico paquete : paquetes) {
        %>
        <option value="<%= paquete.getIdPaquete() %>"><%= paquete.getNombre() %></option>
        <% } %>
    </select><br>

    ID Empleado: <br>
    <input type="text" name="txtIdEmpleado"><br>

    Fecha Reserva: <br>
    <input type="date" name="txtFechaReserva" required><br>

    Fecha Salida: <br>
    <input type="date" name="txtFechaSalida" required><br>

    Fecha Retorno: <br>
    <input type="date" name="txtFechaRetorno" required><br>

    Cantidad Personas: <br>
    <input type="number" name="txtCantidadPersonas" required><br>

    <input type="submit" name="accion" value="Agregar">
</form>
</body>
</html>
