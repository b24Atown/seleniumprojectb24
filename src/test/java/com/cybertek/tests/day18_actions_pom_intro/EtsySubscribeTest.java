package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EtsySubscribeTest extends TestBase {

    @Test
    public void etsySubscribeTest() {
        //go to etsy, scroll down, generate random email, enter subscribe, verify email confirmation
        driver.get(ConfigurationReader.getProperty("etsy.url"));
        WebElement emailEntry = driver.findElement(By.id("email-list-signup-email-input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true)", emailEntry);
        Faker faker = new Faker();
        emailEntry.sendKeys(faker.internet().emailAddress() + Keys.ENTER);

        BrowserUtils.sleep(5);
        WebElement verificationNotice = driver.findElement(By.xpath("//div[@class='wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01']"));
        Assert.assertEquals(verificationNotice.getText(), "Great! We've sent you an email to confirm your subscription.");
    }
}
