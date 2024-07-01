package com.turismPage.Controlador;
import javax.servlet.RequestDispatcher;
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
            Conexion cn = new Conexion();
            Connection con = cn.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, correo);
            pst.setString(2, dniString);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("La consulta SQL se ejecutó correctamente y devolvió al menos un resultado.");
                sesion.setAttribute("nombres", rs.getString("nombres"));
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                System.out.println("La consulta SQL se ejecutó correctamente pero no devolvió ningún resultado.");
                request.setAttribute("status", "failed");
                response.sendRedirect(request.getContextPath() + "/vistas/login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}