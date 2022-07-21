package com.cybertek.tests.practice.day06;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBear {

    WebDriver driver;
    String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void softwareLinkVerificationTest(){
        WebElement login =driver.findElement(By.id("ctl00_MainContent_username"));
        login.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test" + Keys.ENTER);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Count of links = "+links.size());
        for (WebElement each: links){
            System.out.println(each.getText() + " - " + each.getAttribute("href"));
        }

    }
}
