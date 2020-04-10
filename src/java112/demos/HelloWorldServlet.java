// define the appropriate package

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet (
    name = "HelloWorldServlet",
    urlPatterns = { "/HelloWorldServlet" }
)
public class HelloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/plain");

        PrintWriter  out  = response.getWriter();
        out.println("<html><body>Hello World!</body></html>");

    }
}
