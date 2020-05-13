package java112.project4;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * This servlet inserts a file into the database by a POST action.
 * @author Kevin Leader
 */
@WebServlet(
        name = "analyzerFileUploadAction",
        urlPatterns = { "/analyzer-file-upload-action" }
)
@MultipartConfig()
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

        // Define ServletContext and fileInputStream
        ServletContext context = getServletContext();
        InputStream fileInputStream = null;

        // Grab session data
        HttpSession session = request.getSession();

        // Get the file name and file from form
        Part filePart = request.getPart("inputFile");
        String fileName = filePart.getSubmittedFileName();

        // Get the InputStream to store the file
        fileInputStream = filePart.getInputStream();

        // Define variables
        properties = (Properties) context.getAttribute("project4Properties");
        Connection connection = establishConnection();
        String insertString = "";
        int rowsAffected = 0;
        String message = "";
        String sql = "INSERT INTO files VALUES (0, ?, ?)";

        // If a file was uploaded, attempt to execute insert
        if (fileInputStream != null) {
            try (PreparedStatement preparedStatement
                         = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, fileName);
                preparedStatement.setBlob(2, fileInputStream);

                rowsAffected = preparedStatement.executeUpdate();

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            // Check if the insert worked
            if (rowsAffected == 0) {
                message = "SQL Insert Failed";
            } else {
                message = "Successfully added " + fileName;
            }
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