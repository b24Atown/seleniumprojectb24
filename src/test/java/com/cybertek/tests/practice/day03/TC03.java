package com.cybertek.tests.practice.day03;

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

import java.util.concurrent.TimeUnit;

public class TC03 {

    ////TC #3: Selecting date on dropdown and verifying
    //    //1. Open Chrome browser
    //    //2. Go to http://practice.cybertekschool.com/dropdown
    //    //3. Select “December 1st, 1922” and verify it is selected.
    //    //Select year using : visible text
    //    //Select month using : value attribute
    //    //Select day using : index number

    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void dateSelection(){
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        Select yearSelection = new Select(year);
        Select monthSelection = new Select(month);
        Select daySelection = new Select(day);
        yearSelection.selectByVisibleText("1922");
        monthSelection.selectByValue("11");
        daySelection.selectByIndex(0);
        Assert.assertEquals(yearSelection.getFirstSelectedOption().getText(),"1922");
        Assert.assertEquals(monthSelection.getFirstSelectedOption().getText(),"December");
        Assert.assertEquals(daySelection.getFirstSelectedOption().getText(),"1");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
