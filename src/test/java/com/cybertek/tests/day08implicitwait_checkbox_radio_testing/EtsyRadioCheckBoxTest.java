package com.cybertek.tests.day08implicitwait_checkbox_radio_testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EtsyRadioCheckBoxTest {
    public static void main(String[] args) throws InterruptedException {

        String url = "https://www.etsy.com";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        //search for wooden spoon
        WebElement searchBox = driver.findElement(By.xpath("//input[@data-id='search-query']"));
        searchBox.sendKeys("wooden spooon"+ Keys.ENTER);
        //click on all filters
        //<button id="search-filter-button" class="wt-btn wt-btn--small wt-btn--secondary wt-display-flex-xs wt-align-items-center" aria-controls="search-filters-overlay">
        WebElement allFilters = driver.findElement(By.xpath("//button[@id='search-filter-button']"));
        allFilters.click();
        //click on under 25
        //<label for="price-input-1" class="wt-radio__label wt-display-inline">
        WebElement radioButton = driver.findElement(By.xpath("//label[@for='price-input-1']"));
        radioButton.click();
        //<label for="special-offers-free-shipping" class="wt-checkbox__label wt-display-inline">
        //            FREE delivery
        //        </label>
        WebElement freeShipping = driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));
        freeShipping.click();
//click apply button
        //<button class="wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3" type="submit" form="search-filter-form" aria-label="Apply" data-wt-overlay-close="">
        WebElement applyButton = driver.findElement(By.xpath("//button[@aria-label='Apply']"));
        applyButton.click();
        //print number of results
        //span[contains(text(),'results,')]
        Thread.sleep(2000);
        String results = driver.findElement(By.xpath("//span[contains(text(),'results,')]")).getText();
        System.out.println(results.substring(0,results.length()-1)); //did that cuz it printed results, so just got rid of the comma.

        driver.quit();
    }
}
