package com.cybertek.tests.day22_explicitwait_review;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CherCherWaitPracticeTest extends TestBase {

    @BeforeMethod
    public void gotoHomePage(){
        driver.get(ConfigurationReader.getProperty("chercher.url"));
    }

    @Test
    public void waitForAlertTest(){
        WebElement openAlertBtn = driver.findElement(By.id("alert"));
        openAlertBtn.click();
        //we need to wait a bit before we can switch to alert
        WebDriverWait wait2 = new WebDriverWait(driver,15);
        wait2.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void waitForButtonEnabledTest(){

        WebElement btnToEnable = driver.findElement(By.id("enable-button"));
        btnToEnable.click();

        WebElement buttonEnabled = driver.findElement(By.id("disable"));
        System.out.println("char char button enabled = " + buttonEnabled.isEnabled());//false

        WebDriverWait wait2 = new WebDriverWait(driver,20);
        wait2.until(ExpectedConditions.elementToBeClickable(buttonEnabled));
        System.out.println("char char button enabled = " + buttonEnabled.isEnabled());//true


    }

    @Test
    public void waitForCheckBoxIsCheckedTest(){

        WebElement checkbox = driver.findElement(By.id("ch"));
        System.out.println("checkbox is checked = " + checkbox.isSelected());//false

        WebElement enableCheckBocBtn = driver.findElement(By.id("checkbox"));
        enableCheckBocBtn.click();

        //wait until checkbox is selected

        WebDriverWait wait2 = new WebDriverWait(driver,60);
        wait2.until(ExpectedConditions.elementToBeSelected(checkbox));
        System.out.println("checkbox is checked = " + checkbox.isSelected());


    }
}
