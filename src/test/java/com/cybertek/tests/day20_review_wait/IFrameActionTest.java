package com.cybertek.tests.day20_review_wait;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameActionTest extends TestBase {

    @Test
    public void iFrameTest(){
        driver.get(ConfigurationReader.getProperty("doubleclick.url"));
        //switch to iframe (we used id)
        driver.switchTo().frame("iframeResult");
        WebElement textForDoubleClick = driver.findElement(By.id("demo"));
        actions.doubleClick(textForDoubleClick).perform();
        Assert.assertTrue(textForDoubleClick.getAttribute("style").contains("red"));


    }
}
