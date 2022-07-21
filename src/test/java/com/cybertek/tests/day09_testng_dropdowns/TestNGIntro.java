package com.cybertek.tests.day09_testng_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGIntro {
    //can be used by each test
    String url = "https://www.etsy.com";

    @BeforeClass
    public void setUp(){
        System.out.println("@BeforeClass setUp method...");
        System.out.println("Opened browserr and Nagivation to " + url);
        System.out.println("====================");
    }
    @BeforeMethod
    public void setUpApp(){
        System.out.println("@BeforeMethod setUpApp method is running ...");
        System.out.println("Navigating back to " + url);
        System.out.println("====================");
    }


    @Test(priority = 1) // converts regular method to test method. put priority 1 so we dont go alphabetically
    public void test1(){
        System.out.println("Running test1 ...");
        int num = 10;
        Assert.assertEquals(10,num);
        System.out.println("====================");
    }
    @Test (priority = 2)
    public void myTestTwo(){
        System.out.println("Running test two ...");
        String name = "Bob";
        Assert.assertTrue(name.contains("B"));
        System.out.println("====================");
    }
    //if we run all of them, it will run alphabetically so myTestTwo will run first.
    @AfterMethod
    public void tearDown(){
        System.out.println("@AfterMethod tearDown is running ...");
        System.out.println("====================");
    }
    @AfterClass
    public void cleanUp(){
        System.out.println("@AfterClass cleanUp method is running");
        System.out.println("====================");
    }
}
