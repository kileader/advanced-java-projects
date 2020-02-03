package java112.demos;

import java.io.*;

public class ReadDemo {

    public static void main(String[] args) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("testFile.txt"));

            while(in.ready()) {
                String line = in.readLine();
                System.out.println(line);
            }
        } catch(FileNotFoundException fne) {
            System.out.println("Could not find file");
            fne.printStackTrace();
        } catch(IOException ioe) {
            System.out.println("Could not close input reader");
            ioe.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
                System.out.println("Could not close input reader");
                ioe.printStackTrace();
            }

        }

    }

}
