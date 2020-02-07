package java112.labs1;

import java.io.*;

public class LabFive {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line,"
                    + " a file name and a message");
            return;
        } else {
            LabFive l5 = new LabFive();
            l5.run(args[0], args[1]);
        }
    }
    public void run(String outputFileName, String message) {
        PrintWriter outputWriter = null;
        try {
            outputWriter = new PrintWriter(new BufferedWriter(
                    new FileWriter(outputFileName)));
            outputWriter.println(message);
        } catch (FileNotFoundException fne) {
            System.out.println("Could not find file");
            fne.printStackTrace();
        } catch (IOException inputOutputException) {
            System.out.println("Could not close output writer");
            inputOutputException.printStackTrace();
        } finally {
            if (outputWriter != null) {
                outputWriter.close();
            }
        }
    }
}
