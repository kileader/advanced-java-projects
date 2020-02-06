package java112.demos;

import java.io.*;

public class WriteDemo {

    public static void main(String[] args) {

        try (BufferedReader in = new BufferedReader(new FileReader("testFile.txt"));
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output/outTest.txt")))) {
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
