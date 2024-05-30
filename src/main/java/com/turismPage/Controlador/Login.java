package com.turismPage.Controlador;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.turismPage.Config.Conexion;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("txtUsu");
        String dniString = request.getParameter("txtPass");
        HttpSession sesion = request.getSession();
        String sql = "SELECT * FROM empleado where correo = ? and dni = ?";

        try {
            int dni = Integer.parseInt(dniString);

            Conexion cn = new Conexion();
            Connection con = cn.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, correo);
            pst.setInt(2, dni);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("La consulta SQL se ejecutó correctamente y devolvió al menos un resultado.");
                sesion.setAttribute("nombres", rs.getString("nombres"));
                String nombres = (String) sesion.getAttribute("nombres");
                response.sendRedirect(request.getContextPath() + "/index.jsp?usuario=" + nombres);
            } else {
                System.out.println("La consulta SQL se ejecutó correctamente pero no devolvió ningún resultado.");
                request.setAttribute("status", "failed");
                response.sendRedirect(request.getContextPath() + "/vistas/login.jsp");
            }
        } catch (Exception e) {
            // Consider logging this exception or handling it in a more specific way
            e.printStackTrace();
        }
    }
}
