package com.cybertek.tests.practice.day07;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframeTest extends TestBase {

    @Test
    public void iFr(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-bottom");
        WebElement body = driver.findElement(By.xpath("//body[contains(.,'BOTTOM')]"));
        System.out.println(body.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame(1);
        driver.switchTo().parentFrame().switchTo().defaultContent();

    }
}
