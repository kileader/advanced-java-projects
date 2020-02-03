package java112.labs1;

import java.io.*;

public class LabFour {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");
            return;
        } else {
            LabFour l4 = new LabFour();
            l4.run(args[0]);
        }
    }
    public void run(String arg) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(arg));

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
