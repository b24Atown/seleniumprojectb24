package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankTC1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://zero.webappsecurity.com/login.html";
        driver.get(url);

        //verify header text
        String actualHeader = driver.findElement(By.tagName("h3")).getText();
        String expectedHeader = "Log in to ZeroBank";

        if(actualHeader.equals(expectedHeader)){
            System.out.println("PASS: header is displayed correctly");
        }else {
            System.out.println("FAIL: header mismatch");
        }
        driver.quit();

    }
}
