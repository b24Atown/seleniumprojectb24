package com.cybertek.tests.practice.group_work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assignment6VyTrack {
  

   public static WebDriver driver;
    String url = "https://qa2.vytrack.com/user/login";

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test (priority = 1)
    public void fleetLoginTest() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("user41");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), "Dashboard");
    }

    @Test (priority = 2)
    public void vehicleModuleTest() throws InterruptedException {
        WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        WebElement vehicle = driver.findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']"));
        fleet.click();
        vehicle.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(),"Car - Entities - System - Car - Entities - System");
        Thread.sleep(4000);

    }

    @Test (priority = 3)
    public void exportGridButtonTest() {

        WebElement exportGrid = driver.findElement(By.linkText("Export Grid"));

        Assert.assertTrue(exportGrid.isEnabled() && exportGrid.isDisplayed());

    }
    @Test (priority =  4)
    public void buttonLocationTest(){
        WebElement check = driver.findElement(By.xpath("//a[@title='Refresh']/..//preceding-sibling::a[@title='Reset']")); // can also check for following sibling
        Assert.assertTrue(check.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
       //driver.quit();
    }

    public static WebElement getLink(String link){
        return driver.findElement(By.linkText(link));
    }

}
