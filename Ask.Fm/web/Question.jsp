<%@page import="data.person"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="script file/jquery-3.1.0.min.js"></script>
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="style/main.css">
        <script src="script file/jquery-3.1.0.min.js"></script>
    </head>
    <body class="questionhome">
         <div class="header">
            <div class="container">
                <div class="mid1">
                    <img src="image/ASK_fm_logo.png" width="270px" height="90px"/> 
              </div>
                <div class="mid2">
            <ul>
                <li><a href ="profile.jsp">Home Page</a></li>
                <li><a href ="Question.jsp">Question</a></li>
                <li><a href ="my_friend.jsp">Friend</a></li>
                <li><a href ="myprofile.jsp">Profile</a></li>
                <li><a href ="">Notification</a></li>
                <li><a href ="HomePage.html">Logout</a></li>
            </ul>
        </div>
            </div>
        </div>
        <!---------------------->
        <div class = "question">
            <div class="container">
            <%!
                ResultSet rs = null;
                ResultSet rs1 = null;
                Statement stmt = null;
                Statement stmt1 = null;
                int id_to;
                int id_from;
                String email;
                String question;
                boolean appear;
            %>
            <%
                try {
                    person p = (person) session.getAttribute("info");
                    stmt = (Statement) getServletContext().getAttribute("stmt");
                    stmt1 = (Statement) getServletContext().getAttribute("stmt1");
                    rs = stmt.executeQuery("select id from user where email = '" + p.getEmail() + "'");
                    if (rs.next()) {
                        id_to = rs.getInt("id");
                    }
                    rs = stmt.executeQuery("select question,id_from,appear from askwait where id_to = " + id_to);

                    if (rs.next()) {
                        rs.afterLast();
                        while (rs.previous()) {
                            question = rs.getString("question");
                            id_from = rs.getInt("id_from");
                            appear = rs.getBoolean("appear");
                            if (appear == true) {
                                rs1 = stmt1.executeQuery("select email from user where id=" + id_from);
                                if (rs1.next()) {
                                    email = rs1.getString("email");
                                }%>
            <div class="printquestion">
                <p><%=question%><a href ="#" style="color:red"><%=email%></a></p> <br>
                <a id = "answerLink" href="answer_the_question.jsp?question=<%=question%>&id_to=<%=id_to%>&id_from=<%=id_from%>&appear=<%=appear%>&email=<%=email%>">Answer</a>
            </div>
            <%} else if (appear == false) {%>
            <div class="printquestion">
                <p><%=question%></p><br>
                <a id = "answerLink" href="answer_the_question.jsp?question=<%=question%>&id_to=<%=id_to%>&id_from=<%=id_from%>&appear=<%=appear%>" >Answer</a>
            </div>
            <%}
                        }
                    }

                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }


            %>
            <script>
                $(document).ready(function () {
                    $("p:contains( )").css("word-break", "normal");
                });
            </script>
            </div>
        </div>
    </body>
</html>
