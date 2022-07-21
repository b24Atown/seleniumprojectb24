package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day03_prac {

    public static void main (String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.amazon.ca";
        driver.get(url);

        String title = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();
        System.out.println(title);
        System.out.println(currentUrl);
        String header = driver.findElement(By.tagName("h2")).getText();
        System.out.println(header);
        WebElement new_releases = driver.findElement(By.linkText("New Releases"));
        new_releases.click();
        driver.quit();



    }
}
