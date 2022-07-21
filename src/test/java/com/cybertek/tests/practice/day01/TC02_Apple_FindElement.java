package com.cybertek.tests.practice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TC02_Apple_FindElement {
    //1. Open Chrome browser
    //2. Go to https://www.apple.com
    //3. Click to iPhone
    //4. Print out the texts of all links
    //5. Print out how many link is missing text
    //6. Print out how many link has text
    //7. Print out how many total link
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.apple.com";
        driver.get(url);
        WebElement iphone = driver.findElement(By.xpath("//div[@class='tile tile-bg-iphone13']"));
        iphone.click();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        int missingText = 0;
        for (WebElement eachLink: links){
            System.out.println(eachLink.getText());
            if(eachLink.getText().isEmpty()){
                missingText++;
            }
        }
        System.out.println("Missing text " + missingText);
        System.out.println("Links with text " + (links.size()-missingText));
        System.out.println("Total links " + links.size());
    }
}
