package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MultipleButtonsXpathTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "http://practice.cybertekschool.com/multiple_buttons";
        driver.get(url);
        //locate button1
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick = 'button1()']"));
        //click on button1.
        button1.click();
        //print msg after clicking on button
        WebElement resultMsg = driver.findElement(By.xpath("//p[@id = 'result']"));
        System.out.println(resultMsg.getText());

        //locate button2 using xpathh and check if it is currently displayed on the page
        //this second way we use method text() allows us to just search directly for text name.
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Button 2']"));

        if(button2.isDisplayed()){
            System.out.println("PASS: button2 is displayed");
            button2.click();
        }else {
            System.out.println("FAIL: button2 is not displayed");
        }

       driver.quit();

    }
}
