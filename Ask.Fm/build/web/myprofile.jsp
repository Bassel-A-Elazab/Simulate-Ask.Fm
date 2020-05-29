<%@page import="data.person"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    String email;
    ResultSet rs = null;
    ResultSet rs1 = null;
    Statement stmt = null;
    Statement stmt1 = null;
    int id_to;
    int id_from;
String username;
    String question;
    boolean appear;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="script file/jquery-3.1.0.min.js"></script>
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="style/main.css">
    </head>
    <body>
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
        <!----------------------->
        <%
             
            person p = (person) session.getAttribute("info");
            email = p.getEmail();
            stmt = (Statement) getServletContext().getAttribute("stmt");
            rs = stmt.executeQuery("select fname,lname from user where email = '"+email+"'");
            if(rs.next()){
               username = rs.getString("fname")+" "+rs.getString("lname");
            }
           
        %>
        <p><%=username%></p>
        <h5><%=email%></h5>
        
        <!----------------->
        <div class="askfriend">
            <textarea spellcheck="false" id = "question" name = "question"></textarea>
            <input type ="checkbox" id="appear" name="appear"/>Ask anonymously
            <input type = "submit" value ="ASK" onclick="checkQuestion()"/>
            <p id = "result"></p>
        </div>

        <div class = "question">
            <%
                try {

                    stmt1 = (Statement) getServletContext().getAttribute("stmt1");
                    rs = stmt.executeQuery("select id from user where email = '" + p.getEmail() + "'");
                    if (rs.next()) {
                        id_to = rs.getInt("id");
                    }
                    rs = stmt.executeQuery("select * from answer where id_to = " + id_to);

                    if (rs.next()) {
                        rs.afterLast();
                        while (rs.previous()) {
                            if (rs.getBoolean("appear") == true) {
                                rs1 = stmt1.executeQuery("select email from user where id=" + rs.getInt("id_from"));
                                if (rs1.next()) {
                                    email = rs1.getString("email");
                                }%>
            <div class="printquestion">
                <p><%=rs.getString("question")%><a href ="#" style="color:red"><%=email%></a></p><br>
                <p id="answer"><%=rs.getString("answer")%></p>
            </div>
            <%} else if (appear == false) {%>
            <div class="printquestion">
                <p><%=rs.getString("question")%></p><br>
                <p id="answer"><%=rs.getString("answer")%></p>
            </div>
            <%}
                        }
                    }

                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }


            %>
        </div>
        <script>
            function sendquestion() {
                var xhttp;

                var id_from = "<%=id_to%>";
                var id_to = "<%=id_to%>";
                var question = document.getElementById("question").value;
                var url = "sendQuestion?question=" + question + "&id_from=" + id_from + "&id_to=" + id_to + "&appear=" + !document.getElementById("appear").checked;
                if (window.XMLHttpRequest) {
                    xhttp = new XMLHttpRequest();
                } else {
                    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        alert(this.responseText);
                    }

                };
                xhttp.open("POST", url, true);
                xhttp.send();
            }
            function checkQuestion() {
                var question = document.getElementById("question").value;
                if (question == null || question == "") {
                    alert("can't be empty");
                    return false;
                } else {
                    sendquestion();
                    return true;
                }
            }
            $(document).ready(function () {
                $("p:contains( )").css("word-break", "normal");
            });
        </script>
    </body>
</html>
