package java112.labs1;

import java.io.*;
import java.util.*;

public class LabEight {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line,"
                    + " an output file name");
            return;
        } else {
            LabEight l8 = new LabEight();
            l8.run(args[0]);
        }
    }
    SortedSet<String> set;
    public void run(String outputFilePath) {
        set = new TreeSet<>();
        set.add("one");
        set.add("one");
        set.add("five");
        set.add("two");
        set.add("four");
        set.add("two");
        set.add("three");
        set.add("three");
        set.add("four");
        set.add("three");
        writeSetToOutputFile(outputFilePath);
    }
    public void writeSetToOutputFile(String outputFilePath) {
        try (PrintWriter output = new PrintWriter(new BufferedWriter(
                new FileWriter(outputFilePath)))) {
            for (String element : set) {
                output.println(element);
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
