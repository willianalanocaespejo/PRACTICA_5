
package com.emergentes.controlador;

import com.emergentes.dao.Login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Log", urlPatterns = {"/Log"})
public class Log extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("Index.jsp").forward(request, response);

        //obtener la sesión actual
        HttpSession session = request.getSession();
        //Limpiar
        session.invalidate();
        //ir a la página de inicio de sesión            
        response.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("password");

        Login lo = new Login();
        if (lo.autentication(usuario, contraseña)) {
            HttpSession se = request.getSession(true);
            se.setAttribute("usuario", usuario);

            response.sendRedirect("Inicio");
        } else {
            response.sendRedirect("Index.jsp");
        }

    }

}
