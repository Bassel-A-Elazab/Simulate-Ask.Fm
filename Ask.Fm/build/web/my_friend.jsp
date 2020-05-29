<%@page import="data.person"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <script src ="script file/main.js"></script>
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
       <!-------------------------->
        <div class="container">
        <input type = "text" name = "name" id = "name" onkeyup = "load()" placeholder="search for people"/>
        <p id = "notFound"></p>
        <div id="placeholder"></div>
        </div>
        <script>
            
function load() {
    var xhttp;
    var friend = document.getElementById("name").value;
    var url = "search_friend_json?friend=" + friend;
    if (window.XMLHttpRequest) {
        xhttp = new XMLHttpRequest();
    } else {
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var arr = JSON.parse(this.responseText);
            dis(arr);
        }
    };
    xhttp.open("POST", url, true);
    xhttp.send();
}
function dis(arr) {
    var li;
    var a1;
    var a2;
    var br;
    var div = document.getElementById('placeholder');
    var ul = document.createElement('ul');
    if (arr.employees.length == 0) {
        document.getElementById("notFound").innerHTML = "Not found";
    } else {
        document.getElementById("notFound").innerHTML = "";
        for (var i = 0; i < arr.employees.length; i++) {
            li = document.createElement('li');
            a1 = document.createElement('a');
            a2 = document.createElement('a');
            br = document.createElement('br');
            a1.href = "#";
            a2.href = "#";
            content1 = document.createTextNode(arr.employees[i].name);
            content2 = document.createTextNode(arr.employees[i].email);
            a1.appendChild(content1);
            a2.appendChild(content2);
            
            li.appendChild(a1);
            li.appendChild(br);
            li.appendChild(a2);
            li.setAttribute("class","linkFriend");
            ul.appendChild(li);
        }
        
        div.appendChild(ul);
    }

    $(".linkFriend").click(function () {
        var index = $(".linkFriend").index(this);
        window.location.href = "friendList?friend=" + arr.employees[index].email;

    });
}
            $(document).ready(function () {
    $('#name').on("keyup", function () {
        $('#placeholder').empty();
    });
});
            </script>
   <style>


            #name,#placeholder{
               margin-top:20px;
         padding: 10px 500px 10px 0px;
         background-color:#FCE9BE;
         border: solid 1px #c3c3c3;
               color: black;
             
            }
            #placeholder{
               width: 230px;
                display: none;
            }
#placeholder ul li{
   list-style: none;
   margin-top: 15px;
  
}
#placeholder ul li a{
   text-decoration: none;
   color:brown;
}

        
        </style>
        <script>
        $(document).ready(function(){
         $('#name').on("keyup", function () {
            $('#placeholder').slideToggle();
        });
        });
            </script>
            <%!
            int id_to;
            int id_from;
            ResultSet rs1;
           %>
           <div class="myfriend">
               <div class="container">
<%
 
Statement stmt = (Statement) getServletContext().getAttribute("stmt");
Statement stmt1 = (Statement) getServletContext().getAttribute("stmt1");
person p = (person)session.getAttribute("info");
  ResultSet rs = stmt.executeQuery("select id from user where email='"+p.getEmail()+"'");
  if(rs.next()){
      id_from=rs.getInt("id");
  }
  rs = stmt.executeQuery("select id_to from relation where id_from="+id_from);
  if(rs.next()){
  rs.afterLast();
  while(rs.previous()){
  rs1 = stmt1.executeQuery("select fname,lname,email from user where id = "+rs.getInt("id_to"));
  if(rs1.next()){%>
  <a href="">
  <div class="content">
      <p><%=rs1.getString("fname")+" "+rs1.getString("lname")%></p>
    <h6><%=rs1.getString("email")%></h6>
    
    </div>
    </a>
  <%}
  }
  }
%>  
               </div>
</div>
    </body>
</html>
