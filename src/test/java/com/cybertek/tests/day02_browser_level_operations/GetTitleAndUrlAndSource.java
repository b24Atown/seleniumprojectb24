package com.cybertek.tests.day02_browser_level_operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrlAndSource {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        String url = "https://www.etsy.com";

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        System.out.println(driver.getTitle());
        String etsyTitle = driver.getTitle();
        System.out.println("etsyTitle = " + etsyTitle); //soutv quick way to print the variable
        System.out.println("Current url:" + driver.getCurrentUrl());
        String currUrl = driver.getCurrentUrl();
        System.out.println("currUrl = " + currUrl);

        //read page source and print it
        System.out.println("HTML page source: " + driver.getPageSource());
        //store source code into a variable then print the char count
        String pageSource = driver.getPageSource();
        System.out.println("Count of html = " + pageSource.length());

        driver.quit();
    }
}
