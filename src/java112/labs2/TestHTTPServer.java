package java112.labs2;


import java.io.*;
import java.net.*;


/**
 *  A simple HTTP Server demo.
 *
 *@author    eknapp
 */
public class TestHTTPServer {

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(4444);) {
            acceptClientSocket(serverSocket);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public void acceptClientSocket(ServerSocket serverSocket) {

        try (Socket clientSocket = serverSocket.accept();) {
            openStreams(clientSocket);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
            return;
        } catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }


    private void openStreams(Socket clientSocket) {

        try (
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))

        ) {
            readHttpHeaders(input);
            writeHttpResponse(output);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    private void readHttpHeaders(BufferedReader input) throws IOException {
        String inputLine;

        while (input.ready()) {
            inputLine = input.readLine();
            System.out.println(inputLine);
        }
    }


    private void writeHttpResponse(PrintWriter output) {
        output.println("HTTP/1.0 200 OK");
        output.println("Connection: close");
        output.println("Content-Type: text/html");
        output.println();
        output.println("<html><head></head><body><h1>Yo!</h1></body></html>");
    }


    /**
     *  The main program for the TestHTTPServer class.
     *
     *@param  arguments The command line arguments
     */
    public static void main(String[] arguments) {
        TestHTTPServer httpTest = new TestHTTPServer();
        httpTest.run();
    }
}
