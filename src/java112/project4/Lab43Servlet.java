package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This is a servlet for a lab demonstrating HTML forms
 * @author Kevin Leader
 */
@WebServlet(
        name = "Lab43Servlet",
        urlPatterns = { "/lab43" }
)
public class Lab43Servlet extends HttpServlet {

    /**
     * This method runs every time the servlet is accessed.
     * @param  request          request from user
     * @param  response         response from server
     * @throws ServletException displays exception information to the browser
     * @throws IOException      exception for when PrintWriter doesn't work
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        System.out.println("name: " + name);

        String gender = request.getParameter("gender");

        System.out.println("gender: " + gender);

        String url = "/lab43.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}