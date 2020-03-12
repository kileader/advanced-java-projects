package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This is the first servlet for Project 2.
 * @author Kevin Leader
 */
@WebServlet(
    name = "first112Servlet",
    urlPatterns = { "/first112Servlet" }
)
public class First112Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter  out  = response.getWriter();

        out.print("<HTML>");
        out.print("<HEAD><TITLE>First Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>First Servlet</h1>");
        out.print("<h2>Kevin Leader - Advanced Java Programming 112</h2>");
        out.print("<img src=\"images/freeCodeCamp.png\">");
        out.print("<br />");
        out.print("<a href=\"/java112\">Homepage</a>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
