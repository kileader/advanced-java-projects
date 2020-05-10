package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.utilities.*;
import java112.employee.*;

/**
 * This is a servlet that performs some initialization for the application.
 * @author Kevin Leader
 */
@WebServlet(
    name = "applicationStartup",
    urlPatterns = { "/project4-startup" },
    loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet
        implements PropertiesLoader {

    private Properties properties;

    /**
     * This method sets the project 4 properties and an EmployeeDirectory object
     * as ServletContext attributes.
     * @throws ServletException
     */
    public void init() throws ServletException {

        try {
            properties = loadProperties("/project4.properties");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        ServletContext context = getServletContext();
        context.setAttribute("project4Properties", properties);

        EmployeeDirectory empDir = new EmployeeDirectory(properties);
        context.setAttribute("employeeDirectory", empDir);

    }

}