package com.cybertek.tests.day20_review_wait;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitExamples extends TestBase {

    @Test
    public void explicitWaitTest(){
        driver.get(ConfigurationReader.getProperty("cybertek.url") + "/dynamic_loading/1");
        WebElement start = driver.findElement(By.xpath("//button[.='Start']"));
        start.click();
        WebElement username = driver.findElement(By.id("username"));

        //putting an explicit wait here.
        WebDriverWait wait = new WebDriverWait(driver,10); // need driver object parameter plus wait time
        //then we need to give condition for the element that you are waiting for. for this case element that im waiting for is username.
        wait.until(ExpectedConditions.visibilityOf(username));

        username.sendKeys("MikeSmith");
    }

    @Test
    public void explicitWaitTest2(){
        driver.get(ConfigurationReader.getProperty("cybertek.url") + "/dynamic_controls");
        WebElement enableDisableBtn = driver.findElement(By.xpath("(//button)[2]"));
        enableDisableBtn.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        //input box is visible even without clicking on enable button. however the problem is about clickablility.
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@type='text']"))));

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(faker.name().username());

    }
}
