package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.employee.*;

/**
 * This servlet generates the results of an employee search.
 * @author Kevin Leader
 */
@WebServlet(
        name = "employeeSearchResults",
        urlPatterns = { "/employee-search-results" }
)
public class EmployeeSearchResultsServlet extends HttpServlet {

    /**
     * This method runs every time the servlet is accessed.
     * @param  request          request from user
     * @param  response         response from server
     * @throws ServletException displays exception information to the browser
     * @throws IOException      exception for when PrintWriter doesn't work
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Define ServletContext and EmployeeDirectory objects
        ServletContext context = getServletContext();
        EmployeeDirectory empDir =
                (EmployeeDirectory) context.getAttribute("employeeDirectory");

        // Grab session data from form
        HttpSession session = request.getSession();

        // Get search type and search term from form
        String searchTerm = request.getParameter("searchTerm");
        String searchType = request.getParameter("searchType");

        // Call search method in EmployeeDirectory and pass type and term.
        // It should return a filled out search object
        Search search = empDir.searchEmployees(searchType, searchTerm);

        // Place the search object into the session
        session.setAttribute("search", search);

        // Forward to the results jsp
        String url = "/employeeSearchResults.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}