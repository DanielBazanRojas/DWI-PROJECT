<%@ page import="com.turismPage.ModeloDAO.ClienteDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.turismPage.Modelo.Cliente" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listar Clientes</title>
</head>
<body>
    <div>
        <h1> Clientes </h1>
        <a href="Controlador?accion=add">Agregar Nuevo</a>
         <table border="1">
             <thead>
                <tr>
                    <th>ID</th>
                    <th>NOMBRES</th>
                    <th>DIRECCION</th>
                    <th>TELEFONO</th>
                    <th>CORREO</th>
                    <th>DNI</th>
                    <th>ACCIONES</th>
                </tr>
             </thead>
             <%
                 ClienteDAO dao = new ClienteDAO();
                 List<Cliente>list = dao.listar();
                 Iterator<Cliente>iter = list.iterator();
                 Cliente cliente = null;
                 while(iter.hasNext()){
                     cliente = iter.next();

             %>
             <tbody>
                <tr>
                    <td><%=cliente.getId()%></td>
                    <td><%=cliente.getNombre()%></td>
                    <td><%=cliente.getDireccion()%></td>
                    <td><%=cliente.getTelefono()%></td>
                    <td><%=cliente.getCorreo()%></td>
                    <td><%=cliente.getDni()%></td>
                    <td>
                        <a href="Controlador?accion=editar&id=<%=cliente.getId()%>">Edit</a>
                        <a href="Controlador?accion=eliminar&id=<%=cliente.getId()%>">Remove</a>
                    </td>
                </tr>
             <%}%>
             </tbody>
         </table>
    </div>
</body>
</html>
