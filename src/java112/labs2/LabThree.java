package java112.labs2;

import java.util.*;
import java.io.*;

public class LabThree {
    private Properties properties;

    public static void main(String[] args) {
        LabThree l3 = new LabThree();
        l3.run(args[0]);
    }
    public void run(String arg) {
        String propertiesFilePath = arg;
        loadProperties(propertiesFilePath);
    }
    public void loadProperties(String propertiesFilePath)  {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(
                    propertiesFilePath));
        } catch(IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        } catch(Exception e) {
            System.out.println("Problem: " + e);
            e.printStackTrace();
        }
        System.out.println(properties.getProperty());
    }
}
