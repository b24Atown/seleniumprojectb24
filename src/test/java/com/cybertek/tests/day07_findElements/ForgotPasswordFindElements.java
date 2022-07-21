package com.cybertek.tests.day07_findElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ForgotPasswordFindElements {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String appUrl = "http://practice.cybertekschool.com/forgot_password";
        driver.get(appUrl);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        //print count of links:
        System.out.println("count of links = " + links.size());

        //print text of first onee
        System.out.println("first link = " + links.get(0).getText());
        //print text of second one
        System.out.println("second link = " + links.get(1).getText());

        //loop and print href value of each one
        for(WebElement eachElement: links){
            System.out.println(eachElement.getAttribute("href"));
        }

        //click on home link at index 0
        links.get(0).click();



        driver.quit();


    }
}
