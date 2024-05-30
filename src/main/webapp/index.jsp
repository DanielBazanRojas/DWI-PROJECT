
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(session.getAttribute("nombres")==null){
        response.sendRedirect("vistas/login.jsp");
    }
%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>JOYMEYROS TOURS</title>
</head>
    <body>
    <div>
        <a href="Controlador?accion=listar">Listar Cliente</a>
    </div>
    </body>
</html>
