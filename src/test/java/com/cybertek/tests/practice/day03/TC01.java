package com.cybertek.tests.practice.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC01 {
    ////TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
    //    //1. Open Chrome browser
    //    //2. Go to http://practice.cybertekschool.com/dropdown
    //    //3. Verify “Simple dropdown” default selected value is correct
    //    //Expected: “Please select an option”
    //    //4. Verify “State selection” default selected value is correct
    //    //Expected: “Select a State”

    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void simpleDropdown(){

        WebElement dropdown = driver.findElement(By.xpath("//option[.='Please select an option']"));
        Assert.assertEquals(dropdown.getText(),"Please select an option");
        WebElement selectState = driver.findElement(By.xpath("//option[.='Select a State']"));
        Assert.assertEquals(selectState.getText(),"Select a State");
    }






    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
