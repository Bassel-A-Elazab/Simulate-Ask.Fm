<%@page import="data.person"%>
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
            int id;
        </jsp:declaration>
        <%
            person p = (person) session.getAttribute("info");
            String email = p.getEmail();
            stmt = (Statement) getServletContext().getAttribute("stmt");
            rs = stmt.executeQuery("select id from user where email='" + (email) + "'");
        %>
        <%if (rs.next()) {
                id = rs.getInt(1);
        %>
        <%}%>
        <%
            stmt.executeUpdate("insert into posts values(" + "'" + request.getParameter("setpost") + "'," + id + ")");
        %>
        <h1>Posted</h1>
    </body>
</html>
