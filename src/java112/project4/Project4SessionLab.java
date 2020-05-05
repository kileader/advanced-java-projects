package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This is a servlet demonstrating sessions
 * @author Kevin Leader
 */
@WebServlet(
        name = "sessionLab",
        urlPatterns = { "/session-lab" }
)
public class Project4SessionLab extends HttpServlet {

    /**
     * This method runs every time the servlet is accessed.
     * @param  request          request from user
     * @param  response         response from server
     * @throws ServletException displays exception information to the browser
     * @throws IOException      exception for when PrintWriter doesn't work
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the session object for the request
        HttpSession session = request.getSession();

        // Define sessionCounter and get the counter from the session
        Integer sessionCounter =
                (Integer) session.getAttribute("project4SessionCounter");

        // If the variable is null, create an instance of the attribute with 1
        if (sessionCounter == null) {
            sessionCounter = 1;
            session.setAttribute("project4SessionCounter", sessionCounter);
        } else { // Otherwise, increment the counter and set it
            sessionCounter++;
            session.setAttribute("project4SessionCounter", sessionCounter);
        }

        // Forward to the jsp
        String url = "/project4Session.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}