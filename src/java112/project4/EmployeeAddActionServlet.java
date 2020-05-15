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
     * This method runs every time the servlet is accessed.
     * @param  request          request from user
     * @param  response         response from server
     * @throws ServletException displays exception information to the browser
     * @throws IOException      exception for when PrintWriter doesn't work
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Define context and employeeDirectory
        ServletContext context = getServletContext();
        EmployeeDirectory empDir =
                (EmployeeDirectory) context.getAttribute("employeeDirectory");

        // Grab session data
        HttpSession session = request.getSession();

        // Get all the employee data from form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String socialSecurity = request.getParameter("socialSecurity");
        String department = request.getParameter("department");
        String room = request.getParameter("room");
        String phone = request.getParameter("phone");

        // Call addEmployee method in EmployeeDirectory and pass arguments.
        // Save the returned message.
        String message = empDir.addEmployee(firstName, lastName, socialSecurity,
                department, room, phone);

        // Place the message into the session
        session.setAttribute("employeeMessage", message);

        // Redirect to the same jsp
        String url = "/java112/employeeAdd.jsp";
        response.sendRedirect(url);

    }

}