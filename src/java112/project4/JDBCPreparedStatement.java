package java112.project4;

import java.io.*;
import java.sql.*;

/**
 * The purpose of this class is to run an employee insert using prepared
 * statements.
 * @author Kevin Leader
 */
public class JDBCPreparedStatement {

    public void runInsert(String[] args) {

        Connection con = null;
        PreparedStatement preparedInsert = null;
        Statement statement = null;
        int rowsAffected;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");

            preparedInsert = con.prepareStatement("INSERT INTO employees " +
                    "VALUES (0, ?, ?, ?, ?, ?, ?)");

            preparedInsert.setString(1, args[0]);
            preparedInsert.setString(2, args[1]);
            preparedInsert.setString(3, args[2]);
            preparedInsert.setString(4, args[3]);
            preparedInsert.setString(5, args[4]);
            preparedInsert.setString(6, args[5]);

            rowsAffected = preparedInsert.executeUpdate();

            String ssn = args[2];
            String queryString = "SELECT * FROM employees WHERE ssn = '" +
                    ssn + "'";

            System.out.println("queryString: " + queryString);
            System.out.println();

            statement = con.createStatement();
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
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
                if (preparedInsert != null) {
                    preparedInsert.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * The main method that executes an insert statement. It checks if the
     * command line has 6 arguments then runs the insert if true.
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 6) {
            System.out.println("Please only input six arguments "
                    + "to the command line.");
            return;
        } else {
            JDBCPreparedStatement insert = new JDBCPreparedStatement();

            insert.runInsert(args);
        }
    }
}
