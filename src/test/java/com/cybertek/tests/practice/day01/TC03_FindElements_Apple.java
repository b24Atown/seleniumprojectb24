package com.cybertek.tests.practice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TC03_FindElements_Apple {
    //1. Open Chrome browser
    //2. Go to https://www.apple.com
    //3. Click to all of the headers one by one
    //a. Mac, iPad, iPhone, Watch, TV, Music, Support
    //4. Print out the titles of the each page
    //5. Print out total number of links in each page
    //6. While in each page:
    //a. Print out how many link is missing text TOTAL
    //b. Print out how many link has text TOTAL
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.apple.com";
        driver.get(url);

        //<a class="ac-gn-link ac-gn-link-mac" href="/mac/" data-analytics-title="mac">
        String [] linkList = {"mac","ipad","iphone","watch","tv and home","support"};
        int[] miss = new int[linkList.length];
        for (int i = 0; i<linkList.length;i++) {
           WebElement links = driver.findElement(By.xpath("//a[@data-analytics-title='"+linkList[i]+"']"));
            links.click();
            System.out.println("Page Title "+driver.getTitle());
            List<WebElement> numOfLinks = driver.findElements(By.tagName("a"));
            System.out.println("Total links " + numOfLinks.size());
            for(WebElement eachLink: numOfLinks){
                if(eachLink.getText().isEmpty()){
                    miss[i]++;
                }
            }
            System.out.println("Missing links " + miss[i]);
            System.out.println("Link with text " + (numOfLinks.size()-miss[i]));
            System.out.println();

        }

    }
}
