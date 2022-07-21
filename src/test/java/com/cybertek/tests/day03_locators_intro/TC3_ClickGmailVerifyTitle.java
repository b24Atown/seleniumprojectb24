package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ClickGmailVerifyTitle {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        //find gmail link and click it
       driver.findElement(By.linkText("Gmail")).click();
        //driver.findElement(By.partialLinkText("mail")).click(); //good
       // driver.findElement(By.partialLinkText("a")).click(); //good
        //driver.findElement(By.partialLinkText("Yahoo")).click();//exception
        //even though these partial link texts work, might not be the best way to check some of them such as line 21 since it could be false positive.

        //verify title contains/starts with Gmail
        String actualTitle = driver.getTitle();
        String expectedTitle = "Gmail";
        if(actualTitle.contains(expectedTitle)){
            System.out.println("PASS: gmail title verification successful");
        }else{
            System.out.println("FAIL: gmail title verification failed");
        }

        driver.navigate().back();

        String googleExpectedTitle = "Google";
        String googleActualTitle = driver.getTitle();

        if(googleActualTitle.equals(googleExpectedTitle)){
            System.out.println("PASS: google title verification successful");
        }else{
            System.out.println("Fail: google title verification failed");
        }


       driver.quit();


    }
}
