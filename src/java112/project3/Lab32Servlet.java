package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This is the first servlet for Project 3.
 * @author Kevin Leader
 */
@WebServlet(
    name = "Lab32Servlet",
    urlPatterns = { "/Lab32Servlet" }
)
public class First112Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter  out  = response.getWriter();
