package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This is a servlet for a lab demonstrating JSTL
 * @author Kevin Leader
 */
@WebServlet(
        name = "JSTLLab1Servlet",
        urlPatterns = { "/JSTL-Lab" }
)
public class JSTLLab1Servlet extends HttpServlet {

    /**
     * This method runs every time the servlet is accessed.
     * @param  request          request from user
     * @param  response         response from server
     * @throws ServletException displays exception information to the browser
     * @throws IOException      exception for when PrintWriter doesn't work
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List dogs = new ArrayList();
        dogs.add("Max");
        dogs.add("Winston");
        dogs.add("Dixie");
        dogs.add("Tigger");
        dogs.add("Rusty");

        session.setAttribute("dogsList", dogs);

        String url = "/jstl-lab2.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}