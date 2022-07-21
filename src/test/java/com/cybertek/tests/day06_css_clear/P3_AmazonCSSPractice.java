package com.cybertek.tests.day06_css_clear;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_AmazonCSSPractice {

    public static void main(String[] args) throws InterruptedException {

        String appUrl = "https://www.amazon.com";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(appUrl);
        //<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">
        WebElement searchField = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        WebElement searchField2 = driver.findElement(By.cssSelector("input[aria-label='Search']"));
        Thread.sleep(2000);

        searchField2.sendKeys("wooden  spoon");
        WebElement searchIcon = driver.findElement(By.cssSelector("input[id='nav-search-submit-button']"));
        searchIcon.click();

        //page refreshes at this point. we need to locate the elements again in order to use them. can just copy but practicing here with doing it more often.
        searchField = driver.findElement(By.cssSelector("input[name='field-keywords']"));
        searchIcon  = driver.findElement(By.cssSelector("input[id='nav-search-submit-button']"));

        //clear the search input box then search for "iphone 13 case".
        searchField.clear();

        searchField.sendKeys("iphone 13 case");
        searchIcon.click();
    }
}
