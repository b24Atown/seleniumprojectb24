package com.cybertek.tests.practice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BrokenLink {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "http://te.dev.secureci.com/Exercise1.html";
        driver.get(url);
        driver.manage().window().maximize();

        //<area alt="564" href="MapLink.html?p=564" coords="768,288,800,320" shape="rect">
        List <WebElement> links = driver.findElements(By.tagName("area"));
        System.out.println(links.size());

        String badLink = "";

        for(WebElement a: links){
            String href = a.getAttribute("href");
            if(!href.contains("MapLink")){
                badLink = a.getAttribute("alt");
            }
        }

        WebElement bad = driver.findElement(By.xpath("//area[@alt='"+badLink+"']"));
        bad.click();



    }
}
