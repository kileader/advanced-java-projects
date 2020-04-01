package java112.project3;

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
public class Lab32Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Unit 3 Lab 2</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Unit 3 Lab 2</h1>");
        out.print("<h2>Locale</h2>");
        out.print("<p>" + request.getLocale() + "</p>");
        out.print("<h2>Context Path</h2>");
        out.print("<p>" + request.getServletContext() + "</p>");
        out.print("<h2>Server Name</h2>");
        out.print("<p>" + request.getServerName() + "</p>");
        out.print("<h2>Scheme</h2>");
        out.print("<p>" + request.getScheme() + "</p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}