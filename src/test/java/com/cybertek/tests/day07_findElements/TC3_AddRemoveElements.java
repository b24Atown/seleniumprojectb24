package com.cybertek.tests.day07_findElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TC3_AddRemoveElements {

    public static void main(String[] args) {
        String url = "http://practice.cybertekschool.com/add_remove_elements/";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        //<button onclick="addElement()">Add Element</button>
        //locate and click addElement button 50 times.
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 0; i<50;i++){
            addElement.click();
        }

        //verify 50 buttons are displayed
        //<button class="added-manually" onclick="deleteElement()">Delete</button>
        List <WebElement> list = driver.findElements(By.xpath("//button[.='Delete']"));
        System.out.println(list.size() + " count of delete buttons");

        if(list.size()==50){
            System.out.println("Pass: 50 buttons added successfully");
        }else {
            System.out.println("Fail: 50 buttons not added");
        }

        //click all delete buttons to remove them
//        for(WebElement eachElement: list){
//            eachElement.click();
//        }
        //lambda way.
         list.forEach(eachButton -> eachButton.click());

        //run findElements for delete buttons again to see if it is 0
        list =  driver.findElements(By.xpath("//button[.='Delete']"));
        if(list.size()==0){
            System.out.println("Pass: All 50 buttons deleted successfully");
        }else {
            System.out.println("Fail: Could not delete all 50 buttons");
        }

        driver.quit();

    }
}
