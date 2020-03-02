package java112.demos;

import java.io.*;
import java.util.*;

public class PropertiesDemo {

    public static void main(String[] args) {
        PropertiesDemo demo = new PropertiesDemo();
        demo.mapDemo();
        demo.propertiesDemo();
    }

    private void propertiesDemo() {
        Properties properties = new Properties();

        try {
            properties.load(this.getClass().getResourceAsStream("/demo.properties"));

            System.out.println(properties);

            Set<String> keys = properties.stringPropertyNames();

            for(String key : keys) {
                System.out.println("Key is : " + key + " value is : " + properties.getProperty(key));
            }
        } catch (IOException ioe) {
            System.out.println("Fail on reading of properties file");
            ioe.printStackTrace();
        }

    }

    private void mapDemo() {

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Randy", 1);
        map.put("Wilson", 2);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry);
        }
    }
}
