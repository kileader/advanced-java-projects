package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.utilities.*;

/**
 * This is the properties servlet for Project 2.
 * @author Kevin Leader
 */
@WebServlet(
    name = "project2PropertiesServlet",
    urlPatterns = { "/project2PropertiesServlet" }
)
public class Project2PropertiesServlet extends HttpServlet
        implements PropertiesLoader {

    private Properties properties;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter  out  = response.getWriter();

        out.print("<HTML>");
        out.print("<HEAD><TITLE>First Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>First Servlet</h1>");
        out.print("<h2>Kevin Leader - Advanced Java Programming 112</h2>");
        out.print("<img src=\"images/freeCodeCamp.png\"");
        out.print("<br />");
        out.print("<a href=\"/java112\">Homepage</a>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
