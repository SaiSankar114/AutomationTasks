package com.yourcompany.parabank.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocatorReader {

    private static Properties loc;

    public static Properties initLocators() {
        loc = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/locators.properties");
            loc.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loc;
    }

    public static String get(String key) {
        return loc.getProperty(key);
    }
}
