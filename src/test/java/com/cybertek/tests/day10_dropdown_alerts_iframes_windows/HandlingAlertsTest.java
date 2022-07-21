package com.cybertek.tests.day10_dropdown_alerts_iframes_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HandlingAlertsTest {
    String url = "http://practice.cybertekschool.com/javascript_alerts";
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
    public void jsAlertsTest(){
        WebElement infoAlertLink = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        infoAlertLink.click();
        Alert infoAlert = driver.switchTo().alert();
        System.out.println("Text of alert = " + infoAlert.getText());
        infoAlert.accept(); // click on ok
    }

    @Test
    public void confirmAlertTest(){
        WebElement confirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirm.click();
        Alert alertMsg = driver.switchTo().alert();
        System.out.println("Text of alert = " + alertMsg.getText());
        Assert.assertEquals(alertMsg.getText(),"I am a JS Confirm");
        alertMsg.dismiss();

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
