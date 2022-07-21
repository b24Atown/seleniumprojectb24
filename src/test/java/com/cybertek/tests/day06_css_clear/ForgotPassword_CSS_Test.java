package com.cybertek.tests.day06_css_clear;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPassword_CSS_Test {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://practice.cybertekschool.com/forgot_password";
        driver.get(url);
//<input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required="">
        WebElement emailField = driver.findElement(By.cssSelector("input[type='text']"));
        emailField.sendKeys("Student1@gmail.com");
        Thread.sleep(1200);
        emailField.clear();
        emailField.sendKeys("Student2@gmail.com");

        for (int i = 3; i<10;i++){
            Thread.sleep(1000);
            emailField.clear();
            emailField.sendKeys("Student" + i + "@gmail.com");
        }
        driver.quit();


    }
}
