package com.cybertek.tests.day15_properties_driverutil_testbase;

import com.cybertek.utils.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SystemPropertiesTest {

    @Test
    public void readingSystemProperties(){
        System.out.println(System.getProperty("os.name"));
        System.out.println("User name = " + System.getProperty("user.name"));
        System.out.println("User dir = " + System.getProperty("user.dir"));

        System.out.println("Pom.xml = " + System.getProperty("user.dir") + "/pom.xml");
        System.out.println("java version = " + System.getProperty("java.version"));
    }

    @Test
    public void configurationReaderUnitTest(){
        System.out.println(ConfigurationReader.getProperty("browser"));
        String url = ConfigurationReader.getProperty("webtableUrl");
        System.out.println("url = " + url);

        Assert.assertEquals(ConfigurationReader.getProperty("browser"),"chrome");
        Assert.assertEquals(url, "http://practice.cybertekschool.com/tables");
        Assert.assertEquals(ConfigurationReader.getProperty("hello"),null);
    }
}
