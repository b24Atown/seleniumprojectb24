package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.cybertek.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationFormNegativeTest extends RegistrationFormTestBase {

    @Test
    public void invalidFirstNameTest() {
        //do not enter any value in firstName and click on signup
        //"firstname is required "error message should be displayed
        WebElement signup = driver.findElement(By.id("wooden_spoon"));
        signup.click();
        BrowserUtils.sleep(2);

        WebElement errorMsg = driver.findElement(By.xpath("//small[.='first name is required']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "FAIL: message is not displayed");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("12345");
        WebElement nooNumberMsg = driver.findElement(By.xpath("//small[.='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(nooNumberMsg.isDisplayed(), "Error message is not displayed");
        BrowserUtils.sleep(2);

    }
}