package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import data.person;
import java.sql.*;

public final class myprofile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


                ResultSet rs = null;
                ResultSet rs1 = null;
                Statement stmt = null;
                Statement stmt1 = null;
                int id_to;
                int id_from;
                String email;
                String question;
                boolean appear;
            
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"script file/jquery-3.1.0.min.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"style/main.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            <ul>\n");
      out.write("              <li><a href =\"HomePage.html\">Home Page</a></li>\n");
      out.write("                <li><a href =\"Question.jsp\">Question</a></li>\n");
      out.write("                <li><a href =\"my_friend.jsp\">Friend</a></li>\n");
      out.write("                <li><a href =\"myprofile.jsp\">Profile</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div class = \"question\">\n");
      out.write("            ");
      out.write("\n");
      out.write("            ");

                try {
                    person p = (person) session.getAttribute("info");
                    stmt = (Statement) getServletContext().getAttribute("stmt");
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
                                }
      out.write("\n");
      out.write("            <div class=\"printquestion\">\n");
      out.write("                <p>");
      out.print(rs.getString("question"));
      out.write("<a href =\"#\" style=\"color:red\">");
      out.print(email);
      out.write("</a></p><br>\n");
      out.write("                <p id=\"answer\">");
      out.print(rs.getString("answer"));
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("            ");
} else if (appear == false) {
      out.write("\n");
      out.write("            <div class=\"printquestion\">\n");
      out.write("                <p>");
      out.print(rs.getString("question"));
      out.write("</p><br>\n");
      out.write("                <p id=\"answer\">");
      out.print(rs.getString("answer"));
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("            ");
}
                        }
                    }

                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }


            
      out.write("\n");
      out.write("        </div>\n");
      out.write("                    <script>\n");
      out.write("                $(document).ready(function(){\n");
      out.write("    $(\"p:contains( )\").css(\"word-break\", \"normal\");\n");
      out.write("});\n");
      out.write("                </script>\n");
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
