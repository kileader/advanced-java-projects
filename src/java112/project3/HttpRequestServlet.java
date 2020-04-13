package java112.project3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.utilities.*;

/**
 * This is a servlet that gets data about the HTML request and uses a JavaBean
 * and JSP in an MVC pattern.
 * @author Kevin Leader
 */
@WebServlet(
        name = "requestServlet",
        urlPatterns = { "/request-servlet" }
)
public class HttpRequestServlet extends HttpServlet {

    /**
     * This method runs every time the servlet is accessed.
     * @param  request          request from user
     * @param  response         response from server
     * @throws ServletException displays exception information to the browser
     * @throws IOException      exception for when PrintWriter doesn't work
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpRequestData requestData = new HttpRequestData();

        requestData.setRemoteName(request.getRemoteHost());
        requestData.setRemoteAddress(request.getRemoteAddr());
        requestData.setHttpMethod(request.getMethod());
        requestData.setRequestURI(request.getRequestURI());
        requestData.setRequestURL(request.getRequestURL());
        requestData.setRequestProtocol(request.getProtocol());
        requestData.setServerName(request.getServerName());
        requestData.setServerPort(request.getServerPort());
        requestData.setLocale(request.getLocale());
        requestData.setQueryString(request.getQueryString());
        requestData.setQueryParameter(request.getParameter("queryParameter"));
        requestData.setRequestUserHeader(request.getHeader("User-Agent"));

        request.setAttribute("requestData", requestData);

        String url = "/HttpRequestData.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
