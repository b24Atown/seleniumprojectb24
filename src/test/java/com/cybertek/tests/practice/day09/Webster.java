package com.cybertek.tests.practice.day09;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Webster extends TestBase {

    //1. Open Chrome browser
    //2. Go to https://www.merriam-webster.com/
    //3. Print out the texts of all links
    //4. Print out how many link is missing text
    //5. Print out how many link has text
    //6. Print out how many total link
    @Test
    public void marriamWebsterTest(){
        driver.get("https://www.merriam-webster.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for(int i = 0; i<links.size();i++){
            if(links.get(i).getText().isEmpty()){
                links.remove(i--);
            }
            System.out.println(links.get(i).getText());
        }
        System.out.println(links.size());
    }
}
