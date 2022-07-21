package com.cybertek.tests.day04_locators_getattribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PercentageCalculatorTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();//setup driver for browser type
        WebDriver driver= new ChromeDriver(); //launch selenium webdriver chrome browser. driver is our selenium.
        driver.manage().window().maximize();
        String url = "https://www.calculator.net/";
        driver.get(url);
        //By is called the locator.
        driver.findElement(By.linkText("Percentage Calculator")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Percentage Calculator";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASS: Title verification successful");
        }else {
            System.out.println("FAIL: Title verification failed");
        }

        driver.findElement(By.name("cpar1")).sendKeys("20");
        driver.findElement(By.id("cpar2")).sendKeys("120000" + Keys.ENTER);

        String actualResult = driver.findElement(By.className("h2result")).getText();
        int expectedResult = 24000;

        if(actualResult.endsWith("24000")){
            System.out.println("PASS: Result verification successful");
        }else {
            System.out.println("FAIL: Result verification failed");
        }

        driver.quit();


    }
}
