package java112.project4;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This servlet inserts a file into the database by a POST action.
 * @author Kevin Leader
 */
@WebServlet(
        name = "analyzerFileUploadAction",
        urlPatterns = { "/analyzer-file-upload-action" }
)
public class AnalyzerFileUploadActionServlet extends HttpServlet {

    private Properties properties;

    /**
     * This method runs every time the servlet is accessed.
     * @param  request          request from user
     * @param  response         response from server
     * @throws ServletException displays exception information to the browser
     * @throws IOException      exception for when PrintWriter doesn't work
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Define context and a new file object
        ServletContext context = getServletContext();
        File inputFile = null;

        // Grab session data
        HttpSession session = request.getSession();

        // Get file from form
        inputFile = (File) request.getAttribute("inputFile");

        // Define variables
        properties = (Properties) context.getAttribute("project4Properties");
        Connection connection = establishConnection();
        Statement statement = null;
        String insertString = "";
        int rowsAffected = 0;
        String message = "";

        // If a file was uploaded, attempt to execute insert
        if (inputFile != null) {
            message = "hi";
        } else {
            // Otherwise, tell user to get with the program
            message = "Please choose a file to upload.";
        }

        // Place the message into the session
        session.setAttribute("fileMessage", message);

        // Redirect to the same jsp
        String url = "/java112/analyzerFileUpload.jsp";
        response.sendRedirect(url);
    }

    /**
     * Returns the database connection
     * @return the database connection
     */
    private Connection establishConnection() {
        Connection connection = null;
        try {
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(
                    properties.getProperty("url"), "student", "student");
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
        return connection;
    }

}