package com.cybertek.tests.day04_locators_getattribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        //locate the search field and assign to WebElement variable
        /*
        <input class="gLFyf gsfi" jsaction="paste:puy29d;" maxlength="2048" name="q" type="text" aria-autocomplete="both" aria-haspopup="false" autocapitalize="off" autocomplete="off" autocorrect="off" autofocus="" role="combobox" spellcheck="false" title="Search" value="" aria-label="Search" data-ved="0ahUKEwin7JS17-7zAhXiITQIHVTdD0sQ39UDCAY">
         */
        WebElement searchField = driver.findElement(By.name("q"));
        System.out.println("class  value = " + searchField.getAttribute("class"));
        System.out.println("max length = " + searchField.getAttribute("maxlength"));
        searchField.sendKeys("wooden spoon");//just typing  in box

        //read the value that is in the search field;
        System.out.println("current value = " + searchField.getAttribute("value"));

        //print name value of WebElement
        System.out.println("name = " + searchField.getAttribute("name"));

       // driver.quit();
    }
}
