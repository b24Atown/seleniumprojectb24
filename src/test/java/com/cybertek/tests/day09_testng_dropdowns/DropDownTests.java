package com.cybertek.tests.day09_testng_dropdowns;

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

public class DropDownTests {

    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.out.println("Setting up WebDriver...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);

    }
    @Test
    public void titleTest(){
        System.out.println("Title fo the page = " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Practice");
    }

    @Test
    public void simpleDropDownTest(){
        //<select id="dropdown">
        //      <option value="" disabled="disabled" selected="selected">Please select an option</option>
        //      <option value="1">Option 1</option>
        //      <option value="2">Option 2</option>
        //    </select>
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select simpleDropwodn = new Select(dropdown);
        simpleDropwodn.selectByVisibleText("Option 1");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Closing browser");
        driver.quit();
    }
}
