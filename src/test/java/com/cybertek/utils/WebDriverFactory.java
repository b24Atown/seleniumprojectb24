package com.cybertek.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    /*
    WebDriverFactory class:
    it is used to create WebDriver (selenium) object and return it.
    it will open the browser.
    method:
    getDriver(String browserType)
    It will check btowser type and returns object:
        If browserType is "chrome":
        it will setup chhrome driver, and return new ChromeDriver
        if browserType is "firefox":
        it will setup firefox driver, and return new FirefoxDriver
     */

    public static WebDriver getDriver (String browserType){
        if(browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else {
            System.out.println("Invalid BrowserType = " + browserType);
            return null;
        }
    }
}
