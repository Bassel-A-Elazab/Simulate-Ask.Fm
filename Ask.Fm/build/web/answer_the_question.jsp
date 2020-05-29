
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/main.css">
        <script src="script file/jquery-3.1.0.min.js"></script>
        <title>JSP Page</title>
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
        <!---------------------------->
        <div class="printquestion answertoquestion">
            <div class="container">
            <form action="AnswerToQuestion?question=<%=request.getParameter("question")%>&id_to=<%=request.getParameter("id_to")%>&id_from=<%=request.getParameter("id_from")%>&appear=<%=request.getParameter("appear")%>" method="POST" onsubmit="return checkAnswer()">
                <%
                    if (request.getParameter("email") == null) {%>
                <p><%=request.getParameter("question")%></p>
                <textarea spellcheck="false" placeholder="What is your answer?" name="answer" id = "answer"></textarea>
                <input type="submit" value="Answer" onsubmit="return checkAnswer()"/>
                <%} else {%>
                <p><%=request.getParameter("question")%></p><h6 style="color:red"><%=request.getParameter("email")%></h6>
                <textarea spellcheck="false" placeholder="What is your answer?" name="answer"></textarea>
                <input type="submit" value="Answer" onsubmit="return checkAnswer()"/>
                <%}
                %> 
            </form>
            </div>
        </div>
        <script>
            function checkAnswer() {
                if (document.getElementById("answer").value == null || document.getElementById("answer").value == "") {
                    alert("can't be empty");
                    return false;
                } else {
                    alert("done");
                    return true;
                }
            }
            $(document).ready(function () {
                $("p:contains( )").css("word-break", "normal");
            });
        </script>
    </body>
</html>
