package com.cybertek.tests.day10_dropdown_alerts_iframes_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDepartmentNamesListTest {

    String url = "https://www.amazon.com";
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void amazonDepartmentTest() throws InterruptedException {
        String pageTitle = "Amazon.com. Spend less. Smile more.";
        Assert.assertEquals(driver.getTitle(),pageTitle);
        Select department = new Select(driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']")));
        Assert.assertEquals(department.getFirstSelectedOption().getText(),"All Departments");
        List <WebElement> allDepartments = department.getOptions();
        int count = allDepartments.size();
        System.out.println("Count of departmetns = " + count);
        Assert.assertTrue(count>10, "Department names are missing");
        //loop and print all available options
        for (WebElement eachDept: allDepartments){
            System.out.println(eachDept.getText());
        }
        //select each item by order and wait 400ms inbetween
        for (WebElement eachElement: allDepartments){
            department.selectByVisibleText(eachElement.getText());
            Thread.sleep(400);
        }

    }

    @Test(enabled = false)
    public void skippingTest(){
        System.out.println("THIS WONT PRINT");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
