package com.cybertek.tests.day08implicitwait_checkbox_radio_testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxesWithImplicitWait {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://practice.cybertekschool.com/checkboxes";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        //<input type="checkbox" name="checkbox1" id="box1">
        //click first checkbox
        WebElement checkbox1 = driver.findElement(By.name("checkbox1"));
        checkbox1.click();
        //unclick second checkbox
        WebElement checkbox2= driver.findElement(By.id("box2"));
        checkbox2.click();
        //in this instance checkbox2 was initially prechecked. if we wanted to check it for example we use isSelected() method.
        //so right now we know checkbox 2 is unclicked, because we unclicked above, we can click it with this method below.
        if(!checkbox2.isSelected()){
            checkbox2.click();
        }
        System.out.println("Checkbox1 selected? " + checkbox1.isSelected());
        System.out.println("Checkbox2 selected? " + checkbox2.isSelected());

        driver.quit();
    }

}
