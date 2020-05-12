package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.employee.*;

/**
 * This servlet adds a new employee into the database by a POST action.
 * @author Kevin Leader
 */
@WebServlet(
        name = "employeeAddAction",
        urlPatterns = { "/employee-add-action" }
)
public class EmployeeAddActionServlet extends HttpServlet {

    /**
     * This method initializes ServletContext and EmployeeDirectory objects
     * @throws ServletException
     */
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        EmployeeDirectory empDir =
                (EmployeeDirectory) context.getAttribute("employeeDirectory");
    }

    /**
     * This method runs every time the servlet is accessed.
     * @param  request          request from user
     * @param  response         response from server
     * @throws ServletException displays exception information to the browser
     * @throws IOException      exception for when PrintWriter doesn't work
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Grab session data from form
        HttpSession session = request.getSession();

        // Get all the employee data from form
        String[] fields = new String[6];

        fields[0] = request.getParameter("firstName");
        fields[1] = request.getParameter("lastName");
        fields[2] = request.getParameter("socialSecurity");
        fields[3] = request.getParameter("department");
        fields[4] = request.getParameter("room");
        fields[5] = request.getParameter("phone");

        // Call the addEmployee method in EmployeeDirectory and pass all the
        // employee fields.
    }

}