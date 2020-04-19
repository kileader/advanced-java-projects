package java112.project3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.utilities.*;

/**
 * This is the properties servlet for Project 3.
 * @author Kevin Leader
 */
@WebServlet(
        name = "project3PropertiesServlet",
        urlPatterns = { "/project3-properties" }
)
public class PropertiesServlet extends HttpServlet
        implements PropertiesLoader {

    private Properties properties;

    /**
     * This method runs when the servlet is first accessesed. It loads the
     * properties file to the properties variable.
     * @throws ServletException displays exception information to the browser
     */
    public void init() throws ServletException {
        log("init running now");
        try {
            properties = loadProperties("/project3.properties");
        } catch (Exception exception) {
            log("catching exception");
            exception.printStackTrace();
        }
    }

    /**
     * This method runs every time the servlet is accessed.
     * @param  request          request from user
     * @param  response         response from server
     * @throws ServletException displays exception information to the browser
     * @throws IOException      exception for when PrintWriter doesn't work
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("project3Properties", properties);

        String url = "/project3Properties.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
