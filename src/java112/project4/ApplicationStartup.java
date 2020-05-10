package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.utilities.*;

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

    public void init() throws ServletException {
        try {
            properties = loadProperties("/project4.properties");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}