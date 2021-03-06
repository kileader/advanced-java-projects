package java112.project4;

import java.io.*;
import java.sql.*;

/**
 * The purpose of this class is to use the command line to insert employee
 * data into a database table.
 * @author Kevin Leader
 */
public class JDBCInsertEmployee {

    public void runInsert(String[] args) {

        Connection connection = null;
        Statement statement = null;
        int rowsAffected;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");

            statement = connection.createStatement();

            String insertString = "INSERT INTO employees VALUES (0, '" +
                    args[0] + "', '" + args[1] + "', '" + args[2] + "', '" +
                    args[3] + "', '" + args[4] + "', '" + args[5] + "')";

            System.out.println("insertString: " + insertString);

            rowsAffected = statement.executeUpdate(insertString);

            System.out.println();

            String ssn = args[2];
            String queryString = "SELECT * FROM employees WHERE ssn = '" +
                    ssn + "'";

            System.out.println("queryString: " + queryString);

            System.out.println();

            resultSet = statement.executeQuery(queryString);

            while (resultSet.next()) {
                String employeeId = resultSet.getString("emp_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String socialSecurity = resultSet.getString("ssn");
                String department = resultSet.getString("dept");
                String roomNumber = resultSet.getString("room");
                String phoneNumber = resultSet.getString("phone");
                System.out.println(" Inserted Record: " + employeeId + " "
                        + firstName + " " + lastName + " " + socialSecurity
                        + " " + department + " " + roomNumber
                        + " " + phoneNumber);
            }

        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
            System.err.println("Class not found Exception: " +
                    classNotFound.getMessage());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.err.println("sql Exception: " +
                    sqlException.getMessage());
        } catch (Exception exception) {
            exception.printStackTrace();
            System.err.println("General Exception: " +
                    exception.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                System.err.println("sql Exception: " +
                        sqlException.getMessage());
            } catch (Exception exception) {
                exception.printStackTrace();
                System.err.println("General Exception: " +
                        exception.getMessage());
            }
        }
    }

    /**
     * The main method that executes an insert statement. It checks if the
     * command line has 6 arguments then runs the insert if true.
     * @param  args  The command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 6) {
            System.out.println("Please only input six arguments "
                    + "to the command line.");
            return;
        } else {
            JDBCInsertEmployee insert = new JDBCInsertEmployee();

            insert.runInsert(args);
        }
    }
}