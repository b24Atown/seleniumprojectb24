package com.cybertek.tests.day11_alerts_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertExamplesTest {

    WebDriver driver;
    String url = "http://practice.cybertekschool.com/javascript_alerts";

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void infoAlertTest(){
        //click on JS alert link
        WebElement alertLink = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertLink.click();
        //switch to alert and assert texrt is "I am a JS Alert
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept();
        WebElement resultMsg = driver.findElement(By.id("result"));
        Assert.assertEquals(resultMsg.getText(),"You successfuly clicked an alert");
    }
    @Test
    public void confirmAlertTest(){
        // click on js confirm link switch to alert assert the text is" i am js confirm" then click on cancel and assert result msg is "you clicked: cancel"
        WebElement alertButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        alertButton.click();
        Alert alert2 = driver.switchTo().alert();
        Assert.assertEquals(alert2.getText(),"I am a JS Confirm");
        alert2.dismiss();
        WebElement resultMSG = driver.findElement(By.id("result"));
        Assert.assertEquals(resultMSG.getText(),"You clicked: Cancel");
    }

    @Test
    public void promtAlertTest(){
        WebElement alertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        alertButton.click();
        Alert alert3 = driver.switchTo().alert();
        Assert.assertEquals(alert3.getText(),"I am a JS prompt");
        alert3.sendKeys("hello");
        alert3.accept();
        WebElement resultMSG3 = driver.findElement(By.id("result"));
        Assert.assertEquals(resultMSG3.getText(),"You entered: hello");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
