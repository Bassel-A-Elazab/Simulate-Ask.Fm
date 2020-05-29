<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:declaration>
            Statement stmt = null;
            ResultSet rs = null;
            
        </jsp:declaration>
        <%
            String name = "@bassel.com";
         String email = request.getParameter("cemail");
          stmt = (Statement)getServletContext().getAttribute("stmt");
          rs = stmt.executeQuery("select * from user where email='" + (email+name) + "'");
        %>
        <%
        if(rs.next()){%>
        <b>already taken</b>
        <input type = "hidden" id = "actual" value = "exsist"/>
        <%}
        else{%>
        <b>non taken</b>
        <input type = "hidden" id = "actual" value = "nonexist"/>
        <%}
        %>
        <%
        rs.close();
        %>
    </body>
</html>
