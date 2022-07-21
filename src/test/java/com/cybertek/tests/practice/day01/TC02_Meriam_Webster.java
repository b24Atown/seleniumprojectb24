package com.cybertek.tests.practice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TC02_Meriam_Webster {
    public static void main(String[] args) {

        //1. Open Chrome browser
        //2. Go to https://www.merriam-webster.com/
        //3. Print out the texts of all links
        //4. Print out how many link is missing text
        //5. Print out how many link has text
        //6. Print out how many total link

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.merriam-webster.com/";
        driver.get(url);
        int noText = 0;
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement eachlink:links){
            System.out.println(eachlink.getText());
            if(eachlink.getText().isEmpty()){
                noText++;
            }
        }

        System.out.println("Missing text links " + noText);
        System.out.println("Links with text " + (links.size()-noText));
        System.out.println("Total links " + links.size());
    }
}
