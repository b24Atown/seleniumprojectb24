package com.cybertek.tests.day15_properties_driverutil_testbase;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileTest {

    @Test
    public void readValuesFromPropertiesFile() throws IOException {
        //properties class
        Properties prop = new Properties();

        //open file using FileInputStream
        FileInputStream fis = new FileInputStream("configuration.properties");

        //load file content into properties object
        prop.load(fis);

        System.out.println(prop.getProperty("browser"));
        System.out.println(prop.getProperty("webtableUrl"));
        System.out.println(prop.getProperty("env"));
    }
}
