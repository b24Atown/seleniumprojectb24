package com.cybertek.tests.day10_dropdown_alerts_iframes_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CarGurusUsedCarSearchTest {

    String url = "https://www.cargurus.com";
    WebDriver driver;

    @BeforeClass
    public void setUP(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);

    }

    @Test
    public void searchForMinivan(){
        //verify were on the correct page
        String expectedTitle = "Buy & Sell Cars: Reviews, Prices, and Financing - CarGurus";
        Assert.assertEquals(driver.getTitle(),expectedTitle);
        WebElement makeButton = driver.findElement(By.xpath("//select[@class='form-control cg-carPicker-makerSelect maker-select-dropdown ft-make-selector']"));
        Select selectMake = new Select(makeButton);
        selectMake.selectByVisibleText("Toyota");
        Select selectModel = new Select(driver.findElement(By.xpath("//select[@class='form-control cg-carPicker-modelSelect model-select-dropdown ft-model-selector']")));
        selectModel.selectByValue("d308");

        WebElement zipCode = driver.findElement(By.name("zip"));
        zipCode.sendKeys("22102");
        //print make and model of dropdown
        System.out.println("Selected make = " + selectMake.getFirstSelectedOption().getText());
        System.out.println("Selected model = " + selectModel.getFirstSelectedOption().getText());
        //click on search
        WebElement searchButton = driver.findElement(By.id("dealFinderForm_0"));
        searchButton.click();
        //print how many tootal listings
        WebElement totalListings = driver.findElement(By.xpath("//span[@class='oKvYB4']/strong[2]"));
        System.out.println("Result count = " + totalListings.getText());
        //Assert that count is more than 0
        int count = Integer.parseInt(totalListings.getText());
        Assert.assertTrue(count>0);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
