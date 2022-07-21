package com.cybertek.tests.practice.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC04 {

    ////TC #4: Selecting value from multiple select dropdown
    //    //1. Open Chrome browser
    //    //2. Go to http://practice.cybertekschool.com/dropdown
    //    //3. Select all the options from multiple select dropdown.
    //    //4. Print out all selected values.
    //    //5. Deselect all values.
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
    public void programmingLanguage(){
        WebElement languages = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select languageOption = new Select(languages);
        List<WebElement> options = new ArrayList<>();
        for (int i = 0; i<6;i++){
            languageOption.selectByIndex(i);
            options = languageOption.getOptions();
            System.out.println(options.get(i).getText());
        }
        for (WebElement each: options){
            each.click();
        }

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
