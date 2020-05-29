
<%@page import="java.sql.*"%>
<%@page import="data.person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    ResultSet rs = null;
    ResultSet rs1 = null;
    Statement stmt = null;
    Statement stmt1 = null;
    int id_to;
    int id_from;
    String email;
    String friendname;
    String question;
    boolean appear;
    boolean status;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="script file/jquery-3.1.0.min.js"></script>
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
        <!---------------------->
        <%
            stmt = (Statement) getServletContext().getAttribute("stmt");
            rs = stmt.executeQuery("select fname,lname from user where email='" + request.getParameter("friend") + "'");
            if (rs.next()) {
                friendname = rs.getString("fname") + " " + rs.getString("lname");
            }
            status = Boolean.valueOf(request.getParameter("status"));
        %>
        <p><%=friendname%></p>
        <h5><%=request.getParameter("friend")%></h5>
        <%
            if (status) {%>
        <input type="submit" value="UnFollow" id="checkfollow" onclick="checkfollow()"/>
        <%} else {%>
        <input type="submit" value="Follow" id="checkfollow" onclick="checkfollow()"/>
        <%}
        %>
        <div class="askfriend">
            <div class="container">
                <textarea spellcheck="false" id = "question" name = "question"></textarea>
                <input type ="checkbox" id="appear" name="appear"/>Ask anonymously
                <input type = "submit" value ="ASK" onclick="checkQuestion()"/>
                
                <p id = "result"></p>
            </div>
        </div>
        <div>
            <div class="container">

                <%
                    try {

                        stmt1 = (Statement) getServletContext().getAttribute("stmt1");
                        rs = stmt.executeQuery("select id from user where email = '" + request.getParameter("friend") + "'");
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
                    <p><%=rs.getString("question")%><a style="color:red"><%=email%></a></p><br>
                    <p id="answer"><%=rs.getString("answer")%></p>
                </div>
                <%} else if (appear == false) {%>
                <div class="printquestion">
                    <p><%=rs.getString("question")%></p><br>
                    <p><%=rs.getString("answer")%></p>
                    <hr>
                </div>
                <%}
                            }
                        }

                    } catch (SQLException ex) {
                        System.out.println(ex.toString());
                    }

                %>
            </div>
        </div>
        <script>
            function sendquestion() {
                var xhttp;

                var id_from = "<%out.print(request.getParameter("id_from"));%>";
                var id_to = "<%out.print(request.getParameter("id_to"));%>";
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
            function checkfollow() {
                var val = document.getElementById("checkfollow").value;
                if (val == "Follow") {
                    follow();
                } else if(val == "UnFollow"){
                    unfollow();
                }
            }
            function follow() {
                var xhttp1;
                var id_from = "<%out.print(request.getParameter("id_from"));%>";
                var id_to = "<%out.print(request.getParameter("id_to"));%>";
                var url = "makeFollow?id_from=" + id_from + "&id_to=" + id_to;
                if (window.XMLHttpRequest) {
                    xhttp1 = new XMLHttpRequest();
                } else {
                    xhttp1 = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xhttp1.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        alert("done follow");
                        document.getElementById("checkfollow").value = "UnFollow";
                    }

                };
                xhttp1.open("POST", url, true);
                xhttp1.send();
            }
            function unfollow() {
                var xhttp2;

                var id_from = "<%out.print(request.getParameter("id_from"));%>";
                var id_to = "<%out.print(request.getParameter("id_to"));%>";
                var url = "makeUnFollow?id_from=" + id_from + "&id_to=" + id_to;
                if (window.XMLHttpRequest) {
                    xhttp2 = new XMLHttpRequest();
                } else {
                    xhttp2 = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xhttp2.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        alert("done unfollow");
                        document.getElementById("checkfollow").value = "Follow";

                    }

                };
                xhttp2.open("POST", url, true);
                xhttp2.send();
            }
        </script>
    </body>
</html>
