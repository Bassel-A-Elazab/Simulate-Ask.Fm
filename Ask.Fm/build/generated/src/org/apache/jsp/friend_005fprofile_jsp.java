package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import data.person;

public final class friend_005fprofile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"script file/jquery-3.1.0.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/main.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"mid1\">\n");
      out.write("                    <img src=\"image/ASK_fm_logo.png\" width=\"270px\" height=\"90px\"/> \n");
      out.write("                </div>\n");
      out.write("                <div class=\"mid2\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href =\"profile.jsp\">Home Page</a></li>\n");
      out.write("                        <li><a href =\"Question.jsp\">Question</a></li>\n");
      out.write("                        <li><a href =\"my_friend.jsp\">Friend</a></li>\n");
      out.write("                        <li><a href =\"myprofile.jsp\">Profile</a></li>\n");
      out.write("                        <li><a href =\"\">Notification</a></li>\n");
      out.write("                        <li><a href =\"HomePage.html\">Logout</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!---------------------->\n");
      out.write("        ");

            stmt = (Statement) getServletContext().getAttribute("stmt");
            rs = stmt.executeQuery("select fname,lname from user where email='" + request.getParameter("friend") + "'");
            if (rs.next()) {
                friendname = rs.getString("fname") + " " + rs.getString("lname");
            }
            status = Boolean.valueOf(request.getParameter("status"));
        
      out.write("\n");
      out.write("        <p>");
      out.print(friendname);
      out.write("</p>\n");
      out.write("        <h5>");
      out.print(request.getParameter("friend"));
      out.write("</h5>\n");
      out.write("        ");

            if (status) {
      out.write("\n");
      out.write("        <input type=\"submit\" value=\"UnFollow\" id=\"checkfollow\" onclick=\"checkfollow()\"/>\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("        <input type=\"submit\" value=\"Follow\" id=\"checkfollow\" onclick=\"checkfollow()\"/>\n");
      out.write("        ");
}
        
      out.write("\n");
      out.write("        <div class=\"askfriend\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <textarea spellcheck=\"false\" id = \"question\" name = \"question\"></textarea>\n");
      out.write("                <input type =\"checkbox\" id=\"appear\" name=\"appear\"/>Ask anonymously\n");
      out.write("                <input type = \"submit\" value =\"ASK\" onclick=\"checkQuestion()\"/>\n");
      out.write("                \n");
      out.write("                <p id = \"result\"></p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div>\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                ");

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
                                    }
      out.write("\n");
      out.write("                <div class=\"printquestion\">\n");
      out.write("                    <p>");
      out.print(rs.getString("question"));
      out.write("<a style=\"color:red\">");
      out.print(email);
      out.write("</a></p><br>\n");
      out.write("                    <p id=\"answer\">");
      out.print(rs.getString("answer"));
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("                ");
} else if (appear == false) {
      out.write("\n");
      out.write("                <div class=\"printquestion\">\n");
      out.write("                    <p>");
      out.print(rs.getString("question"));
      out.write("</p><br>\n");
      out.write("                    <p>");
      out.print(rs.getString("answer"));
      out.write("</p>\n");
      out.write("                    <hr>\n");
      out.write("                </div>\n");
      out.write("                ");
}
                            }
                        }

                    } catch (SQLException ex) {
                        System.out.println(ex.toString());
                    }

                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            function sendquestion() {\n");
      out.write("                var xhttp;\n");
      out.write("\n");
      out.write("                var id_from = \"");
out.print(request.getParameter("id_from"));
      out.write("\";\n");
      out.write("                var id_to = \"");
out.print(request.getParameter("id_to"));
      out.write("\";\n");
      out.write("                var question = document.getElementById(\"question\").value;\n");
      out.write("                var url = \"sendQuestion?question=\" + question + \"&id_from=\" + id_from + \"&id_to=\" + id_to + \"&appear=\" + !document.getElementById(\"appear\").checked;\n");
      out.write("                if (window.XMLHttpRequest) {\n");
      out.write("                    xhttp = new XMLHttpRequest();\n");
      out.write("                } else {\n");
      out.write("                    xhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        alert(this.responseText);\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"POST\", url, true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("            function checkQuestion() {\n");
      out.write("                var question = document.getElementById(\"question\").value;\n");
      out.write("                if (question == null || question == \"\") {\n");
      out.write("                    alert(\"can't be empty\");\n");
      out.write("                    return false;\n");
      out.write("                } else {\n");
      out.write("                    sendquestion();\n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"p:contains( )\").css(\"word-break\", \"normal\");\n");
      out.write("            });\n");
      out.write("            function checkfollow() {\n");
      out.write("                var val = document.getElementById(\"checkfollow\").value;\n");
      out.write("                if (val == \"Follow\") {\n");
      out.write("                    follow();\n");
      out.write("                } else if(val == \"UnFollow\"){\n");
      out.write("                    unfollow();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function follow() {\n");
      out.write("                var xhttp1;\n");
      out.write("                var id_from = \"");
out.print(request.getParameter("id_from"));
      out.write("\";\n");
      out.write("                var id_to = \"");
out.print(request.getParameter("id_to"));
      out.write("\";\n");
      out.write("                var url = \"makeFollow?id_from=\" + id_from + \"&id_to=\" + id_to;\n");
      out.write("                if (window.XMLHttpRequest) {\n");
      out.write("                    xhttp1 = new XMLHttpRequest();\n");
      out.write("                } else {\n");
      out.write("                    xhttp1 = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                xhttp1.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        alert(\"done follow\");\n");
      out.write("                        document.getElementById(\"checkfollow\").value = \"UnFollow\";\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                };\n");
      out.write("                xhttp1.open(\"POST\", url, true);\n");
      out.write("                xhttp1.send();\n");
      out.write("            }\n");
      out.write("            function unfollow() {\n");
      out.write("                var xhttp2;\n");
      out.write("\n");
      out.write("                var id_from = \"");
out.print(request.getParameter("id_from"));
      out.write("\";\n");
      out.write("                var id_to = \"");
out.print(request.getParameter("id_to"));
      out.write("\";\n");
      out.write("                var url = \"makeUnFollow?id_from=\" + id_from + \"&id_to=\" + id_to;\n");
      out.write("                if (window.XMLHttpRequest) {\n");
      out.write("                    xhttp2 = new XMLHttpRequest();\n");
      out.write("                } else {\n");
      out.write("                    xhttp2 = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                xhttp2.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        alert(\"done unfollow\");\n");
      out.write("                        document.getElementById(\"checkfollow\").value = \"Follow\";\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                };\n");
      out.write("                xhttp2.open(\"POST\", url, true);\n");
      out.write("                xhttp2.send();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
