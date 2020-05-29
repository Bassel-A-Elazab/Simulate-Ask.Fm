package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerToQuestion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            ResultSet rs;
            Statement stmt = (Statement) getServletContext().getAttribute("stmt");
            stmt.executeUpdate("insert into answer values(null," + "'" + request.getParameter("question") + "','" + request.getParameter("answer") + "'," + Integer.parseInt(request.getParameter("id_from")) + "," + Integer.parseInt(request.getParameter("id_to")) + "," + Boolean.parseBoolean(request.getParameter("appear")) + ")");
            stmt.executeUpdate("delete from askwait where question = " + "'" + request.getParameter("question") + "'" + " and id_from = " + Integer.parseInt(request.getParameter("id_from")) + " and id_to = " + Integer.parseInt(request.getParameter("id_to")) + " and appear = " + Boolean.parseBoolean(request.getParameter("appear")) + " LIMIT " + 1);

            response.sendRedirect("Question.jsp");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
