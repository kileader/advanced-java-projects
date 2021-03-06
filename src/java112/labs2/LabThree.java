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
        loadProperties(arg);
    }
    public void loadProperties(String propertiesFilePath)  {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(
                    propertiesFilePath));
            System.out.println(properties);
            Set<String> keys = properties.stringPropertyNames();
            for(String key : keys) {
                System.out.println("Key is: " + key + " value is: "
                        + properties.getProperty(key));
            }
        } catch(IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        } catch(Exception e) {
            System.out.println("Problem: " + e);
            e.printStackTrace();
        }
    }
}
