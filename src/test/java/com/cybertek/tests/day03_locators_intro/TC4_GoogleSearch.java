package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_GoogleSearch {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String url = "https://www.google.com";
        driver.get(url);
        driver.manage().window().maximize();
        //locate and type apple to google search. inspect text box to see suitable things to enter by. name was a good one.
        driver.findElement(By.name("q")).sendKeys("apple");
        Thread.sleep(2000);//added it cuz comp was too fast and not loading it.
        //locate and click on search button
        driver.findElement(By.name("btnK")).click();
        //another way to do it
       // driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedTitle = "apple";

        if(actualTitle.startsWith(expectedTitle)){
            System.out.println("PASS: title match");
        }else{
            System.out.println("FAIL: title mismatched");
        }


        driver.quit();

    }
}
