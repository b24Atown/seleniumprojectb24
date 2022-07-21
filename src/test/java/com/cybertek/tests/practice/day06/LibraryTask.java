package com.cybertek.tests.practice.day06;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LibraryTask {

    WebDriver driver;
    String url = "http://library2.cybertekschool.com/login.html";

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void softwareLinkVerificationTest(){
       WebElement login =driver.findElement(By.id("inputEmail"));
       login.sendKeys("student11@library");
       WebElement password = driver.findElement(By.id("inputPassword"));
       password.sendKeys("tScBPCUr" + Keys.ENTER);

    }
}
