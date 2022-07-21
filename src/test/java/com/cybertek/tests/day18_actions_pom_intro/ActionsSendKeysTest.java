package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ActionsSendKeysTest extends TestBase {

    @Test
    public void scrollWithKeysTest(){
        driver.get(ConfigurationReader.getProperty("cybertek.url"));
        WebElement ctSchoolLink = driver.findElement(By.linkText("Cybertek School"));
        actions.moveToElement(ctSchoolLink).perform();
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @Test
    public void rightClickTest(){
        driver.get(ConfigurationReader.getProperty("cybertek.url"));
        WebElement ab = driver.findElement(By.linkText("A/B Testing"));

        actions.contextClick(ab).perform();

        //below line not working right now but should be
        actions.contextClick(ab).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
    }
}
