package com.cybertek.tests.day22_explicitwait_review;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitUntilElemVisibleTest extends TestBase {

    @Test
    public void waitForWebDriverElem(){

        driver.get(ConfigurationReader.getProperty("seleniumpractice.url"));
        WebElement timer = driver.findElement(By.xpath("//button[@onclick='timedText()']"));
        timer.click();
        //wait until webdriver is visible

        WebDriverWait wait12 = new WebDriverWait(driver,30);
        wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.='WebDriver']")));

    }

    @Test
    public void cheapInternetSpeedTest(){

        driver.get(ConfigurationReader.getProperty("speedtest.url"));

        //wait until change server link is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Change Server")));
        //click go button
        WebElement goBtn = driver.findElement(By.xpath("//span[.='Go']"));
        goBtn.click();
        //creating a new wait object just because the testbase one is only 10s

        WebDriverWait wait2 = new WebDriverWait(driver,60);
        WebElement gauge = driver.findElement(By.className("gauge-speed-text"));

        //we want to test for the gage to dissapear but when we check right away, the guage doesnt show up so we wait for it to show up first and then check for it to leave.
        //another thing to keep in mind is when we inspected this, it showed this as always in the html but were checking for visibility and invisibility not whether it exists.
        wait2.until(ExpectedConditions.visibilityOf(gauge));
        wait2.until(ExpectedConditions.invisibilityOf(gauge));

        WebElement downloadSpeed = driver.findElement(By.xpath("//span[@class='result-data-large number result-data-value download-speed']"));
        System.out.println(downloadSpeed.getText());

    }
}
