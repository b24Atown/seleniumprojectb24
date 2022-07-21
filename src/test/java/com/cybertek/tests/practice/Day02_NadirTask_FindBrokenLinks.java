package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day02_NadirTask_FindBrokenLinks {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "http://te.dev.secureci.com/Exercise1.html";
        driver.manage().window().maximize();
        driver.get(url);
        //find the broken links
        //<area alt="495" href="MapLink.html?p=495" coords="480,256,512,288" shape="rect">
        List <WebElement> list = driver.findElements(By.xpath("//area[@shape='rect']"));

        for(WebElement eachElement: list){
            eachElement.click();
            System.out.println(eachElement.getText());
        }

    }
}
