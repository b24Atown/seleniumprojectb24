package com.cybertek.tests.day07_findElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationFormInputFields {

    public static void main(String[] args) {
        String url = "https://form.jotform.com/213106431512137";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        //<input type="text" id="first_4" name="q4_studentName[first]" class="form-textbox" data-defaultvalue="" size="10" value="" data-component="first" aria-labelledby="label_4 sublabel_4_first">

        List <WebElement> links = driver.findElements(By.cssSelector("input[type='text']"));
        System.out.println(links.size());

        links.forEach(fields ->fields.sendKeys("wooden spoon"));
        //this code is stopping working at one of the fields. how to fix
//        for(int i =0; i<links.size()-1;i++){
//            links.get(i).sendKeys("wooden spoon");
//        }
        for(WebElement input: links){
            if(input.isDisplayed()){
                input.sendKeys("wooden spoon");
            }
        }

    }
}
