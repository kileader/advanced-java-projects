package java112.labs1;

import java.io.*;

public class LabSix {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line,"
                    + " an input file name and an output file name");
            return;
        } else {
            LabSix l6 = new LabSix();
            l6.run(args[0], args[1]);
        }
    }
    public void run(String inputFilePath, String outputFilePath) {
        try (BufferedReader in = new BufferedReader(
                new FileReader(inputFilePath));
                PrintWriter output = new PrintWriter(new BufferedWriter(
                new FileWriter(outputFilePath)))) {
            while(in.ready()) {
                String line = in.readLine();
                output.println(line);
            }
        } catch(FileNotFoundException fne) {
            System.out.println("Could not find file");
            fne.printStackTrace();
        } catch(IOException ioe) {
            System.out.println("Could not close input reader");
            ioe.printStackTrace();
        }
    }
}
