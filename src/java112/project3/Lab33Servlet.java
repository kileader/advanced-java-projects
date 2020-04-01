package java112.project3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This is the second servlet for Project 3.
 * @author Kevin Leader
 */
@WebServlet(
        name = "Lab33Servlet",
        urlPatterns = { "/Lab33Servlet" }
)
public class Lab33Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map map = new HashMap();

        map.put("number", 1);
        map.put("text", "This is some sample text.");
        map.put("html", "<h2>This is an h2</h2>");
        map.put("aDate", new Date());

        request.setAttribute("myMap", map);

        String url = "/lab33.jsp";

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}