package servlets;

import data.person;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class create extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String mail = "@bassel.com";
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("cemail");
            String password = request.getParameter("pass1");
            person p = new person();
            p.setEmail(email + mail);
            p.setPassword(password);
            HttpSession session = request.getSession();
            session.setAttribute("info", p);
            Statement stmt = null;
            ResultSet rs = null;
            stmt = (Statement) getServletContext().getAttribute("stmt");
            String sql = " insert into user values (?, ?, ?, ?, ?)";
            stmt.executeUpdate("INSERT INTO user " + "VALUES (null," + "'" + fname + "'," + "'" + lname + "'," + "'" + (email + mail) + "'," + "'" + password + "')");
            response.sendRedirect("profile.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
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
