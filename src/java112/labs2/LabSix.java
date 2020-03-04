package java112.labs2;

import java.util.*;
import java.io.*;
import java112.utilities.*;

public class LabSix implements PropertiesLoaderInterface{
    private Properties properties;

    public static void main(String[] args) {
        LabThree l6 = new LabThree();
        l6.run(args[0]);
    }
    public void run(String arg) {
        loadProperties(arg);
    }
}
