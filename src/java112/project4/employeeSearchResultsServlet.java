package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This servlet generates the results of an employee search.
 * @author Kevin Leader
 */
@WebServlet(
        name = "employeeSearchResults",
        urlPatterns = { "/employee-search-results" }
)
public class employeeSearchDisplayServlet extends HttpServlet {

    /**
     *
     * @param request request from user
     * @param response response from user
     * @throws ServletException displays exception information to the browser
     * @throws IOException exception for when forward doesn't work
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        // Forward to the results jsp
        String url = "/employeeSearchResults.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}