package com.cybertek.tests.day14_webtables_properties;

import com.cybertek.utils.SmartBearUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SmartBearProductTest extends SmartBearTestBase{
    @Test
    public void verifyLinksAfterLogin(){
        SmartBearUtils.loginToSmartBear(driver);
        //get all links and print count and text
        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println("Links count = " + list.size());
        for (WebElement each: list){
            System.out.println("Link text = " + each.getText());
        }
    }


    public static void addProduct (WebDriver driver){
        //finish this later
    }
}
