package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.google.com";
        driver.get(url);

        WebElement searchBox = driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
        searchBox.sendKeys("BD vacutainer" + Keys.ENTER);

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to("https://www.ikea.com");
        //<button class="selected svelte-j7p6va" data-cy="open-region-picker" tabindex="0"><span class="selected-site svelte-j7p6va"><span class="svelte-j7p6va">ikea.ca <span class="lang svelte-j7p6va">(en)</span></span> <svg width="16" height="9" viewBox="0 0 16 9" fill="none" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" class="svelte-cq7eil use-transition up"><path fill-rule="evenodd" clip-rule="evenodd" d="M16 1.38462L14.5455 0L8 6.23077L1.45455 0L0 1.38462L8 9L16 1.38462Z" fill="#111111"></path></svg></span></button>
//        WebElement ikea = driver.findElement(By.xpath("//button[@class='selected svelte-j7p6va']"));
//        ikea.click();
        //<button data-cy="select-region" class="option svelte-j7p6va">ikea.ca <span class="lang svelte-j7p6va">(English)</span></button>

        //<button id="onetrust-accept-btn-handler">Fine by me, I accept</button>
        Thread.sleep(1234);
        WebElement capcha = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        capcha.click();
        //<button id="onetrust-accept-btn-handler">Fine by me, I accept</button>

        WebElement ikeaCan = driver.findElement(By.xpath("//a[@class='website-link svelte-j7p6va']"));
        ikeaCan.click();

        //<button id="onetrust-accept-btn-handler">Ok</button>
        Thread.sleep(1234);
        WebElement capcha2 = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        capcha2.click();

        WebElement searchBar = driver.findElement(By.xpath("//input[@name='q']"));
        searchBar.sendKeys("couch");

        WebElement search = driver.findElement(By.cssSelector("button[type='submit']"));
        search.click();

        driver.quit();

    }
}
