<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String nombres = (String) session.getAttribute("nombres");
    if (nombres == null) {
        response.sendRedirect("vistas/login.jsp");
    }
%>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <h1>Agregar Cliente</h1>
        <form action="Controlador">
            Nombres: <br>
            <input type="text" name="txtNombres"><br>
            Direccion: <br>
            <input type="text" name="txtDireccion"><br>
            Telefono: <br>
            <input type="text" name="txtTelefono"><br>
            Correo: <br>
            <input type="text" name="txtCorreo"><br>
            Dni: <br>
            <input type="text" name="txtDni"><br>
            <input type="submit" name="accion" value="Agregar">
        </form>
    </body>
</html>
