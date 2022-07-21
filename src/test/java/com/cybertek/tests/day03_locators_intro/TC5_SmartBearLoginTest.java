package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_SmartBearLoginTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String appUrl = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
        String userName = "Tester";
        String password = "test";
        driver.get(appUrl);
        Thread.sleep(2000);
        //enter username
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(userName);
        Thread.sleep(2000);
        //Enter password
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
        Thread.sleep(2000);
        //click login
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();


        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASS: login successful");
        }else{
            System.out.println("FAIL: login failed");
        }
        Thread.sleep(2000);

        driver.findElement(By.linkText("Logout")).click();

        driver.quit();


    }
}
