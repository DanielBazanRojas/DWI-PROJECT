
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String nombres = (String) session.getAttribute("nombres");
    String link = null;
    if (nombres == null) {
        response.sendRedirect("/vistas/login.jsp");
    } else {
        link = "Controlador?accion=listar&usuario=" + nombres;
    }
%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>JOYMEYROS TOURS</title>
</head>
<body>
<div>
    <a href="<%=link%>">Listar Cliente</a>
</div>
</body>
</html>