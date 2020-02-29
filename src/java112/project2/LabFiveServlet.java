package java112.project2;

import java.io.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
    name = "labFiveServlet",
    urlPatterns = { "/labFiveServlet" }
)
public class LabFiveServlet extends HttpServlet {
    private int hitCounter;
    private String initialDateAndTime;
    private String currentDateAndTime;

    @Override
    public void init() throws ServletException {
        log("Executing init method.");
        initialDateAndTime = returnDateAndTime();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter  out  = response.getWriter();

        response.setContentType("text/html");

        log("Executing doGet method.");
        hitCounter++;

        currentDateAndTime = returnDateAndTime();

        out.print("<html>");
        out.print("<head><title>Lab Five Servlet</title></head>");
        out.print("<body>");
        out.print("<table><tr>");
        out.print("<td>Number of times accessed</td>");
        out.print("") + hitCounter + "<>");
        out.print("")

    }

    public String returnDateAndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(
            "EEE MMM dd HH:mm:ss z yyyy");
        Date date = new Date();
        String formattedDate = sdf.format(date);
        return formattedDate;
    }
}
