package com.cybertek.tests.day11_alerts_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IframesExampleText {

    WebDriver driver;
    String url = "http://practice.cybertekschool.com/iframe";

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void iframeTest(){
//        WebElement commentField = driver.findElement(By.id("tinymce"));
//        System.out.println("Comment text = " + commentField.getText());
        //this wont work cuz of iframe so we need to switch to frame first.
        driver.switchTo().frame("mce_0_ifr");
        // now were focused on frame. so now we can finally do this.
        WebElement commentField = driver.findElement(By.id("tinymce"));
        System.out.println("Comment text = " + commentField.getText());
        commentField.clear();
        commentField.sendKeys("Hello Hello");
        driver.switchTo().defaultContent();
    }

    @Test
    public void multipleFrameTest(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        //find out count of frames on this page.
        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        System.out.println(frames.size() + " frames on this page");
        //shows 2 because the others are nested. but there are more.
        //switch to buttom frame by name.
        driver.switchTo().frame("frame-bottom");
        WebElement bodyElem = driver.findElement(By.tagName("body"));
        System.out.println("Text of the bottom frame = " + bodyElem.getText());

        //go out from bottom frame to main level
        driver.switchTo().defaultContent();

        //switch to first frame(index 0)
        //theres a main frame and it has a 3 child frames inside it. 0 frame will be the first one. frame1 will be middle. frame2 will be right.
        driver.switchTo().frame(0).switchTo().frame(0);
        bodyElem = driver.findElement(By.tagName("body"));
        System.out.println("Frame 0 body elem text = " + bodyElem.getText());

        // go back to parent frame
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        driver.switchTo().frame(0).switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_right']")));
        bodyElem= driver.findElement(By.tagName("body"));
        System.out.println("Frame right body elem text = " + bodyElem.getText());
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}
