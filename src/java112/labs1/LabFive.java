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
            l5.run();
        }
    }
}
