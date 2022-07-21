package com.cybertek.tests.practice.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ToggleSwitches {
    String url = "http://te.dev.secureci.com/Exercise2.html";
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void toggleSwitch(){
        List<WebElement> switches = driver.findElements(By.xpath("//label[@class='switch']"));
        for (WebElement eachSwitch : switches){
            eachSwitch.click();
        }
    }
    @AfterClass
    public void tearDown(){
       // driver.quit();
    }
}
