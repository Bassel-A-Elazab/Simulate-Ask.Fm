package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class answer_005fthe_005fquestion_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/main.css\">\n");
      out.write("        <script src=\"script file/jquery-3.1.0.min.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href =\"#\">Home Page</a></li>\n");
      out.write("                <li><a href =\"Question.jsp\">Question</a></li>\n");
      out.write("                <li><a href =\"#\">Friend</a></li>\n");
      out.write("                <li><a href =\"myprofile.jsp\">Profile</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div>\n");
      out.write("            <form action=\"AnswerToQuestion?question=");
      out.print(request.getParameter("question"));
      out.write("&id_to=");
      out.print(request.getParameter("id_to"));
      out.write("&id_from=");
      out.print(request.getParameter("id_from"));
      out.write("&appear=");
      out.print(request.getParameter("appear"));
      out.write("\" method=\"POST\" onsubmit=\"return checkAnswer()\">\n");
      out.write("                ");

                     if (request.getParameter("email") == null) {
      out.write("\n");
      out.write("                <p>");
      out.print(request.getParameter("question"));
      out.write("</p>\n");
      out.write("                <textarea cols=\"70\" rows =\"10\" placeholder=\"What is your answer?\" name=\"answer\" id = \"answer\"></textarea>\n");
      out.write("                <input type=\"submit\" value=\"Answer\" onclick=\"answerToQuestion()\"/>\n");
      out.write("                ");
} else {
      out.write("\n");
      out.write("                <p>");
      out.print(request.getParameter("question"));
      out.write("</p><h6 style=\"color:red\">");
      out.print(request.getParameter("email"));
      out.write("</h6>\n");
      out.write("                <textarea cols=\"50\" rows =\"20\" placeholder=\"What is your answer?\" name=\"answer\"></textarea>\n");
      out.write("                <input type=\"submit\" value=\"Answer\"/>\n");
      out.write("                ");
}
                
      out.write(" \n");
      out.write("\n");
      out.write("                <script>\n");
      out.write("                    function checkAnswer() {\n");
      out.write("                        if (document.getElementById(\"answer\").value == null || document.getElementById(\"answer\").value == \"\") {\n");
      out.write("                            alert(\"can't be empty\");\n");
      out.write("                            return false;\n");
      out.write("                        } else {\n");
      out.write("                            alert(\"done\");\n");
      out.write("                            return true;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                </script>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
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
