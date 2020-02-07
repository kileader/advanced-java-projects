package java112.labs1;

import java.io.*;
import java.util.*;

public class LabSeven {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line,"
                    + " an output file name");
            return;
        } else {
            LabSeven l7 = new LabSeven();
            l7.run(args[0]);
        }
    }
    private ArrayList<String> stringList;
    public void run(String outputFilePath) {
        stringList = new ArrayList<String>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");
        stringList.add("five");
        stringList.add("six");
        stringList.add("seven");
        stringList.add("eight");
        stringList.add("nine");
        stringList.add("ten");
        writeListToOutputFile(outputFilePath);
    }
    public void writeListToOutputFile(String outputFilePath) {
        try (PrintWriter output = new PrintWriter(new BufferedWriter(
                new FileWriter(outputFilePath)))) {
            int count;
            for (count = 0; count < stringList.size(); count++) {
                output.println(stringList.get(count));
            }
        } catch(FileNotFoundException fne) {
            System.out.println("Could not find file");
            fne.printStackTrace();
        } catch(IOException ioe) {
            System.out.println("Could not close output writer");
            ioe.printStackTrace();
        }
    }
}
