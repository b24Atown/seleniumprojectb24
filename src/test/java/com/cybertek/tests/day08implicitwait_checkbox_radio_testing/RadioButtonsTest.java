package com.cybertek.tests.day08implicitwait_checkbox_radio_testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonsTest {

    public static void main(String[] args) throws InterruptedException {
        String url = "http://practice.cybertekschool.com/radio_buttons";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //wait up to 10 seconds to find element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        //find red and click it if its not clicked
        //<input type="radio" id="red" name="color">
        WebElement red = driver.findElement(By.id("red"));
        if(!red.isSelected()){
            red.click();
        }

        //<input type="radio" id="football" name="sport">
        WebElement football = driver.findElement(By.id("football"));
        if(!football.isSelected()){
            football.click();
        }
        //verify if foottball option is selevted
        if(football.isSelected()){
            System.out.println("Pass- football is selected");
        }else {
            System.out.println("Fail - football is not selected ");
        }

        //find all radio buttons. print the count. click one by one, waiting 1 second inbetween. we can use isEnabled to check if element is active/disabled

        //<input type="radio" id="blue" name="color" checked="">
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        String [] arr = {"blue","red","yellow","black","green","basketball","football","hockey","water polo"};
        System.out.println("Number of buttons " + radioButtons.size());

        for(int i =0;i< radioButtons.size();i++) {
            radioButtons.get(i).click();
            Thread.sleep(1000);
            if(radioButtons.get(i).isEnabled()){
                System.out.println(arr[i] + " button is enabled");
            } else {
                System.out.println( arr[i] + " button is disabled");
            }
        }
        driver.quit();
    }
}
