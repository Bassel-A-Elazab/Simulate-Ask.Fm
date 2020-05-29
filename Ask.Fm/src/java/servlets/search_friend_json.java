
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class search_friend_json extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
  Statement stmt = null;
            ResultSet rs = null;
            String name;
            stmt = (Statement) getServletContext().getAttribute("stmt");
            rs = stmt.executeQuery("select fname,lname,email from user");
            JSONObject mainObj = new JSONObject();
    JSONObject obj = new JSONObject();
    JSONArray arr = new JSONArray();
    if(rs.next()){
rs.previous();
if (request.getParameter("friend") == "" || request.getParameter("friend") == null) {}

else{
while(rs.next()){
if ((rs.getString(1) + " " + rs.getString(2)).contains(request.getParameter("friend"))){
          obj.put("name", rs.getString(1)+" "+rs.getString(2));
            obj.put("email", rs.getString(3));
            arr.add(obj);
            obj = new JSONObject();
}
}
}
   mainObj.put("employees", arr);
        out.println(mainObj);
        mainObj = new JSONObject();
        obj = new JSONObject();
        arr = new JSONArray();
}
        }catch(SQLException ex){
        
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
