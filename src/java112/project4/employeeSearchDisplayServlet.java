package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This servlet forwards to the employeeSearch.jsp
 * @author Kevin Leader
 */
@WebServlet(
        name = "employeeSearch",
        urlPatterns = { "/employee-search" }
)
public class employeeSearchDisplayServlet extends HttpServlet {

    /**
     * This method runs every time the servlet is accessed.
     * @param  request          request from user
     * @param  response         response from server
     * @throws ServletException displays exception information to the browser
     * @throws IOException      exception for when PrintWriter doesn't work
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Forward to the jsp
        String url = "/employeeSearch.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}