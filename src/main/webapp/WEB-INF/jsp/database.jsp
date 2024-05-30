<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="com.turismPage.Config.Conexion" %>
<!DOCTYPE html>
<html>
<head>
    <title>Database Version</title>
</head>
<body>
<h1>Database Version</h1>
<%
    try (Connection conn = Conexion.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT version()")) {

        if (rs.next()) {
            out.println("<p>" + rs.getString(1) + "</p>");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("<p>Error connecting to the database</p>");
    }
%>
</body>
</html>
