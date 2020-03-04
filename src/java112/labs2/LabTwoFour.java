package java112.labs2;

import java.util.*;
import java.io.*;

public class LabTwoFour {

    private Map<String, Integer> map;
    private Map<String, Integer> map2;

    public static void main(String[] args) {
        LabTwoFour l24 = new LabTwoFour();
        l24.run();
    }

    public void run() {
        map = new HashMap<String, Integer>();

        map.put("Greg", 22);
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Kevin", 7);
        map.put("Bob", 1337);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry);
        }

        System.out.println(map);

        if (map.containsKey("Three")) {
            System.out.println(map.get("Three"));
        } else {
            System.out.println("ERROR: Value not in map");
        }

        map2 = new TreeMap<String, Integer>(map);

        System.out.println(map2);
    }

}
