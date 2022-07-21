package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {
        //setup webdriver
        WebDriverManager.chromedriver().setup();
        //setup instance of webdriver
        WebDriver driver = new ChromeDriver();
        //navigate to webpage
        driver.get("https://tesla.com");
        //click back
        driver.navigate().back();
        //making it stop for 2 seconds while it navigates so we see it happening cuz its usually fast. "adding wait time"
        Thread.sleep(2000);
        //clicking forward
        driver.navigate().forward();
        //adding some more sleep time
        Thread.sleep(2000);
        //refresh
        driver.navigate().refresh();
        //adding more sleep timee
        Thread.sleep(2000);

        //navigate to bestbuy
        driver.navigate().to("https://bestbuy.com");
        //print title of page
        System.out.println("Current title: " + driver.getTitle());
        //close the browser

        Thread.sleep(2000);
        driver.quit();

    }
}
