package com.cybertek.tests.day05_xpath_css_isdisplayed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ForgotPassword {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://practice.cybertekschool.com/forgot_password";
        driver.get(url);
        // enter email
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("23@hotmail.com");
        //click on retrieve password
        WebElement retrievePword = driver.findElement(By.id("form_submit"));
        retrievePword.click();
        //verify url contains email_sent
        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.contains("email_sent")){
            System.out.println("PASS: email_sent url verified");
        }else {
            System.out.println("FAIL: email_sent url failed");
        }

        //verify your email's been sent! is displayed
        WebElement message = driver.findElement(By.name("confirmation_message"));

        System.out.println("message displayed = " + message.getText());
        String extMessage = "Your e-mail's been sent!";
        String actMessage = message.getText();

        if(extMessage.equals(actMessage)){
            System.out.println("Pass: message displayed correctly");
        }else{
            System.out.println("FAIL: message displayed incorrectly");
        }
        System.out.println("Name attribute value of message element = " + message.getAttribute("confirmation_message"));

        //driver.quit();

    }
}
