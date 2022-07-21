package com.cybertek.tests.day12_windows_practice_faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DemoQAMultipleWindowsTest {
    WebDriver driver;
    String url = "https://demoqa.com/browser-windows";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void newWindowTest() {
        //click on new window button, switch to new window, locate and print message,close current window, go back to parent window.
        WebElement newWindow = driver.findElement(By.id("windowButton"));
        newWindow.click();
        Set<String> windoowHandlesSet = driver.getWindowHandles();
        String parentWindowHandle = driver.getWindowHandle();
        for (String eachWindow: windoowHandlesSet){
            if(!eachWindow.equals(parentWindowHandle)) {
                driver.switchTo().window(eachWindow);
            }
        }
        String windowText = driver.findElement(By.tagName("h1")).getText();
        System.out.println(windowText);
        driver.close();
        driver.switchTo().window(parentWindowHandle);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
