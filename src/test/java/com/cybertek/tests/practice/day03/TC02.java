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

public class TC02 {
    ////TC #2: Selecting state from State dropdown and verifying result
    //    //1. Open Chrome browser
    //    //2. Go to http://practice.cybertekschool.com/dropdown
    //    //3. Select Illinois
    //    //4. Select Virginia
    //    //5. Select California
    //    //6. Verify final selected option is California.
    //    //Use all Select options. (visible text, value, index)

    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void SelectedState(){
        WebElement state = driver.findElement(By.id("state"));
        Select stateSelect = new Select(state);
        stateSelect.selectByIndex(14);
        stateSelect.selectByValue("VA");
        stateSelect.selectByVisibleText("California");
        Assert.assertEquals(stateSelect.getFirstSelectedOption().getText(),"California");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
