package com.cybertek.tests.practice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigatingParentToChild {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.ca");
        //now locate searchfield from parent to child. we know we can just get name=q but just practicing. need to see in browser to understand it better.
        //this is destination
        //<input class="gLFyf gsfi" jsaction="paste:puy29d;" maxlength="2048" name="q" type="text" aria-autocomplete="both" aria-haspopup="false" autocapitalize="off" autocomplete="off" autocorrect="off" autofocus="" role="combobox" spellcheck="false" title="Search" value="" aria-label="Search" data-ved="0ahUKEwiL_Ii0yZj0AhVuJTQIHerMA_8Q39UDCAc">
        WebElement direct = driver.findElement(By.name("q"));
        WebElement parent = driver.findElement(By.xpath("//div[@jscontroller='vZr2rb']//input"));
        //how to get even more specific
        WebElement parentSpecific = driver.findElement(By.xpath("//div[@jscontroller='vZr2rb']//input[@name='q']"));
        WebElement grandParent = driver.findElement(By.xpath("//form[@role=\'search\']//input[@name=\'q\']"));

        driver.quit();
    }
}
