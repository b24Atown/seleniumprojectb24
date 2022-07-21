package com.cybertek.tests.practice.day08;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Iframes extends TestBase {

    @Test
    public void frames(){
        String url = "http://practice.cybertekschool.com/windows";
        driver.get(url);
        String window1 = driver.getWindowHandle();
        System.out.println(window1);
        WebElement newWindow = driver.findElement(By.linkText("Click Here"));
        newWindow.click();

    }
}
