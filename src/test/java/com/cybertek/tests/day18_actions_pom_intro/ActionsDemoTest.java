package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsDemoTest extends TestBase {

    @Test
    public void hoverElementTest(){
        driver.get(ConfigurationReader.getProperty("hover.url"));
        Actions action = new Actions(driver);
        WebElement img1 = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//div[@class='figure'])[3]"));

        action.moveToElement(img1).perform();
        BrowserUtils.sleep(1);
        action.moveToElement(img2).perform();
        BrowserUtils.sleep(1);
        action.moveToElement(img3).perform();

        //repeat above steps with loop

    }
    @Test
    public void hoverOverGroupOfElements(){
        driver.get(ConfigurationReader.getProperty("hover.url"));
        List<WebElement> images = driver.findElements(By.tagName("img"));
        Actions actions = new Actions(driver);

        for (WebElement img : images){
            BrowserUtils.sleep(1);
            actions.moveToElement(img).perform();
        }
    }

    @Test
    public void googleFeelingLuckyBtnHoverTest(){
        driver.get(ConfigurationReader.getProperty("google.url"));
        WebElement googleSearch = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@value='Google Search']"));
        WebElement imFeelingLucky = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@class='RNmpXc']"));
        for (int i = 1; i<=5;i++){
        actions.moveToElement(imFeelingLucky).perform();
        BrowserUtils.sleep(1);
        actions.moveToElement(googleSearch).perform();
        BrowserUtils.sleep(1);
        }
    }
}
