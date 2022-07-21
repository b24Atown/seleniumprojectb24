package com.cybertek.tests.day11_alerts_iframe_windows;

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

public class MultipleWindowsExampleTest {

    WebDriver driver;
    String url = "http://practice.cybertekschool.com/windows";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void windowsTest() {
        //get window handle of current window
        String windowHandle = driver.getWindowHandle();
        System.out.println("windowHandle = " + windowHandle);
        //click on new window
        WebElement newWindowLink = driver.findElement(By.linkText("Click Here"));
        newWindowLink.click();

        Set<String> windows = driver.getWindowHandles();
        System.out.println("Count of windows = " + windows.size());
        //print all window handles
        System.out.println("windows = " + windows);
        //loop and switch to a different window

        for (String eachHandle : windows){
            driver.switchTo().window(eachHandle);
            System.out.println(" Current window title = " + driver.getTitle());
        }

        WebElement h3Elem = driver.findElement(By.xpath("//h3"));
        System.out.println("h3 header text on new page = " + h3Elem.getText());
        //go back to main window/parent window
        driver.switchTo().window(windowHandle);
        System.out.println("Title after switching back to main window = " + driver.getTitle());
    }

    @Test
    public void demoQAMultipleWindows(){
        driver.get("https://demoqa.com/browser-windows");
        WebElement newTab = driver.findElement(By.id("tabButton"));
        WebElement newWindow = driver.findElement(By.id("windowButton"));
        WebElement newWindowWithMessage = driver.findElement(By.id("messageWindowButton"));
        newTab.click();
        newWindow.click();
        newWindowWithMessage.click();
        //we never switched to new window yet
        System.out.println("Title of main page = " + driver.getTitle());

        //Store parent window handle id in a variable
        String parentWindowHandle = driver.getWindowHandle();
        //store all  window handle ids into a set
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("Total window count =  " + allWindowHandles.size());

        for (String eachWindow: allWindowHandles){
            System.out.println("Switching to " + eachWindow);
            driver.switchTo().window(eachWindow);
        }


    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}
