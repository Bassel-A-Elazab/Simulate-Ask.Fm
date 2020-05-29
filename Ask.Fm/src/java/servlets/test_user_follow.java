package servlets;

import data.person;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class test_user_follow extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();
            PrintWriter out = response.getWriter();
            person p = (person) session.getAttribute("info");
            String email = p.getEmail();
            int id_from = 0;
            int id_to = 0;
            ResultSet rs, rs1, rsfinal;
            Statement stmt = (Statement) getServletContext().getAttribute("stmt");
            rs = stmt.executeQuery("select id from user where email='" + (email) + "'");
            if (rs.next()) {
                id_from = rs.getInt(1);
                out.println("email1" + id_from);
            }
            rs1 = stmt.executeQuery("select id from user where email = '" + request.getParameter("friend") + "'");
            if (rs1.next()) {
                id_to = rs1.getInt(1);
                out.println("email2" + id_to);
            }
            rsfinal = stmt.executeQuery("select id from relation where id_from='" + id_from + "' and id_to='" + id_to + "'");
            if (rsfinal.next()) {
                response.sendRedirect("friend_profile.jsp?status=" + "true"+"&friend="+request.getParameter("friend")+"&id_to="+id_to+"&id_from="+id_from);
            } else {
                response.sendRedirect("friend_profile.jsp?status=" + "false"+"&friend="+request.getParameter("friend")+"&id_to="+id_to+"&id_from="+id_from);
            }
        } catch (SQLException ex) {

        }

    }

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
