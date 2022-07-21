package com.cybertek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SmartBearUtils {

        public static void loginToSmartBear(WebDriver driver){
            WebElement username =driver.findElement(By.id("ctl00_MainContent_username"));
            WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
            WebElement loginBtn = driver.findElement(By.name("ctl00$MainContent$login_button"));
            username.sendKeys("Tester");
            password.sendKeys("test");
            loginBtn.click();
            Assert.assertEquals(driver.getTitle(), "Web Orders", "Failed to login to smartbear app");
        }
}
