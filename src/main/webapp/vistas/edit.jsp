<%@ page import="com.turismPage.ModeloDAO.ClienteDAO" %>
<%@ page import="com.turismPage.Modelo.Cliente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(session.getAttribute("nombres")==null){
        response.sendRedirect("vistas/login.jsp");
    }
%>
<html>
<head>
    <title>Modificar</title>
</head>
    <div>
        <%
            ClienteDAO dao = new ClienteDAO();
            int id=Integer.parseInt((String)request.getAttribute("idcliente"));
            Cliente cli = (Cliente)dao.list(id);
        %>
        <body>
            <h1>Modificar Cliente</h1>
            <form action="Controlador">
                Nombres: <br>
                <input type="text" name="txtNombres" value="<%=cli.getNombre()%>"><br>
                Direccion: <br>
                <input type="text" name="txtDireccion" value="<%=cli.getDireccion()%>"><br>
                Telefono: <br>
                <input type="text" name="txtTelefono" value="<%=cli.getTelefono()%>"><br>
                Correo: <br>
                <input type="text" name="txtCorreo" value="<%=cli.getCorreo()%>"><br>
                Dni: <br>
                <input type="text" name="txtDni" value="<%=cli.getDni()%>"><br>
                <input type="hidden" name="txtId" value="<%=cli.getId()%>">
                <input type="submit" name="accion" value="Modificar">
            </form>
        </body>
    </div>
</html>
