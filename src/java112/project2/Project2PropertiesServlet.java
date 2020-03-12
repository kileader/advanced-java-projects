package java112.project2;

import java.io.*;
import java.util.*;
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
    private Set<String> propertiesKeys;

    /**
     * This method runs when the servlet is first accessesed. It loads the
     * properties file to the properties variable and the properties keys to
     * the propertiesKeys variable.
     * @throws ServletException displays exception information to the browser
     */
    public void init() throws ServletException {
        log("init running now");
        try {
            properties = loadProperties("/project2.properties");
        } catch (Exception exception) {
            log("catching exception");
            exception.printStackTrace();
        }
        propertiesKeys = properties.stringPropertyNames();
    }

    /**
     * This method runs every time the servlet is accessed. It generates the
     * content that the user will see on their monitor.
     * @param  request          request from user
     * @param  response         response from server
     * @throws ServletException displays exception information to the browser
     * @throws IOException      exception for when PrintWriter doesn't work
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.print("<HTML>");
        out.print("<HEAD><TITLE>Project 2 Properties Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Project 2 Properties Servlet</h1>");
        out.print("<table>");

        for (String key : propertiesKeys) {
            out.print("<tr><td>" + key + "</td><td>"
                    + properties.getProperty(key) + "</td></tr>");
        }

        out.print("</table>");
        out.print("<br />");
        out.print("<a href=\"/java112\">Homepage</a>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
