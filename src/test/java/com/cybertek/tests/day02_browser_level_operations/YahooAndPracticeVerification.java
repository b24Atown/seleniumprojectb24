package com.cybertek.tests.day02_browser_level_operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooAndPracticeVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.yahoo.com");
        String expectedTitle = "Yahoo";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASS title verification successful");
        }else{
            System.out.println("FAIL title verification failed");
        }
        System.out.println(expectedTitle);
        System.out.println(actualTitle);

        driver.manage().window().maximize(); // make browser full screen
        driver.get("https://www.cybertekschool.com");
        String actualUrl = driver.getCurrentUrl();
        String title = driver.getTitle();

        if(actualUrl.contains("cybertekschool")){
            System.out.println("PASS: Url verification success");
        }else {
            System.out.println("FAIL: Url verification failed");
        }

        if(title.equals("Practice")){
            System.out.println("PASS: Title verification success");
        }else {
            System.out.println("FAIL: Title verification failed");
        }
        System.out.println(title);
        System.out.println(actualUrl);

        driver.quit();
    }
}
